package vsu.edu.vaccination.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegionRequest {
    private String country;
    private String administrativeDivision;
}
