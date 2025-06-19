package com.graded_exercises.api.repository;

import com.graded_exercises.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
