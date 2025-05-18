package ru.tracker.calorie_tracker.service.user;

import ru.tracker.calorie_tracker.model.User;

import java.util.Optional;

public interface UserService {

    User save(User user);
    void delete(Integer id);
    Optional<User> findById(Integer id);
    double calculationCalories(Integer id);
}
