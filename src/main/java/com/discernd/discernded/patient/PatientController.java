package com.discernd.discernded.patient;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientController {
    private final PatientRepository patientRepository;


    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @RequestMapping
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public String patients(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "patients";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

}
