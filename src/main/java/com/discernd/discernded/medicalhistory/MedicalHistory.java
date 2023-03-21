package com.discernd.discernded.medicalhistory;

import com.discernd.discernded.allergy.Allergy;
import com.discernd.discernded.patient.Patient;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    @OneToOne(mappedBy = "medicalHistory")
    private Patient patient;

    @OneToMany(mappedBy = "medicalhistory")
    private Set<Allergy> allergies = new HashSet<>();

    public Long getId() {
        return Id;
    }

    public MedicalHistory(Long id) {
        Id = id;
    }

    public MedicalHistory(Patient patient, Set<Allergy> allergies) {
        this.patient = patient;
        this.allergies = allergies;
    }

    public MedicalHistory() {
    }

    @Override
    public String toString() {
        return "MedicalHistory{" +
               "Id=" + Id +
               ", patient=" + patient +
               ", allergies=" + allergies +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicalHistory that)) return false;
        return Objects.equals(Id, that.Id) && Objects.equals(patient, that.patient) && Objects.equals(allergies, that.allergies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, patient, allergies);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setAllergies(Set<Allergy> allergies) {
        this.allergies = allergies;
    }

    public Set<Allergy> getAllergies() {
        return allergies;
    }
}
