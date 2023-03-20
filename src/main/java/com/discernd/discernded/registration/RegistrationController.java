package com.discernd.discernded.registration;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/register")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public String register(RegistrationRequest registrationRequest) {
        return registrationService.register(registrationRequest);
    }
}
