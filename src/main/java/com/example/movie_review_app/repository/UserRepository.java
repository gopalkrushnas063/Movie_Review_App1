package com.example.movie_review_app.repository;

import com.example.movie_review_app.model.UserDetls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetls,Integer> {
    public boolean existsByEmail(String email);

    public UserDetls findByEmail(String email);
}
