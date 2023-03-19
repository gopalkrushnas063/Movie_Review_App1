package com.example.movie_review_app.service;

import com.example.movie_review_app.model.UserDetls;
import com.example.movie_review_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetls createUser(UserDetls userDetails) {
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        userDetails.setRole("ROLE_USER");
        return userRepository.save(userDetails);
    }

    @Override
    public boolean checkEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
