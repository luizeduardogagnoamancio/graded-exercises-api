package com.gradedexercises.gradedexercisesapi.entities;

import com.gradedexercises.gradedexercisesapi.dtos.ExerciseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Table(name="exercise")
@Entity
@Getter
@Setter

public class ExerciseEntity {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="_id")
    private String id;

    @Column(name="number")
    private String number;

    @Column(name="title")
    private String title;

    @Column(name="sentence")
    private String sentence;

    @Column(name="answers")
    private List<String> answers;

    public ExerciseEntity(ExerciseDto dto) {
        this.number = dto.number();
        this.title = dto.title();
        this.sentence = dto.sentence();
        this.answers = dto.answers();
    }

}
