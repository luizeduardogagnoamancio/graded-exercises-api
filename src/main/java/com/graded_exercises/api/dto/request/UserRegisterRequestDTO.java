package com.graded_exercises.api.dto.request;

import com.graded_exercises.api.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserRegisterRequestDTO {

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    //Comentario para teste
    //@Size(min = 8, message = "Password must be at least 8 characters long")
    @NotBlank(message = "Password is required")
    private String password;

    private UserRole role;

    @NotBlank(message = "Name is required")
    private String name;
}
