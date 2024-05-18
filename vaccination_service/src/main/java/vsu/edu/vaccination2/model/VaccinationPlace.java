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
public class VaccinationPlace extends IdContainer<UUID> {
    private String company;

    private String city;

    private String street;

    private String buildingNumber;

    @OneToMany(mappedBy = "vaccinationPlace", cascade = CascadeType.ALL)
    private List<Vaccination> vaccinations;

    @ManyToOne(targetEntity = Region.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", updatable = false, insertable = false)
    private Region region;

    @Column(name = "region_id")
    private UUID regionId;
}
