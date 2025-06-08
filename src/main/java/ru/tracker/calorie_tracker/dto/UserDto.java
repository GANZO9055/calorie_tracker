package ru.tracker.calorie_tracker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    private int id;
    private String name;
    private String email;
    private int age;
    private double weight;
    private double height;
    private Goal goal;
    private double calorie;
}


