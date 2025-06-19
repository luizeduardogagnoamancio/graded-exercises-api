package com.graded_exercises.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserRegisterRequestDTO {
    private String email;
    private String password;
}
