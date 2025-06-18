package ru.tracker.calorie_tracker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
    private Double calorie;
}


