package vsu.edu.vaccination2.model;

import jakarta.persistence.*;
import lombok.*;
import vsu.edu.vaccination2.model.enums.VaccineType;
import vsu.edu.vaccination2.model.id_container.IdContainer;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vaccination extends IdContainer<UUID> {
    @Enumerated(EnumType.STRING)
    private VaccineType vaccineType;

    private LocalDateTime vaccinationDate;

    @ManyToOne(targetEntity = Person.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private Person person;

    @Column(name = "person_id")
    private UUID personId;

    @ManyToOne(targetEntity = VaccinationPlace.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "vaccination_place_id", updatable = false, insertable = false)
    private VaccinationPlace vaccinationPlace;

    @Column(name = "vaccination_place_id")
    private UUID vaccinePlaceId;
}
