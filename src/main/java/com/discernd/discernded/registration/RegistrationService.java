package com.discernd.discernded.registration;

import com.discernd.discernded.patient.AppUserRole;
import com.discernd.discernded.patient.Patient;
import com.discernd.discernded.patient.PatientService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final PatientService patientService;
    private EmailValidator emailValidator;

    RegistrationService(PatientService patientService) {
        this.patientService = patientService;
    }

    public String register(RegistrationRequest registrationRequest) {
        boolean isValidEmail = emailValidator.test(registrationRequest.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email is not valid!!");
        }
        return patientService.signUpPatient(
                new Patient(
                        registrationRequest.getFirstName(),
                        registrationRequest.getLastName(),
                        registrationRequest.getIdentityNumber(),
                        registrationRequest.getEmail(),
                        registrationRequest.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
