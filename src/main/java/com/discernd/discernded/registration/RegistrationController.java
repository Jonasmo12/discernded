package com.discernd.discernded.registration;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/register")
public class RegistrationController {
    public String register(RegistrationRequest registrationRequest) {
        return registrationService.register(registrationRequest);
    }
}
