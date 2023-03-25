package com.bilgeadam.proje.service.mapper;

import com.bilgeadam.proje.common.mapper.BaseMapper;
import com.bilgeadam.proje.dto.FoodDto;
import com.bilgeadam.proje.entity.Comment;
import com.bilgeadam.proje.entity.Food;
import org.mapstruct.*;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, builder = @Builder)
public interface FoodMapper extends BaseMapper<FoodDto, Food> {

    @AfterMapping
    default void setParentToChild(@MappingTarget Food food) {

        Set<Comment> commentSet = new HashSet<>();
        food.getComments().forEach(comment -> {
            comment.setFood(food);
            commentSet.add(comment);
        });
        food.setComments(commentSet);

    }

}
