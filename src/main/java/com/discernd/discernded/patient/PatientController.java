package com.discernd.discernded.patient;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PatientController {

    @RequestMapping()
    public String hello(Model model) {
        model.addAttribute("home", "Home Page");
        return "home";
    }

    @RequestMapping(value = "/patients")
    public String getPatients(Model model) {
        model.addAttribute("patients", "this is coming from patient controller");
        return "patients";
    }
}
