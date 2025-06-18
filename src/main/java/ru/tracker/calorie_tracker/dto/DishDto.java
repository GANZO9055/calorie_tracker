package ru.tracker.calorie_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {
    private Long id;
    private String name;
    private Integer calories;
    private Integer protein;
    private Integer fat;
    private Integer carbs;
}
