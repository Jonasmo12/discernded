package com.discernd.discernded.patient;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public class PatientRowWrapper implements RowMapper<Patient> {
    @Override
    public Patient mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Patient(
                resultSet.getInt("id"),
                resultSet.getLong("identityNumber"),
                List.of(),
                resultSet.getString("email")
        );
    }
}
