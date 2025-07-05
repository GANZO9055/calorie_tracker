package ru.tracker.calorie_tracker.service.user;

import ru.tracker.calorie_tracker.dto.UserDto;
import ru.tracker.calorie_tracker.model.User;

public interface UserService extends FindUserWithListAndNotList {

    User save(UserDto userDto);
    void delete(Long id);
    UserDto calculationCaloriesForUserById(Long id);
}
