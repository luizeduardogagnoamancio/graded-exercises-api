package com.graded_exercises.api.service.impl;

import com.graded_exercises.api.dto.request.UserLoginRequestDTO;
import com.graded_exercises.api.dto.request.UserRegisterRequestDTO;
import com.graded_exercises.api.dto.response.UserLoginResponseDTO;
import com.graded_exercises.api.entity.User;
import com.graded_exercises.api.infra.security.TokenService;
import com.graded_exercises.api.repository.UserRepository;
import com.graded_exercises.api.service.AuthenticationService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    public UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDto) {
        Authentication auth = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginRequestDto.getEmail(),
                userLoginRequestDto.getPassword()));

        return new UserLoginResponseDTO(tokenService.generateToken((User) auth.getPrincipal()));
    }

    @Override
    public void register(UserRegisterRequestDTO userRegisterRequestDTO) throws BadRequestException {
        if (this.userRepository.findByEmail(userRegisterRequestDTO.getEmail()) != null) {
            throw new BadRequestException("Email já utilizado");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(userRegisterRequestDTO.getPassword());
        User user = new User(userRegisterRequestDTO.getEmail(), encryptedPassword, userRegisterRequestDTO.getRole(), userRegisterRequestDTO.getName());

        this.userRepository.save(user);
    }
}
