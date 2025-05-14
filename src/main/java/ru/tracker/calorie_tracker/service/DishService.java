package ru.tracker.calorie_tracker.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tracker.calorie_tracker.model.Dish;
import ru.tracker.calorie_tracker.repository.DishRepository;

@Service
@AllArgsConstructor
public class DishService {

    private DishRepository dishRepository;

    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

}
