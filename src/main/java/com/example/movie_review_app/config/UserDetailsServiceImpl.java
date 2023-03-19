package com.example.movie_review_app.config;

import com.example.movie_review_app.model.UserDetls;
import com.example.movie_review_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetls user = userRepository.findByEmail(email);

        if(user != null){
            return new CustomUserDetails(user);
        }
        throw new UsernameNotFoundException("User not found");
    }
}
