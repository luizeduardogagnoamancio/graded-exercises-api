package com.gradedexercises.gradedexercisesapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    @GetMapping
    public ResponseEntity getAllExercises() {
        return ResponseEntity.ok("Deu Ok!");

    }

}