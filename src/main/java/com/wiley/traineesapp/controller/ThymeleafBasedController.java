package com.wiley.traineesapp.controller;

import com.wiley.traineesapp.dto.TraineeDto;
import com.wiley.traineesapp.dto.User;
import com.wiley.traineesapp.model.Trainee;
import com.wiley.traineesapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
public class ThymeleafBasedController {

    @Autowired
    private TraineeService service;

    @GetMapping("/index")
    public String getindexPage(Model model){
        String message="welcome to Trainee Management System";
        model.addAttribute("message",message);
        return "index";
    }

    @GetMapping("/demos")
    public String demos(Model model){
       boolean isLogggedin=false;
       model.addAttribute("isLoggedIn",isLogggedin);
       model.addAttribute("loggedInUser","ADMIN's");
        List<String> trainees=service.getAllTrainees().stream().map(TraineeDto::name).toList();
        System.out.println(trainees);
        model.addAttribute("trainees",trainees);
        System.out.println(trainees);
       return "Demos.html";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        return "Registration.html";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user",new User("",""));
        return "Registration.html";
    }

    @PostMapping("/submit") //submit is mapped in the registration.html
    public String submit(User user,Model model){
        System.out.println(user);
        model.addAttribute("username",user.username());
        model.addAttribute("isLoggedIn",true);
        return "success.html";
    }
}
