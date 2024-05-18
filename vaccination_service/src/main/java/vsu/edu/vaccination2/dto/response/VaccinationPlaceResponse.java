package vsu.edu.vaccination2.dto.response;

import jakarta.validation.constraints.Size;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationPlaceResponse {
    @NotBlank
    @Size(min = 1, max = 255)
    private String company;

    @NotBlank
    @Size(min = 1, max = 255)
    private String city;

    @Size(min = 1, max = 255)
    private String street;

    @Size(min = 1, max = 255)
    private String buildingNumber;

    private List<UUID> vaccinations;

    private UUID regionId;
}
