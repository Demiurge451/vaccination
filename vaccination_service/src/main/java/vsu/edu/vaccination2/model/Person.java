package vsu.edu.vaccination2.model;

import jakarta.persistence.*;
import lombok.*;
import vsu.edu.vaccination2.model.id_container.IdContainer;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends IdContainer {
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Vaccination> vaccinations;
}
