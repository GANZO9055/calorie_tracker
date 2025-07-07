package ru.tracker.calorie_tracker.service.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.tracker.calorie_tracker.dto.Goal;
import ru.tracker.calorie_tracker.dto.UserDto;
import ru.tracker.calorie_tracker.model.User;
import ru.tracker.calorie_tracker.repository.UserRepository;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SimpleUserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Test
    public void whenSaveUserThenCheckUserByEmail() {
        UserDto user = UserDto.builder()
                .name("name")
                .email("email")
                .age(27)
                .weight(78.8)
                .height(187.0)
                .goal(Goal.MAINTENANCE)
                .password("123")
                .build();

        User savedUser = userService.save(user);

        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getEmail()).isEqualTo("email");
    }

    @Test
    public void whenSaveUserThenFindUserById() {
        UserDto user = UserDto.builder()
                .name("name")
                .email("test@email")
                .age(27)
                .weight(80.8)
                .height(190.0)
                .goal(Goal.WEIGHT_GAIN)
                .password("password123")
                .build();

        User savedUser = userService.save(user);
        UserDto userDto = userService.findByIdNotList(savedUser.getId());

        assertThat(userDto.getEmail()).isEqualTo(user.getEmail());
        assertThat(userDto.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    public void whenSaveUserThenCalculationCalories() {
        UserDto user = UserDto.builder()
                .name("name")
                .email("test@email")
                .age(27)
                .weight(80.8)
                .height(190.0)
                .goal(Goal.WEIGHT_GAIN)
                .password("password123")
                .build();

        User savedUser = userService.save(user);
        UserDto userDto = userService.calculationCaloriesForUserById(savedUser.getId());

        assertThat(userDto.getCalorie()).isEqualTo(1898.58);
    }
}