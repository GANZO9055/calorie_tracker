package ru.tracker.calorie_tracker.service.dish;

import ru.tracker.calorie_tracker.model.Dish;
import ru.tracker.calorie_tracker.model.User;

import java.util.Optional;

public interface DishService {
    Dish save(Dish dish);
    void delete(Integer id);
    Optional<Dish> findById(Integer id);
}
