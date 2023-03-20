package com.discernd.discernded.registration;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @RequestMapping(value = "/register")
    public String register(RegistrationRequest registrationRequest) {
        return registrationService.register(registrationRequest);
    }
}
