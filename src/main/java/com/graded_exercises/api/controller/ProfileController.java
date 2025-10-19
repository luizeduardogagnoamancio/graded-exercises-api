package com.graded_exercises.api.controller;

import com.graded_exercises.api.dto.request.UserAvatarRequestDTO;
import com.graded_exercises.api.dto.response.UserProfileResponseDTO;
import com.graded_exercises.api.entity.User;
import com.graded_exercises.api.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public ResponseEntity<UserProfileResponseDTO> getUserProfile(@AuthenticationPrincipal User user) {
        UserProfileResponseDTO userProfile = profileService.getUserProfile(user);
        return ResponseEntity.ok(userProfile);
    }

    @PutMapping("/avatar")
    public ResponseEntity<Void> updateAvatar(@AuthenticationPrincipal User user, @RequestBody @Valid UserAvatarRequestDTO dto) {
        profileService.updateAvatar(user, dto.avatarUrl());
        return ResponseEntity.noContent().build();
    }
}