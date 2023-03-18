package com.bilgeadam.proje.mapper;

import com.bilgeadam.proje.common.mapper.BaseMapper;
import com.bilgeadam.proje.dto.UserDto;
import com.bilgeadam.proje.entity.User;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, builder = @Builder)
public interface UserMapper extends BaseMapper<UserDto, User> {

}
