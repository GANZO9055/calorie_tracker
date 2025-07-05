package ru.tracker.calorie_tracker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.tracker.calorie_tracker.model.Dish;

import java.util.List;

@Getter
@Setter
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private Double weight;
    private Double height;
    private Goal goal;
    private String password;
    private Double calorie;
    private List<Dish> dishes;
}


