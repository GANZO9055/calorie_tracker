package ru.tracker.calorie_tracker.service.dish;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.tracker.calorie_tracker.dto.DishDto;
import ru.tracker.calorie_tracker.exception.NotFoundException;
import ru.tracker.calorie_tracker.model.Dish;
import ru.tracker.calorie_tracker.repository.DishRepository;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SimpleDishServiceTest {

    @Autowired
    private DishService dishService;

    @Autowired
    private DishRepository dishRepository;

    @BeforeEach
    public void deleteAll() {
        dishRepository.deleteAll();
    }

    @Test
    public void whenSaveDishWhenCheckDishByName() {
        DishDto dish = new DishDto(
                10L,
                "бекон",
                200,
                13,
                7,
                8
        );

        Dish savedDish = dishService.save(dish);

        assertThat(savedDish.getId()).isNotNull();
        assertThat(savedDish.getName()).isEqualTo("бекон");
    }

    @Test
    public void whenSaveDishWhenFindById() {
        DishDto dish = new DishDto(
                14L,
                "пирог",
                25,
                20,
                3,
                87
        );

        Dish savedDish = dishService.save(dish);
        DishDto dishDto = dishService.findById(savedDish.getId());

        assertThat(dishDto.getName()).isEqualTo("пирог");
    }

    @Test
    public void whenSaveDishWhenCheckForAnException() {
        DishDto dish = new DishDto(
                15L,
                "яблочный пирог",
                30,
                25,
                6,
                68
        );

        Dish savedDish = dishService.save(dish);
        Assertions.assertThrows(
                NotFoundException.class,
                () -> dishService.findById(35L),
                "Dish not found by id: 35");
    }
}