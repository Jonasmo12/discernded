package com.discernd.discernded.health;

import com.discernd.discernded.patient.Patient;

import javax.persistence.*;

@Entity(name = "medicalHistory")
public class MedicalHistory {
    @Id
    @SequenceGenerator(
            name = "medicalhistory_sequence",
            sequenceName = "medicalhistory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "medicalhistory_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long Id;
//    private Patient patient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "allergy_id")
    private Allergy allergy;
}
