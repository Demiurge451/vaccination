package vsu.edu.vaccination2.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VaccinationPlaceRequest {
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

    private UUID regionId;
}
