package ru.tracker.calorie_tracker.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer calories;
    @NotNull
    private Integer protein;
    @NotNull
    private Integer fat;
    @NotNull
    private Integer carbs;
}
