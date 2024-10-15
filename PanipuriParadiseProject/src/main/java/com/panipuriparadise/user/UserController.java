package com.panipuriparadise.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(UserRegistrationDto registrationDto) {
        userService.registerUser(registrationDto);
        return "redirect:/login"; // Redirect to login page after registration
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
