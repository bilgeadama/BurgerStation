package com.bilgeadam.proje.validation;

import com.bilgeadam.proje.dto.FoodDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class CommentValidator {
    
    public void commentSaveValidator(FoodDto foodDto) {

    }
}
