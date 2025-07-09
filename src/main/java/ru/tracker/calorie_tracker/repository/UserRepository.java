package ru.tracker.calorie_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tracker.calorie_tracker.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
