package com.airlines.booking.controllers;

import com.airlines.booking.models.User;
import com.airlines.booking.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeaturesController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/Features")
    public String Features(Model model) {
        Iterable<User> clientRS = userRepository.findAll();
        model.addAttribute("clienRS", clientRS);
        return "Features";
    }

}