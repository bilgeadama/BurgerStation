package com.bilgeadam.proje.service.mapper;

import com.bilgeadam.proje.common.mapper.BaseMapper;
import com.bilgeadam.proje.dto.FoodDto;
import com.bilgeadam.proje.entity.Comment;
import com.bilgeadam.proje.entity.Food;
import org.mapstruct.*;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, builder = @Builder)
public interface FoodMapper extends BaseMapper<FoodDto, Food> {

    Food toEntity(UUID id);

    @AfterMapping
    default void setParentToChild(@MappingTarget Food food) {

        if (!CollectionUtils.isEmpty(food.getComments())) {
            food.getComments().forEach(comment -> {
                comment.setFood(food);
            });
        }
    }
}
