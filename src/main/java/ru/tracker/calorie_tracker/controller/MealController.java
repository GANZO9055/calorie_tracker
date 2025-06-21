package ru.tracker.calorie_tracker.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tracker.calorie_tracker.model.Meal;
import ru.tracker.calorie_tracker.service.meal.MealService;

@RestController
@RequestMapping("/meals")
@AllArgsConstructor
public class MealController {

    private MealService mealService;

    @PostMapping("/createMeal")
    public Meal createMeal(@RequestBody Meal meal) {
        return mealService.save(meal);
    }

    @DeleteMapping("/delete")
    public void deleteMeal(@PathVariable Long id) {
        mealService.delete(id);
    }
}
