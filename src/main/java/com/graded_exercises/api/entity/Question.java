package com.graded_exercises.api.entity;

import com.graded_exercises.api.enums.QuestionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GRD_EX_QUESTION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID") // Adicionado para consistência
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    // CORREÇÃO: O nome deve ser a coluna de chave estrangeira no banco
    @JoinColumn(name = "CHAPTER_ID", nullable = false)
    private Chapter chapter;

    @Enumerated(EnumType.STRING)
    @Column(name = "QUESTION_TYPE", nullable = false)
    private QuestionType questionType;

    @JdbcTypeCode(SqlTypes.JSON)
    // CORREÇÃO: O nome da coluna vai aqui, e a definição do tipo (jsonb) aqui
    @Column(name = "QUESTION_CONTENT", columnDefinition = "jsonb")
    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAnswer> userAnswers = new ArrayList<>();
}