package vsu.edu.vaccination.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequest {
    @NotBlank
    @Size(min = 1, max = 255)
    private String city;

    @Size(min = 1, max = 255)
    private String street;

    @Size(min = 1, max = 255)
    private String buildingNumber;

    @NotNull
    private UUID regionId;
}
