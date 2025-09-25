package com.graded_exercises.api.service.impl;

import com.graded_exercises.api.dto.request.UserAnswerRequestDTO;
import com.graded_exercises.api.dto.response.ChapterDetailResponseDTO;
import com.graded_exercises.api.dto.response.ExercisesCardsResponseDTO;
import com.graded_exercises.api.dto.response.QuestionResponseDTO;
import com.graded_exercises.api.entity.Chapter;
import com.graded_exercises.api.entity.Question;
import com.graded_exercises.api.entity.User;
import com.graded_exercises.api.entity.UserAnswer;
import com.graded_exercises.api.repository.ChapterRepository;
import com.graded_exercises.api.repository.QuestionRepository;
import com.graded_exercises.api.repository.UserAnswerRepository;
import com.graded_exercises.api.service.ExerciseService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ChapterRepository chapterRepository;
    private final UserAnswerRepository userAnswerRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public ExerciseServiceImpl(ChapterRepository chapterRepository, UserAnswerRepository userAnswerRepository, QuestionRepository questionRepository) {
        this.chapterRepository = chapterRepository;
        this.userAnswerRepository = userAnswerRepository;
        this.questionRepository = questionRepository;
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
    public ChapterDetailResponseDTO getChapterDetails(Long chapterId, User user) {
        Chapter chapter = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new EntityNotFoundException("Chapter not found with id: " + chapterId));

        List<Long> answeredQuestionIds = userAnswerRepository.findCorrectlyAnsweredQuestionIdsByUserAndChapter(user, chapter);

        int startQuestionIndex = 0;
        for (Question question : chapter.getQuestions()) {
            if (!answeredQuestionIds.contains(question.getId())) {
                break;
            }
            startQuestionIndex++;
        }

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
                startQuestionIndex,
                questionDTOs
        );
    }

    @Override
    public void saveUserAnswer(UserAnswerRequestDTO answerDTO, User user) {
        Question question = questionRepository.findById(answerDTO.questionId())
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + answerDTO.questionId()));

        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUser(user);
        userAnswer.setQuestion(question);
        userAnswer.setCorrect(answerDTO.isCorrect());

        userAnswerRepository.save(userAnswer);
    }

    @Override
    @Transactional
    public void resetChapterProgress(Long chapterId, User user) {
        Chapter chapter = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new EntityNotFoundException("Chapter not found with id: " + chapterId));

        userAnswerRepository.deleteByUserAndChapter(user, chapter);
    }
}