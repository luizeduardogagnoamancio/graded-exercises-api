package com.graded_exercises.api.service.impl;

import com.graded_exercises.api.dto.response.ChapterProgressResponseDTO;
import com.graded_exercises.api.dto.response.UserProfileResponseDTO;
import com.graded_exercises.api.entity.User;
import com.graded_exercises.api.repository.ChapterRepository;
import com.graded_exercises.api.repository.UserAnswerRepository;
import com.graded_exercises.api.service.ProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final UserAnswerRepository userAnswerRepository;
    private final ChapterRepository chapterRepository;

    public ProfileServiceImpl(UserAnswerRepository userAnswerRepository, ChapterRepository chapterRepository, ChapterRepository chapterRepository1) {
        this.userAnswerRepository = userAnswerRepository;
        this.chapterRepository = chapterRepository1;
    }

    @Override
    public UserProfileResponseDTO getUserProfile(User user) {
        long totalChapters = chapterRepository.count();

        List<Long> completedChapterIds = userAnswerRepository.findCompletedChapterIdsByUser(user);
        int completedChapters = completedChapterIds.size();
        int dailyStreak = calculateDailyStreak(user);
        List<ChapterProgressResponseDTO> chapterProgress = getChapterProgress(user);


        return new UserProfileResponseDTO(
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                completedChapters,
                (int) totalChapters,
                dailyStreak,
                chapterProgress
        );
    }

    private int calculateDailyStreak(User user) {
        List<LocalDate> answerDates = userAnswerRepository.findDistinctAnswerDatesByUser(user);
        if (answerDates.isEmpty()) {
            return 0;
        }

        int currentStreak = 0;
        LocalDate today = LocalDate.now();
        LocalDate lastDate = today;

        if (answerDates.contains(today) || answerDates.contains(today.minusDays(1))) {
            if (answerDates.contains(today)) {
                currentStreak = 1;
            } else {
                currentStreak = 1;
                lastDate = today.minusDays(1);
            }

            for (LocalDate date : answerDates) {
                if (date.equals(lastDate)) continue;
                if (date.equals(lastDate.minusDays(1))) {
                    currentStreak++;
                    lastDate = date;
                } else {
                    break;
                }
            }
        }

        return currentStreak;
    }

    private List<ChapterProgressResponseDTO> getChapterProgress(User user) {
        return chapterRepository.findAll().stream()
                .map(chapter -> {
                    Integer correctAnswers = userAnswerRepository.countCorrectAnswersByUserAndChapter(user, chapter);
                    return new ChapterProgressResponseDTO(
                            chapter.getId(),
                            chapter.getTitle(),
                            correctAnswers != null ? correctAnswers : 0,
                            chapter.getQuestions().size()
                    );
                })
                .collect(Collectors.toList());
    }
}