package vsu.edu.vaccination2.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import vsu.edu.vaccination2.model.id_container.IdContainer;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationPlace extends IdContainer {
    private String company;

    @OneToMany(mappedBy = "vaccinationPlace", cascade = CascadeType.ALL)
    private List<Vaccination> vaccinations;
}
