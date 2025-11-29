package com.portfolio.myportfolio.controller;

import com.portfolio.myportfolio.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public String showContactForm() {
        return "contact"; // Thymeleaf template name: contact.html
    }

    @PostMapping
    public String sendMessage(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam String message) {
        String subject = "Contact Form Submission from " + name;
        String body = "Email: " + email + "\nMessage: " + message;
        emailService.sendEmail("your-email@gmail.com", subject, body); // apna email
        return "redirect:/contact?success";
    }
}
