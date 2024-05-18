package vsu.edu.vaccination2.model;

import jakarta.persistence.*;
import lombok.*;
import vsu.edu.vaccination2.model.id_container.IdContainer;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends IdContainer<UUID> {
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Vaccination> vaccinations;
}
