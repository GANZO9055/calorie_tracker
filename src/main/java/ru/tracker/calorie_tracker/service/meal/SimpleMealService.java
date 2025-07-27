package ru.tracker.calorie_tracker.service.meal;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.tracker.calorie_tracker.dto.UserDto;
import ru.tracker.calorie_tracker.model.Dish;
import ru.tracker.calorie_tracker.model.Meal;
import ru.tracker.calorie_tracker.repository.MealRepository;
import ru.tracker.calorie_tracker.service.user.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class SimpleMealService implements MealService {

    private MealRepository mealRepository;
    private UserService userService;
    private KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "save_meal")
    public void saveMeal(Meal meal) {
        save(meal);
    }

    @Override
    public Meal save(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public void delete(Long id) {
        mealRepository.deleteById(id);
    }

    @Override
    public List<Meal> reportNutritionUserForDay(Long id) {
        LocalDateTime dateTime = LocalDateTime.now();
        List<Meal> mealList = mealRepository.findByUserIdAndTimeOfAddition(id, dateTime);
        kafkaTemplate.send("reportNutritionForDay", mealList);
        return mealList;
    }

    @Override
    public boolean checkingCaloriesForDay(Long id) {
        UserDto userDto = userService.findByIdWithList(id);
        UserDto userCalculation = userService.calculationCaloriesForUserById(userDto.getId());
        double sumCalorie = calculationCaloriesForDishes(userDto.getDishes());
        boolean checkingCalorie = userCalculation.getCalorie() <= sumCalorie;
        kafkaTemplate.send("checkingCalorie", checkingCalorie);
        return checkingCalorie;
    }

    @Override
    public List<Meal> reportNutritionUserByDays(Long id) {
        List<Meal> mealList = mealRepository.findByUserIdOrderByTimeOfAdditionDesc(id);
        kafkaTemplate.send("reportNutritionForDays", mealList);
        return mealList;
    }


    private double calculationCaloriesForDishes(List<Dish> dishList) {
        double valueCalories = 0.0;
        for (Dish dish : dishList) {
            valueCalories += dish.getCalories();
        }
        return valueCalories;
    }
}
