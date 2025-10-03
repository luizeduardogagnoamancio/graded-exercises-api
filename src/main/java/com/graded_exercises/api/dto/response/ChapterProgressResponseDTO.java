package com.graded_exercises.api.dto.response;

public record ChapterProgressResponseDTO(
    Long id,
    String title,
     int currentProgress,
     int totalQuestions
) {}
