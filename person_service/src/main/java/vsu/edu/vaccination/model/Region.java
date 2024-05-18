package vsu.edu.vaccination.model;

import jakarta.persistence.*;
import lombok.*;
import vsu.edu.vaccination.model.id_container.IdContainer;

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
    private List<Address> addresses;
}
