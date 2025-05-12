package com.dawilly.Thymeleaf.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

@GetMapping("/links")
    public String linkExpression(Model model) {
    model.addAttribute("id", 1);
    return "links";
    }

    @GetMapping("/fragment")
    public String FragmentManage(){

    return "fragment";
    }



}
