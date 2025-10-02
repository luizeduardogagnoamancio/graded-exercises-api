package com.graded_exercises.api.repository;

import com.graded_exercises.api.entity.Chapter;
import com.graded_exercises.api.entity.User;
import com.graded_exercises.api.entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {

    @Query("SELECT COUNT(DISTINCT ua.question) FROM UserAnswer ua " +
            "WHERE ua.user = :user AND ua.question.chapter = :chapter AND ua.isCorrect = true")
    Integer countCorrectAnswersByUserAndChapter(User user, Chapter chapter);

    @Query("SELECT DISTINCT ua.question.id FROM UserAnswer ua " +
            "WHERE ua.user = :user AND ua.question.chapter = :chapter AND ua.isCorrect = true")
    List<Long> findCorrectlyAnsweredQuestionIdsByUserAndChapter(User user, Chapter chapter);

    @Modifying
    @Query("DELETE FROM UserAnswer ua WHERE ua.user = :user AND ua.question.chapter = :chapter")
    void deleteByUserAndChapter(User user, Chapter chapter);

    @Query("SELECT q.chapter.id FROM UserAnswer ua JOIN ua.question q " +
            "WHERE ua.user = :user AND ua.isCorrect = true " +
            "GROUP BY q.chapter.id " +
            "HAVING COUNT(DISTINCT q.id) = (SELECT COUNT(q2.id) FROM Question q2 WHERE q2.chapter.id = q.chapter.id)")
    List<Long> findCompletedChapterIdsByUser(@Param("user") User user);
}
