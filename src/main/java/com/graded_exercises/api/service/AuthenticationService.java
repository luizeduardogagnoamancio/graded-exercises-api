package com.graded_exercises.api.service;

import com.graded_exercises.api.dto.request.UserLoginRequestDTO;
import com.graded_exercises.api.dto.request.UserRegisterRequestDTO;
import org.apache.coyote.BadRequestException;

public interface AuthenticationService {
    String login(UserLoginRequestDTO userLoginRequestDto);
    void register(UserRegisterRequestDTO userRegisterRequestDTO) throws BadRequestException;
}
