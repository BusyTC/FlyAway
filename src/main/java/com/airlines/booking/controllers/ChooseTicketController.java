package com.airlines.booking.controllers;

import com.airlines.booking.models.User;
import com.airlines.booking.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChooseTicketController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/ChooseTicket")
    public String ChooseTicket(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "ChooseTicket";
    }

}