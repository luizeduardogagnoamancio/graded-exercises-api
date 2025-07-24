package com.graded_exercises.api.controller;

import com.graded_exercises.api.dto.request.UserLoginRequestDTO;
import com.graded_exercises.api.dto.request.UserRegisterRequestDTO;
import com.graded_exercises.api.entity.User;
import com.graded_exercises.api.infra.security.TokenService;
import com.graded_exercises.api.repository.UserRepository;
import com.graded_exercises.api.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRegisterRequestDTO userRegisterRequestDTO) {
        if (this.userRepository.findByEmail(userRegisterRequestDTO.getEmail()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(userRegisterRequestDTO.getPassword());
        User user = new User(userRegisterRequestDTO.getEmail(), encryptedPassword, userRegisterRequestDTO.getRole());

        this.userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.OK);
        /*
        log.info("Request registerUser: {}", userRegisterRequestDTO);
        userService.register(userRegisterRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);

         */
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserLoginRequestDTO userLoginRequestDto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(userLoginRequestDto.getEmail(), userLoginRequestDto.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(token);

    }
}
