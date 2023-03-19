package com.discernd.discernded.patient;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@Controller
public class PatientController {
    private final PatientService patientService;

    PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping()
    public String hello(Model model) {
        model.addAttribute("home", "Home Page");
        return "home";
    }

    @RequestMapping(value = "/patients")
    public List<Patient> listMovies(Model model) {
        model.addAttribute("patients", "patients controller");
        return patientService.getPatients();
    }
}
