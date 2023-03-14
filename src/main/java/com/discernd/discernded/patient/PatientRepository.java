package com.discernd.discernded.patient;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PatientRepository {
    private final JdbcTemplate jdbcTemplate;

    public PatientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Patient> selectPatients() {
        return null;
    }

    public int addPatient(Patient patient) {
        String sql = """
                INSERT INTO patient(firstName, lastName, email, identityNumber)
                VALUES (?, ?);
                """;
        return jdbcTemplate.update(sql);
    }
}
