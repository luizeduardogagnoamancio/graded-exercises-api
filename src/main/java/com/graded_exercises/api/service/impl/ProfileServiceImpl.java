package com.graded_exercises.api.service.impl;

import com.graded_exercises.api.dto.response.UserProfileResponseDTO;
import com.graded_exercises.api.entity.User;
import com.graded_exercises.api.repository.ChapterRepository;
import com.graded_exercises.api.repository.UserAnswerRepository;
import com.graded_exercises.api.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return new UserProfileResponseDTO(
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                completedChapters,
                (int) totalChapters,
                0.0
        );
    }
}