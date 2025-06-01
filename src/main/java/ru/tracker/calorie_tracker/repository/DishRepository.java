package ru.tracker.calorie_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tracker.calorie_tracker.model.Dish;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
