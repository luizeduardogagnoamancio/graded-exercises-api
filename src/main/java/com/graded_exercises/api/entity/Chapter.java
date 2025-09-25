package com.graded_exercises.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GRD_EX_CHAPTERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAPTER_ID")
    private Long id;

    @Column(name = "CHAPTER_TITLE", nullable = false)
    private String title;

    @Column(name = "CHAPTER_DESC", columnDefinition = "TEXT")
    private String description;

    // Relacionamento: Um Capítulo tem muitas Questões
    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();
}
