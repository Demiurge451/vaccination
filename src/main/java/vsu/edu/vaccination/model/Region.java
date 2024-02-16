package vsu.edu.vaccination.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String country;

    private String administrativeDivision;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    @NotEmpty
    @NotNull
    private List<Address> addresses;
}
