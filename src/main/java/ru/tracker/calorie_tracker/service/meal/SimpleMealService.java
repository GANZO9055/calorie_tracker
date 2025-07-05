package ru.tracker.calorie_tracker.service.meal;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tracker.calorie_tracker.dto.UserDto;
import ru.tracker.calorie_tracker.model.Dish;
import ru.tracker.calorie_tracker.model.Meal;
import ru.tracker.calorie_tracker.model.User;
import ru.tracker.calorie_tracker.repository.MealRepository;
import ru.tracker.calorie_tracker.service.user.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleMealService implements MealService {

    private MealRepository mealRepository;
    private UserService userService;

    @Override
    public Meal save(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public void delete(Long id) {
        mealRepository.deleteById(id);
    }

    @Override
    public boolean checkingCaloriesForDay(Long id) {
        UserDto userDto = userService.findByIdWithList(id);
        userDto = userService.calculationCaloriesForUserById(userDto.getId());
        double sumCalorie = calculationCaloriesForDishes(userDto.getDishes());
        return userDto.getCalorie() == sumCalorie;
    }

    private double calculationCaloriesForDishes(List<Dish> dishList) {
        double valueCalories = 0.0;
        for (Dish dish : dishList) {
            valueCalories += dish.getCalories();
        }
        return valueCalories;
    }
}
