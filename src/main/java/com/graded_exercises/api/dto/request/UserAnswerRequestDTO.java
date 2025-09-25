package com.graded_exercises.api.dto.request;

import jakarta.validation.constraints.NotNull;

public record UserAnswerRequestDTO(@NotNull Long questionId, @NotNull Boolean isCorrect) {

}
