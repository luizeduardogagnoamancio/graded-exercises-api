package com.graded_exercises.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record UserProfileResponseDTO(
        String name,
        String email,
        LocalDateTime memberSince,
        int completedChapters,
        int totalChapters,
        int dailyStreak,
        List<ChapterProgressResponseDTO> chapterProgress
) {}