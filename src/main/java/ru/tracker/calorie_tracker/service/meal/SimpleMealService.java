package ru.tracker.calorie_tracker.service.meal;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tracker.calorie_tracker.model.Meal;
import ru.tracker.calorie_tracker.repository.MealRepository;

@Service
@AllArgsConstructor
public class SimpleMealService implements MealService {

    private MealRepository mealRepository;

    @Override
    public Meal save(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public void delete(Long id) {
        mealRepository.deleteById(id);
    }
}
