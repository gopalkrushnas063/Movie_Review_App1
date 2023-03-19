package com.example.movie_review_app.service;


import com.example.movie_review_app.model.UserDetls;

public interface UserService {
    public UserDetls createUser(UserDetls userDetails);
    public boolean checkEmail(String email);
}
