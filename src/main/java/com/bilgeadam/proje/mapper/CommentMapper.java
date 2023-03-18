package com.bilgeadam.proje.mapper;

import com.bilgeadam.proje.common.mapper.BaseMapper;
import com.bilgeadam.proje.dto.CommentDto;
import com.bilgeadam.proje.entity.Comment;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, builder = @Builder)
public interface CommentMapper extends BaseMapper<CommentDto, Comment> {

}
