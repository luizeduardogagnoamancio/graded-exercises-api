package com.graded_exercises.api.controller;


import com.graded_exercises.api.dto.response.ChapterDetailResponseDTO;
import com.graded_exercises.api.dto.response.ExercisesCardsResponseDTO;
import com.graded_exercises.api.entity.User;
import com.graded_exercises.api.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("exercises")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<List<ExercisesCardsResponseDTO>> getAllExercises(@AuthenticationPrincipal User user) {
        List<ExercisesCardsResponseDTO> exercises = exerciseService.getExerciseCardsForUser(user);
        return ResponseEntity.ok(exercises);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChapterDetailResponseDTO> getChapterById(@PathVariable Long id, @AuthenticationPrincipal User user) {
        ChapterDetailResponseDTO chapterDetails = exerciseService.getChapterDetails(id, user);
        return ResponseEntity.ok(chapterDetails);
    }
}