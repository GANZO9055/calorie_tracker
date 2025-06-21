package ru.tracker.calorie_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tracker.calorie_tracker.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
