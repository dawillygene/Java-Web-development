package com.dawilly.registration.Controller;

import com.dawilly.registration.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "dashboard";
    }
}