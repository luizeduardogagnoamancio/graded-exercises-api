package com.graded_exercises.api.controller;

import com.graded_exercises.api.dto.request.UserLoginRequestDTO;
import com.graded_exercises.api.dto.request.UserRegisterRequestDTO;
import com.graded_exercises.api.dto.response.UserLoginResponseDTO;
import com.graded_exercises.api.infra.security.TokenService;
import com.graded_exercises.api.repository.UserRepository;
import com.graded_exercises.api.service.AuthenticationService;
import com.graded_exercises.api.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRegisterRequestDTO userRegisterRequestDTO) throws BadRequestException {
        log.info("Request registerUser: {}", userRegisterRequestDTO);
        authenticationService.register(userRegisterRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDTO> login(@RequestBody @Valid UserLoginRequestDTO userLoginRequestDto) {
        return ResponseEntity.ok(authenticationService.login(userLoginRequestDto));
    }
}
