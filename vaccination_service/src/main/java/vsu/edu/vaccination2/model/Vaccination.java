package vsu.edu.vaccination2.model;

import jakarta.persistence.*;
import lombok.*;
import vsu.edu.vaccination2.model.enums.VaccineType;
import vsu.edu.vaccination2.model.id_container.IdContainer;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vaccination extends IdContainer {
    @Enumerated(EnumType.STRING)
    private VaccineType vaccineType;

    private LocalDateTime vaccinationDate;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "vaccination_place_id")
    private VaccinationPlace vaccinationPlace;
}
