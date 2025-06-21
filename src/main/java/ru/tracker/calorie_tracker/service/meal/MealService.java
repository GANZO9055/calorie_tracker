package ru.tracker.calorie_tracker.service.meal;

import ru.tracker.calorie_tracker.model.Meal;

public interface MealService {
    Meal save(Meal meal);
    void delete(Long id);
}
