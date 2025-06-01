package ru.tracker.calorie_tracker.mapper;

import org.springframework.stereotype.Component;
import ru.tracker.calorie_tracker.dto.DishDto;
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
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getAge(),
                userDto.getWeight(),
                userDto.getHeight(),
                value
        );
    }

    public Dish mappingDishDtoToDishEntity(DishDto dishDto) {
        return new Dish(
                dishDto.getId(),
                dishDto.getName(),
                dishDto.getCalories(),
                dishDto.getProtein(),
                dishDto.getFat(),
                dishDto.getCarbs()
        );
    }
}
