package ru.tracker.calorie_tracker.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tracker.calorie_tracker.model.User;
import ru.tracker.calorie_tracker.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    /**
     * Производит расчет дневной нормы калорий
     * по формуле Харриса-Бенедикта
     * @return double
     */
    public double calculationCalories(Integer id) {
        Optional<User> userOptional = findById(id);
        if (userOptional.isEmpty()) {
            return 0.0;
        }
        User user = userOptional.get();
        double calorie = 88.36
                + (13.4 * user.getWeight())
                + (4.8 + user.getHeight())
                + (5.7 + user.getAge());
        switch (user.getGoal()) {
            case WEIGHT_LOSS -> calorie = calorie - 500;
            case MAINTENANCE -> calorie = calorie + 0;
            case WEIGHT_GAIN -> calorie = calorie + 500;
        }
        return calorie;
    }
}
