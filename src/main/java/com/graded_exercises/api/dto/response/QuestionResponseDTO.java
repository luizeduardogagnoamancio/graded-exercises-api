package com.graded_exercises.api.dto.response;

import com.graded_exercises.api.enums.QuestionType;

public record QuestionResponseDTO(
        Long id,
        QuestionType questionType,
        String content
) {}