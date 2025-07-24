package com.graded_exercises.api.service.impl;

import com.graded_exercises.api.dto.request.UserRegisterRequestDTO;
import com.graded_exercises.api.entity.User;
import com.graded_exercises.api.repository.UserRepository;
import com.graded_exercises.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void register(UserRegisterRequestDTO userRegisterRequestDTO) {
        userRepository.save(User.builder()
                .email(userRegisterRequestDTO.getEmail())
                .password(userRegisterRequestDTO.getPassword())
                .role(userRegisterRequestDTO.getRole())
                .build());
    }


}
