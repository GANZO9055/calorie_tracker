package ru.tracker.calorie_tracker.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ru.tracker.calorie_tracker.model.Dish;

import java.util.List;

@Getter
@Setter
@Builder
public class UserDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;
    @NotNull
    private Double weight;
    @NotNull
    private Double height;
    @NotNull
    private Goal goal;
    @NotNull
    @Size(min = 8, max = 20, message = "Password must have least 8 characters and no more then 20")
    private String password;
    private Double calorie;
    private List<Dish> dishes;
}


