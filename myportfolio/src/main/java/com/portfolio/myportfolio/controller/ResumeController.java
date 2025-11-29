package com.portfolio.myportfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {

    @GetMapping("/Resume")   // R CAPITAL
    public String showResume() {
        return "Resume";    // resume.html load karega
    }
}
