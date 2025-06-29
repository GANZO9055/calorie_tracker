package ru.tracker.calorie_tracker.service.dish;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tracker.calorie_tracker.dto.DishDto;
import ru.tracker.calorie_tracker.exception.NotFoundException;
import ru.tracker.calorie_tracker.mapper.Mapper;
import ru.tracker.calorie_tracker.model.Dish;
import ru.tracker.calorie_tracker.repository.DishRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleDishService implements DishService {

    private DishRepository dishRepository;
    private Mapper mapper;

    public Dish save(DishDto dishDto) {
        return dishRepository.save(
                mapper.mappingDishDtoToDishEntity(dishDto)
        );
    }

    public void delete(Long id) {
        dishRepository.deleteById(id);
    }

    public DishDto findById(Long id) {
        Optional<Dish> dishOptional = dishRepository.findById(id);
        if (dishOptional.isEmpty()) {
            throw new NotFoundException("Dish not found by id: " + id);
        }
        return mapper.mappingDishEntityToDishDto(
                dishOptional.get()
        );
    }
}
