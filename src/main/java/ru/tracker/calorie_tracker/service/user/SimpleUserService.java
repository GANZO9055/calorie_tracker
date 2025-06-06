package ru.tracker.calorie_tracker.service.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tracker.calorie_tracker.dto.UserDto;
import ru.tracker.calorie_tracker.exception.NotFoundException;
import ru.tracker.calorie_tracker.mapper.Mapper;
import ru.tracker.calorie_tracker.model.User;
import ru.tracker.calorie_tracker.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleUserService implements UserService {

    private UserRepository userRepository;
    private Mapper mapper;

    public User save(UserDto userDto) {
        return userRepository.save(
                mapper.mappingUserDtoToUserEntity(userDto)
        );
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
           throw new NotFoundException("User not found by id: " + id);
        }
        return userOptional.get();
    }

    /**
     * Производит расчет дневной нормы калорий
     * по формуле Харриса-Бенедикта
     * @return double
     */
    public double calculationCalories(UserDto userDto) {
        double calorie = 88.36
                + (13.4 * userDto.getWeight())
                + (4.8 + userDto.getHeight())
                + (5.7 + userDto.getAge());
        switch (userDto.getGoal()) {
            case WEIGHT_LOSS -> calorie = calorie - 500;
            case MAINTENANCE -> calorie = calorie + 0;
            case WEIGHT_GAIN -> calorie = calorie + 500;
        }
        return calorie;
    }
}
