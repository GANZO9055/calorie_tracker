package ru.tracker.calorie_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {
    private int id;
    private String name;
    private String email;
    private int age;
    private double weight;
    private double height;
    private Goal goal;
}
