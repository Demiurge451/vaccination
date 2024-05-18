package vsu.edu.vaccination2.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegionResponse {
    private UUID id;

    @NotBlank
    @Size(min = 1, max = 255)
    private String country;

    @Size(min = 1, max = 255)
    private String administrativeDivision;

    @NotEmpty
    @NotNull
    private List<UUID> vaccinationPlaces;
}
