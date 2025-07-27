package ru.tracker.calorie_tracker.service.user;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
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
    private KafkaTemplate<String, User> kafkaTemplate;

    @KafkaListener(topics = "create_user")
    public void create(UserDto userDto) {
        save(userDto);
    }

    @Override
    public User save(UserDto userDto) {
        return userRepository.save(
                mapper.mappingUserDtoToUserEntity(userDto)
        );
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
           throw new NotFoundException("User not found by id: " + id);
        }
        return userOptional.get();
    }

    @Override
    public UserDto findByIdNotList(Long id) {
        return mapper.mappingUserEntityToUserDto(findById(id));
    }

    @Override
    public UserDto findByIdWithList(Long id) {
        return mapper.mappingUserEntityToUserDtoWithListDish(findById(id));
    }

    /**
     * Производит расчет дневной нормы калорий
     * по формуле Харриса-Бенедикта
     * @return double
     */
    @Override
    public UserDto calculationCaloriesForUserById(Long id) {
        UserDto userDto = findByIdNotList(id);
        double calorie = 88.36
                + (13.4 * userDto.getWeight())
                + (4.8 + userDto.getHeight())
                + (5.7 + userDto.getAge());
        switch (userDto.getGoal()) {
            case WEIGHT_LOSS -> calorie = calorie - 500;
            case MAINTENANCE -> calorie = calorie + 0;
            case WEIGHT_GAIN -> calorie = calorie + 500;
        }
        userDto.setCalorie(calorie);
        return userDto;
    }
}
