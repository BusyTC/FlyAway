package com.airlines.booking.controllers;

import com.airlines.booking.models.User;
import com.airlines.booking.repo.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Objects;

@Controller
@WebServlet
public class LoginController extends HttpServlet {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/Login")
    public String Login(Model model) {
        model.addAttribute("title", "Login");
        return "Login";
    }

    @PostMapping("/Login")
    public String LoginCheck(@RequestParam String email, @RequestParam String password, HttpServletRequest request,
                             HttpServletResponse response, Model model) {
        User tUser = userRepository.findByEmail(email);
        if (tUser == null) return "redirect:/1";
        if (!Objects.equals(tUser.getPassword(), password)) return "redirect:/2";

        HttpSession oldSession = request.getSession(false);
        if (oldSession != null) {
            oldSession.invalidate();
        }
        //generate a new session
        HttpSession newSession = request.getSession(true);

        //setting session to expiry in 5 mins
        newSession.setMaxInactiveInterval(5*60);

        Cookie message = new Cookie("account", tUser.getId().toString());
        response.addCookie(message);

        return "redirect:/";
    }

    @GetMapping("/Logout")
    public String Logout(HttpServletRequest request,
                         HttpServletResponse response, Model model) {
        model.addAttribute("title", "Logout");
        Cookie message = new Cookie("account", "-1");
        message.setMaxAge(0);
        response.addCookie(message);
        return "redirect:/";
    }
}