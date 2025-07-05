package ru.tracker.calorie_tracker.service.user;

import ru.tracker.calorie_tracker.dto.UserDto;
import ru.tracker.calorie_tracker.model.User;

public interface FindUserWithListAndNotList {
    User findById(Long id);
    UserDto findByIdNotList(Long id);
    UserDto findByIdWithList(Long id);
}
