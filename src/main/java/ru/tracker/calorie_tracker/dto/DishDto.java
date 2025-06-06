package ru.tracker.calorie_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {
    private int id;
    private String name;
    private int calories;
    private int protein;
    private int fat;
    private int carbs;
}
