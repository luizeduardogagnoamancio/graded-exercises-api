package com.gradedexercises.gradedexercisesapi.dtos;

import java.util.List;

public record ExerciseDto(String number, String title, String sentence, List<String> answers, String chapter, String cAnswer) {
}
