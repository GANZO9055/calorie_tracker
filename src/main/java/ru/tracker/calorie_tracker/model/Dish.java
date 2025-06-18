package ru.tracker.calorie_tracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "dishs")
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Integer calories;
    @NonNull
    private Integer protein;
    @NonNull
    private Integer fat;
    @NonNull
    private Integer carbs;

    @ManyToMany(mappedBy = "dishes")
    private List<User> users;
}
