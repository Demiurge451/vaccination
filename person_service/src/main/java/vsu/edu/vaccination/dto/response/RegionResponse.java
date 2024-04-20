package vsu.edu.vaccination.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    private String country;

    private String administrativeDivision;

    @NotEmpty
    @NotNull
    private List<AddressResponse> addresses;
}
