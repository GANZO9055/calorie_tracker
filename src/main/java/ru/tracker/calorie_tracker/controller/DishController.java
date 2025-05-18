package ru.tracker.calorie_tracker.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.tracker.calorie_tracker.service.dish.DishService;

@RestController
@AllArgsConstructor
public class DishController {

    private DishService dishService;

}
