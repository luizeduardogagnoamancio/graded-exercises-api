package com.graded_exercises.api.dto.response;

import java.util.List;

public record ChapterDetailResponseDTO(
        Long id,
        String title,
        String description,
        List<QuestionResponseDTO> questions
) {}