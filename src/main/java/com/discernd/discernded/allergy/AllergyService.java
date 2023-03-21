package com.discernd.discernded.allergy;

import org.springframework.stereotype.Service;

@Service
public class AllergyService {
    private final AllergyRepository allergyRepository;

    public AllergyService(AllergyRepository allergyRepository) {
        this.allergyRepository = allergyRepository;
    }

    public String addAllergy(Allergy allergy) {
        boolean allergyExists = allergyRepository.findByName(allergy.getName()).isPresent();
        if (allergyExists) {
            throw new IllegalStateException(String.format("%s already exists", allergy.getName()));
        }

        allergyRepository.save(allergy);

        return "allergy saved";
    }

    public String createAllergy(Allergy allergy) {
        return addAllergy(
                new Allergy(
                        allergy.getName(),
                        allergy.getMedicalHistory()
                )
        );
    }
}
