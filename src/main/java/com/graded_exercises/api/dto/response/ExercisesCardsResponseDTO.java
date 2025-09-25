package com.graded_exercises.api.dto.response;

public record ExercisesCardsResponseDTO(Long id,
                                        String title,
                                        String description,
                                        int currentProgress,
                                        int totalLessons) {
}
