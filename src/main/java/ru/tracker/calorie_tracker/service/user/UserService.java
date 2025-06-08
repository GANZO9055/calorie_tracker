package ru.tracker.calorie_tracker.service.user;

import ru.tracker.calorie_tracker.dto.UserDto;
import ru.tracker.calorie_tracker.model.User;

import java.util.Optional;

public interface UserService {

    User save(UserDto userDto);
    void delete(Long id);
    UserDto findById(Long id);
    UserDto calculationCaloriesForUserById(Long id);
}
