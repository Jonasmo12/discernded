package com.discernd.discernded.patient;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PatientRepository {
    private final JdbcTemplate jdbcTemplate;

    public PatientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Patient> selectPatients() {
        var sql = """
                  SELECT id, identityNumber
                  FROM patient
                  LIMIT 25;
                  """;
        return jdbcTemplate.query(sql, new PatientRowWrapper());
    }

    public int addPatient(Patient patient) {

        var sql = """
                        INSERT INTO patient(firstName, lastName, email, identityNumber)
                        VALUES (?, ?);
                    """;
        return jdbcTemplate.update(sql, patient.getIdentityNumber(), patient.getEmail());
    }
}
