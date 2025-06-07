package ru.tracker.calorie_tracker.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tracker.calorie_tracker.dto.DishDto;
import ru.tracker.calorie_tracker.model.Dish;
import ru.tracker.calorie_tracker.service.dish.DishService;

@RestController
@RequestMapping("/dishes")
@AllArgsConstructor
public class DishController {

    private DishService dishService;

    @PostMapping("/create")
    public void createDish(@RequestBody DishDto dishDto) {
        dishService.save(dishDto);
    }

    @GetMapping("/{id}")
    public void findDishById(@PathVariable Long id) {
        dishService.findById(id);
    }

}
