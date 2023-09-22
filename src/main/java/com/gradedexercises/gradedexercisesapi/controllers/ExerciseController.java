package com.gradedexercises.gradedexercisesapi.controllers;

import com.gradedexercises.gradedexercisesapi.dtos.ExerciseDto;
import com.gradedexercises.gradedexercisesapi.entities.ExerciseEntity;
import com.gradedexercises.gradedexercisesapi.repositories.ExerciseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    @Autowired
    private ExerciseRepository exerciseRepository;
    @GetMapping
    public ResponseEntity getAllExercises() {
        var allExercises = exerciseRepository.findAll();
        return ResponseEntity.ok(allExercises);
    }

    @PostMapping ResponseEntity registerExercise(@RequestBody @Validated ExerciseDto dto) {
        ExerciseEntity exerciseEntity = new ExerciseEntity(dto);
        log.info("Cadastrando Exercicio na tabela de Exercicios");
        exerciseRepository.save(exerciseEntity);
        return ResponseEntity.ok().build();

    }

}