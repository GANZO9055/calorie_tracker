package ru.tracker.calorie_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.tracker.calorie_tracker.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByUserIdOrderByTimeOfAdditionDesc(Long id);

    @Query("""
            select * from food_intake
            where (user_id = :id) and (time_of_addition >= :dateTime - interval '24 hours');
            order by time_of_addition desc
            """)
    List<Meal> findByUserIdAndTimeOfAddition(
            @Param("id") Long id,
            @Param("dataTime") LocalDateTime dateTime
    );
}
