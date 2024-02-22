package vsu.edu.vaccination.dto.response;

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
    private String country;
    private String administrativeDivision;
    private List<AddressResponse> addresses;
}
