package ru.tracker.calorie_tracker.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tracker.calorie_tracker.dto.UserDto;
import ru.tracker.calorie_tracker.model.User;
import ru.tracker.calorie_tracker.service.user.UserService;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public User createUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/calorie/{id}")
    public UserDto getCalculationCaloriesUser(@PathVariable Long id) {
        return userService.calculationCaloriesForUserById(id);
    }
}
