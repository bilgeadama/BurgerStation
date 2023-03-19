package com.bilgeadam.proje.service.mapper;

import com.bilgeadam.proje.common.mapper.BaseMapper;
import com.bilgeadam.proje.dto.FoodDto;
import com.bilgeadam.proje.entity.CommentEntity;
import com.bilgeadam.proje.entity.FoodEntity;
import org.mapstruct.*;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, builder = @Builder)
public interface FoodMapper extends BaseMapper<FoodDto, FoodEntity> {

    @AfterMapping
    default void setParentToChild(@MappingTarget FoodEntity food) {

        Set<CommentEntity> commentEntitySet = new HashSet<>();
        food.getCommentEntities().forEach(comment -> {
            comment.setFood(food);
            commentEntitySet.add(comment);
        });
        food.setCommentEntities(commentEntitySet);
    }
}
