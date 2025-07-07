package ru.tracker.calorie_tracker.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tracker.calorie_tracker.model.Meal;
import ru.tracker.calorie_tracker.service.meal.MealService;

import java.util.List;

@RestController
@RequestMapping("/meals")
@AllArgsConstructor
public class MealController {

    private MealService mealService;

    @PostMapping("/create")
    public Meal createMeal(@RequestBody Meal meal) {
        return mealService.save(meal);
    }

    @DeleteMapping("/delete")
    public void deleteMeal(@PathVariable Long id) {
        mealService.delete(id);
    }

    @GetMapping("/report/day/check/{id}")
    public String reportCheckCalorieForDay(@PathVariable Long id) {
        String report = "Пользователь не уложился в дневную норму калорий калории!";
        if (mealService.checkingCaloriesForDay(id)) {
            report = "Пользователь уложился в суточную норму калорий!";
        }
        return report;
    }

    @GetMapping("/report/day/{id}")
    public List<Meal> reportNutritionForDay(@PathVariable Long id) {
        return mealService.reportNutritionUserForDay(id);
    }

    @GetMapping("/report/days")
    public List<Meal> reportNutritionForDays(@PathVariable Long id) {
        return mealService.reportNutritionUserByDays(id);
    }
}
