package com.graded_exercises.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "GRD_EX_USER_ANSWER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ANSWER_ID") // Adicionado para consistência
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    // CORREÇÃO: O nome deve ser a coluna que guarda o ID do usuário
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    // CORREÇÃO: O nome deve ser a coluna que guarda o ID da questão
    @JoinColumn(name = "QUESTION_ID", nullable = false)
    private Question question;

    @Column(name = "IS_CORRECT", nullable = false) // Nome simplificado
    private boolean isCorrect;

    @CreationTimestamp
    @Column(name = "ANSWERED_AT", updatable = false) // Nome simplificado
    private LocalDateTime answeredAt;
}