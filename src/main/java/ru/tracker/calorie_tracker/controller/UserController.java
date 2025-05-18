package ru.tracker.calorie_tracker.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.tracker.calorie_tracker.service.user.UserService;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

}
