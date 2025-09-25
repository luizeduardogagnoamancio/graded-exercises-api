package com.graded_exercises.api.controller;

import com.graded_exercises.api.dto.request.UserAnswerRequestDTO;
import com.graded_exercises.api.entity.User;
import com.graded_exercises.api.service.ExerciseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user-answers")
public class UserAnswerController {

    private final ExerciseService exerciseService;

    @Autowired
    public UserAnswerController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    public ResponseEntity<Void> saveAnswer(@RequestBody @Valid UserAnswerRequestDTO answerDTO, @AuthenticationPrincipal User user) {
        exerciseService.saveUserAnswer(answerDTO, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/chapter/{chapterId}")
    public ResponseEntity<Void> resetChapterProgress(@PathVariable Long chapterId, @AuthenticationPrincipal User user) {
        exerciseService.resetChapterProgress(chapterId, user);
        return ResponseEntity.noContent().build();
    }
}