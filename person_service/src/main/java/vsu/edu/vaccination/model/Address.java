package vsu.edu.vaccination.model;

import jakarta.persistence.*;
import lombok.*;
import vsu.edu.vaccination.model.id_container.IdContainer;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address extends IdContainer<UUID> {
    private String city;

    private String street;

    private String buildingNumber;

    @ManyToOne(targetEntity = Region.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", insertable = false, updatable = false)
    private Region region;

    @Column(name = "region_id")
    private UUID regionId;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Person> people;
}
