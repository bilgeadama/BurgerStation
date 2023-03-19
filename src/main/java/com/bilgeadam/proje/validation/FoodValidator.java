package com.bilgeadam.proje.validation;

import com.bilgeadam.proje.dto.FoodDto;
import com.bilgeadam.proje.entity.FoodEntity;
import com.bilgeadam.proje.repository.FoodRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Component
@Validated
public class FoodValidator {

    private final FoodRepository foodRepository;

    public FoodValidator(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public void foodSaveValidator(@Valid FoodDto foodDto) {

        FoodEntity food = foodRepository.findByIgnoreCaseTitle(foodDto.getTitle());
        if (Objects.nonNull(food)) {
            throw new RuntimeException("This Food has benn added");
        }
    }
}
