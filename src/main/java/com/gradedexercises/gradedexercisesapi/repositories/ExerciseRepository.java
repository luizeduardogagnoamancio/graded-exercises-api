package com.gradedexercises.gradedexercisesapi.repositories;

import com.gradedexercises.gradedexercisesapi.entities.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, String> {
}
