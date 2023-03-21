package com.discernd.discernded.health;

import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDate;

@Entity(name = "Allergy")
@Table(name = "allergy")
public class Allergy {
    @javax.persistence.Id
    @SequenceGenerator(
            name = "allergy_sequence",
            sequenceName = "allergy_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "allergy_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long Id;
    @OneToOne(mappedBy = "allergy")
    private MedicalHistory medicalHistory;
    @Column(nullable = false)
    private String name;
    private LocalDate dateCreated = LocalDate.now(Clock.systemDefaultZone());
}
