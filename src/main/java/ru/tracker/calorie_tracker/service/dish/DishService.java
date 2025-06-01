package ru.tracker.calorie_tracker.service.dish;

import ru.tracker.calorie_tracker.dto.DishDto;
import ru.tracker.calorie_tracker.model.Dish;
import ru.tracker.calorie_tracker.model.User;

import java.util.Optional;

public interface DishService {
    Dish save(DishDto dishDto);
    void delete(Long id);
    Optional<Dish> findById(Long id);
}
