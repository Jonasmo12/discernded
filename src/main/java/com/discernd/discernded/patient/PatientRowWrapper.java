package com.discernd.discernded.patient;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PatientRowWrapper implements RowMapper<Patient> {
    @Override
    public Patient mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Patient(
                resultSet.getLong("id"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getLong("identityNumber"),
                resultSet.getString("email")
        );
    }
}
