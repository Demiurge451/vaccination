package vsu.edu.vaccination.dto.response;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    private UUID id;
    private String city;
    private String street;
    private String buildingNumber;
    private UUID regionId;

    @NotNull
    @NotEmpty
    private List<PersonResponse> people;
}
