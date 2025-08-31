package com.graded_exercises.api.service.impl;

import com.graded_exercises.api.dto.response.ChapterDetailResponseDTO;
import com.graded_exercises.api.dto.response.ExercisesCardsResponseDTO;
import com.graded_exercises.api.dto.response.QuestionResponseDTO;
import com.graded_exercises.api.entity.Chapter;
import com.graded_exercises.api.entity.User;
import com.graded_exercises.api.repository.ChapterRepository;
import com.graded_exercises.api.repository.UserAnswerRepository;
import com.graded_exercises.api.service.ExerciseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ChapterRepository chapterRepository;
    private final UserAnswerRepository userAnswerRepository;

    @Autowired
    public ExerciseServiceImpl(ChapterRepository chapterRepository, UserAnswerRepository userAnswerRepository) {
        this.chapterRepository = chapterRepository;
        this.userAnswerRepository = userAnswerRepository;
    }

    @Override
    public List<ExercisesCardsResponseDTO> getExerciseCardsForUser(User user) {
        return chapterRepository.findAll().stream()
                .map(chapter -> {
                    Integer correctAnswers = userAnswerRepository.countCorrectAnswersByUserAndChapter(user, chapter);
                    int totalLessons = chapter.getQuestions().size();

                    return new ExercisesCardsResponseDTO(
                            chapter.getId(),
                            chapter.getTitle(),
                            chapter.getDescription(),
                            correctAnswers != null ? correctAnswers : 0,
                            totalLessons
                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public ChapterDetailResponseDTO getChapterDetails(Long chapterId) {
        Chapter chapter = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new EntityNotFoundException("Chapter not found with id: " + chapterId));

        List<QuestionResponseDTO> questionDTOs = chapter.getQuestions().stream()
                .map(question -> new QuestionResponseDTO(
                        question.getId(),
                        question.getQuestionType(),
                        question.getContent()
                )).toList();

        return new ChapterDetailResponseDTO(
                chapter.getId(),
                chapter.getTitle(),
                chapter.getDescription(),
                questionDTOs
        );
    }
}