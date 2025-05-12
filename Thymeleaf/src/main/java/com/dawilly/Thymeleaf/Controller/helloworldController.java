package com.dawilly.Thymeleaf.Controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloworldController {

    @GetMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        return "helloworld";
    }


}
