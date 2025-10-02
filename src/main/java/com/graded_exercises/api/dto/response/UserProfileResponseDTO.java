package com.graded_exercises.api.dto.response;

import java.time.LocalDateTime;

public record UserProfileResponseDTO(
        String name,
        String email,
        LocalDateTime memberSince,
        int completedChapters,
        int totalChapters,
        double overallAccuracy
) {}