package com.graded_exercises.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserAvatarRequestDTO(@NotBlank String avatarUrl) {}