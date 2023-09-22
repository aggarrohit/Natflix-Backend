package com.novare.natflix.controllers;

import com.novare.natflix.dtos.UserDto;
import com.novare.natflix.mappers.UserMapper;
import com.novare.natflix.models.User;
import com.novare.natflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    UserService userService;

    @PostMapping
    ResponseEntity<UserDto> registerUser(@RequestBody User user){
        userService.addAdmin();
        return ResponseEntity.status(201).body(UserMapper.toUserDto(userService.addUser(user)));
    }

}
