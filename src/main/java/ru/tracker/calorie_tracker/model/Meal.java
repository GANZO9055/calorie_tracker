package ru.tracker.calorie_tracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "food_intake")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;
    @Column(name = "time_of_addition")
    private final LocalDateTime timeOfAddition = LocalDateTime.now();
}
