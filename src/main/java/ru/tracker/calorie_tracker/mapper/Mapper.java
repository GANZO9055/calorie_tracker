package ru.tracker.calorie_tracker.mapper;

import ru.tracker.calorie_tracker.dto.UserDto;
import ru.tracker.calorie_tracker.model.User;

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
}
