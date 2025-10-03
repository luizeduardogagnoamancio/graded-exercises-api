package com.graded_exercises.api.controller;

import com.graded_exercises.api.dto.response.UserProfileResponseDTO;
import com.graded_exercises.api.entity.User;
import com.graded_exercises.api.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
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
}