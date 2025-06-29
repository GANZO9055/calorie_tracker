package ru.tracker.calorie_tracker.service.dish;

import ru.tracker.calorie_tracker.dto.DishDto;
import ru.tracker.calorie_tracker.model.Dish;

public interface DishService {
    Dish save(DishDto dishDto);
    void delete(Long id);
    DishDto findById(Long id);
}
