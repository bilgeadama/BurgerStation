package com.bilgeadam.proje.validation;

import com.bilgeadam.proje.dto.FoodDto;
import com.bilgeadam.proje.entity.Food;
import com.bilgeadam.proje.repository.FoodRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Component
@Validated
public class FoodValidator {

    private final FoodRepository foodRepository;

    public FoodValidator(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public void foodSaveValidator(@Valid FoodDto foodDto) {

        List<Food> food = foodRepository.findByTitleContainingIgnoreCase(foodDto.getTitle());
        if (!CollectionUtils.isEmpty(food)) {
            throw new RuntimeException("This Food has been added before");
        }
    }


}
