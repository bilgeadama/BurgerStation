package com.bilgeadam.proje.controller;

import com.bilgeadam.proje.dto.UserDto;
import com.bilgeadam.proje.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-all-users")
    ResponseEntity<List<UserDto>> getAllUsers(){

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get-by-id")
    ResponseEntity<UserDto> getById(UUID userId){

        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }

    @GetMapping("/get-by-name")
    ResponseEntity<UserDto> getByUserName(@RequestParam(value = "userName") String userName){

        return new ResponseEntity<>(userService.findByUserName(userName), HttpStatus.OK);
    }


}
