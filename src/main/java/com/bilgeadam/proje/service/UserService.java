package com.bilgeadam.proje.service;

import com.bilgeadam.proje.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDto saveUser(UserDto UserDto);

    List<UserDto> saveAllUsers(List<UserDto> UserDtoList);

    List<UserDto> findAll();

    UserDto findById(UUID uuid);

    UserDto findByUsername(String userName);

    void delete(UserDto UserDto);

    void deleteById(UUID uuid);

    void deleteAll(List<UserDto> UserDtos);

    void makePayment(int spent);

    void registerUser(UserDto userDto);

    void makeAdmin(UUID id);

    void removeAdmin(UUID id);

    void enableUser(UUID id);

    void disableUser(UUID id);

}
