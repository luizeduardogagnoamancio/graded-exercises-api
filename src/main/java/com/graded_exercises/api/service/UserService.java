package com.graded_exercises.api.service;

import com.graded_exercises.api.dto.request.UserRegisterRequestDTO;

public interface UserService {
    void register(UserRegisterRequestDTO userRegisterRequestDTO);
}
