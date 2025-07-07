package ru.tracker.calorie_tracker.service.meal;

import ru.tracker.calorie_tracker.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface MealService {
    Meal save(Meal meal);
    void delete(Long id);
    boolean checkingCaloriesForDay(Long id);
    List<Meal> reportNutritionUserByDays(Long id);
    List<Meal> reportNutritionUserForDay(Long id);
}
