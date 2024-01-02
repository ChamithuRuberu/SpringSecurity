package com.example.demoapp.controller;

import ch.qos.logback.core.model.Model;
import com.example.demoapp.dto.UserDTO;
import com.example.demoapp.entity.User;
import com.example.demoapp.repository.UserRepository;
import com.example.demoapp.service.impl.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") UserDTO user){
         return userService.test(user);
    }


}
