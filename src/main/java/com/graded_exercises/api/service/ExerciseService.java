package com.graded_exercises.api.service;

import com.graded_exercises.api.dto.response.ChapterDetailResponseDTO;
import com.graded_exercises.api.dto.response.ExercisesCardsResponseDTO;
import com.graded_exercises.api.entity.User;

import java.util.List;

public interface ExerciseService {
    List<ExercisesCardsResponseDTO> getExerciseCardsForUser(User user);

    ChapterDetailResponseDTO getChapterDetails(Long chapterId);
}
