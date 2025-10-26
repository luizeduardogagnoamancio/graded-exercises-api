package com.graded_exercises.api.dto.request;

import com.graded_exercises.api.enums.QuestionType;
import jakarta.validation.constraints.NotNull;

public record UserAnswerRequestDTO(@NotNull Long questionId, @NotNull Boolean isCorrect, @NotNull QuestionType chosenFormat) {

}
