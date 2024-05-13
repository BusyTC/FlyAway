package com.airlines.booking.controllers;

import com.airlines.booking.models.User;
import com.airlines.booking.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/Login")
    public String Login(Model model) {
        model.addAttribute("title", "Login");
        return "Login";
    }

    @PostMapping("/Login")
    public String LoginCheck(@RequestParam String email, @RequestParam String password, Model model) {
        User tUser = userRepository.findByEmail(email);
        if (tUser == null) return "redirect:/1";
        if (!Objects.equals(tUser.getPassword(), password)) return "redirect:/2";
        return "redirect:/";
    }
}