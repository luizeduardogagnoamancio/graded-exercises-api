package com.graded_exercises.api.repository;

import com.graded_exercises.api.entity.Chapter;
import com.graded_exercises.api.entity.User;
import com.graded_exercises.api.entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {

    @Query("SELECT COUNT(DISTINCT ua.question) FROM UserAnswer ua " +
            "WHERE ua.user = :user AND ua.question.chapter = :chapter AND ua.isCorrect = true")
    Integer countCorrectAnswersByUserAndChapter(User user, Chapter chapter);
}
