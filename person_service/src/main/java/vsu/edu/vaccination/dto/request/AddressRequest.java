package vsu.edu.vaccination.dto.request;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequest {
    private String city;
    private String street;
    private String buildingNumber;
    private UUID regionId;
}
