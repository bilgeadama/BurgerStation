package com.bilgeadam.proje.service.mapper;

import com.bilgeadam.proje.common.mapper.BaseMapper;
import com.bilgeadam.proje.dto.CommentDto;
import com.bilgeadam.proje.entity.Comment;
import com.bilgeadam.proje.entity.Food;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(componentModel = "spring",uses = {FoodMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, builder = @Builder)
public interface CommentMapper extends BaseMapper<CommentDto, Comment> {

    @Mapping(target ="food" ,source = "foodId")
    Comment dtoToEntity(CommentDto commentDto);
}
