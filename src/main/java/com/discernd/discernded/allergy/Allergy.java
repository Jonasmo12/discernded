package com.discernd.discernded.allergy;

import com.discernd.discernded.medicalhistory.MedicalHistory;

import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Objects;

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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicalhistory_id", referencedColumnName = "id")
    private MedicalHistory medicalHistory;
    @Column(nullable = false)
    private String name;
    private LocalDate dateCreated = LocalDate.now(Clock.systemDefaultZone());

    public Allergy(Long id) {
        Id = id;
    }

    public Allergy(Long id, MedicalHistory medicalHistory, String name, LocalDate dateCreated) {
        Id = id;
        this.medicalHistory = medicalHistory;
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public Long getId() {
        return Id;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Allergy allergy)) return false;
        return Objects.equals(Id, allergy.Id) && Objects.equals(medicalHistory, allergy.medicalHistory) && Objects.equals(name, allergy.name) && Objects.equals(dateCreated, allergy.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, medicalHistory, name, dateCreated);
    }

    @Override
    public String toString() {
        return "Allergy{" +
               "Id=" + Id +
               ", medicalHistory=" + medicalHistory +
               ", name='" + name + '\'' +
               ", dateCreated=" + dateCreated +
               '}';
    }
}
