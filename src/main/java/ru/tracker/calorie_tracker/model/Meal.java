package ru.tracker.calorie_tracker.model;

import jakarta.persistence.*;
import lombok.*;

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
}
