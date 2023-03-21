package com.discernd.discernded.registration;


import com.discernd.discernded.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping(value = "/register")
    public String registrationForm(Model model) {;
        model.addAttribute("patient", new Patient());
        return "register";
    }
    @PostMapping(value = "/register")
    public String register(@ModelAttribute RegistrationRequest registrationRequest, Errors errors) {
        registrationService.register(registrationRequest);
        return "home";
    }
}
