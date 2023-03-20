package com.discernd.discernded.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);

//    @Transactional
//    @Modifying
//    @Query("UPDATE Patient a" +
//    "SET a.enabled = TRUE WHERE a.email = ?1")
//    int enablePatient(String email);
}
