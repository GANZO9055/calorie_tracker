package ru.tracker.calorie_tracker.mapper;

import org.springframework.stereotype.Component;
import ru.tracker.calorie_tracker.dto.DishDto;
import ru.tracker.calorie_tracker.dto.Goal;
import ru.tracker.calorie_tracker.dto.UserDto;
import ru.tracker.calorie_tracker.model.Dish;
import ru.tracker.calorie_tracker.model.User;

@Component
public class Mapper {

    public User mappingUserDtoToUserEntity(UserDto userDto) {
        String value = "";
        switch (userDto.getGoal()) {
            case WEIGHT_LOSS -> value = "WEIGHT LOSS";
            case MAINTENANCE -> value = "MAINTENANCE";
            case WEIGHT_GAIN -> value = "WEIGHT GAIN";

        }
        return new User(
                userDto.getName(),
                userDto.getEmail(),
                userDto.getAge(),
                userDto.getWeight(),
                userDto.getHeight(),
                value,
                userDto.getPassword()
        );
    }

    public UserDto mappingUserEntityToUserDto(User user) {
        Goal value = Goal.MAINTENANCE;
        switch (user.getGoal()) {
            case "WEIGHT LOSS" -> value = Goal.WEIGHT_LOSS;
            case "WEIGHT GAIN" -> value = Goal.WEIGHT_GAIN;

        }
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .age(user.getAge())
                .weight(user.getWeight())
                .height(user.getHeight())
                .goal(value)
                .password(user.getPassword())
                .build();
    }

    public UserDto mappingUserEntityToUserDtoWithListDish(User user) {
        Goal value = Goal.MAINTENANCE;
        switch (user.getGoal()) {
            case "WEIGHT LOSS" -> value = Goal.WEIGHT_LOSS;
            case "WEIGHT GAIN" -> value = Goal.WEIGHT_GAIN;

        }
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .age(user.getAge())
                .weight(user.getWeight())
                .height(user.getHeight())
                .goal(value)
                .password(user.getPassword())
                .dishes(user.getDishes())
                .build();
    }

    public Dish mappingDishDtoToDishEntity(DishDto dishDto) {
        return new Dish(
                dishDto.getName(),
                dishDto.getCalories(),
                dishDto.getProtein(),
                dishDto.getFat(),
                dishDto.getCarbs()
        );
    }

    public DishDto mappingDishEntityToDishDto(Dish dish) {
        return new DishDto(
                dish.getId(),
                dish.getName(),
                dish.getCalories(),
                dish.getProtein(),
                dish.getFat(),
                dish.getCarbs()
        );
    }
}
