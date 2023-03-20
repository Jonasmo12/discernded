package com.discernd.discernded.patient;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements UserDetailsService {
    private final PatientRepository patientRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public PatientService(
            PatientRepository patientRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder
    ) {
        this.patientRepository = patientRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return patientRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format("email %s not found", email)));
    }

    public String signUpPatient(Patient patient) {
        boolean userExists = patientRepository.findByEmail(patient.getEmail()).isPresent();
        if (userExists) {
            throw new IllegalStateException("email has been taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(patient.getPassword());
        patient.setPassword(encodedPassword);

        boolean enableAccount = true;

        patient.setEnabled(enableAccount);

        patientRepository.save(patient);

        return "its working";
    }
}
