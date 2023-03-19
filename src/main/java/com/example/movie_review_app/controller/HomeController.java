package com.example.movie_review_app.controller;

import com.example.movie_review_app.model.UserDetls;
import com.example.movie_review_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/signin")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String signup(){
        return "register";
    }


    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDetls userDetails, HttpSession session){
        //System.out.println(userDetails);

        boolean email = userService.checkEmail(userDetails.getEmail());

        if(email){
            session.setAttribute("msg","Email ID Already Exist");
        }else {
            UserDetls userDetails1 =  userService.createUser(userDetails);
            if(userDetails1 != null){
                session.setAttribute("msg","Register Successfully");
            }else {
                session.setAttribute("msg","Something went wrong in server");
            }
        }

        return "redirect:/register";
    }
}
