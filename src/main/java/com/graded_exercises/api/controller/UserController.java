package com.graded_exercises.api.controller;

import com.graded_exercises.api.dto.request.UserRegisterRequestDTO;
import com.graded_exercises.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO) {
        log.info("Request registerUser: {}", userRegisterRequestDTO);
        userService.register(userRegisterRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
