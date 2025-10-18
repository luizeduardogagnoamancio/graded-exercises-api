package com.graded_exercises.api.service;

import com.graded_exercises.api.dto.response.UserProfileResponseDTO;
import com.graded_exercises.api.entity.User;

public interface ProfileService {
    UserProfileResponseDTO getUserProfile(User user);
    void updateAvatar(User user, String avatarUrl);
}