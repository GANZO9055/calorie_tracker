package ru.tracker.calorie_tracker.service.dish;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tracker.calorie_tracker.model.Dish;
import ru.tracker.calorie_tracker.repository.DishRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleDishService implements DishService {

    private DishRepository dishRepository;

    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    public void delete(Integer id) {
        dishRepository.deleteById(id);
    }

    public Optional<Dish> findById(Integer id) {
        return dishRepository.findById(id);
    }

}
