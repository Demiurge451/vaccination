package vsu.edu.vaccination.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegionRequest {
    @NotBlank
    private String country;

    private String administrativeDivision;
}
