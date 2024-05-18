package vsu.edu.vaccination2.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import vsu.edu.vaccination2.model.id_container.IdContainer;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Region extends IdContainer<UUID> {
    private String country;

    private String administrativeDivision;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<VaccinationPlace> vaccinationPlaces;
}
