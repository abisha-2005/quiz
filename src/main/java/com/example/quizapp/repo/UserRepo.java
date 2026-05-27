package com.example.quizapp.repo;

import com.example.quizapp.model.Users;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
