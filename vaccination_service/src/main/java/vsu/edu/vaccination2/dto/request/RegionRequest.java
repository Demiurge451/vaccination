package vsu.edu.vaccination2.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegionRequest {
    @NotBlank
    @Size(min = 1, max = 255)
    private String country;

    @Size(min = 1, max = 255)
    private String administrativeDivision;
}
