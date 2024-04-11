package vsu.edu.vaccination2.dto.response;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationPlaceResponse {
    private String company;
    private List<VaccinationResponse> vaccinations;
}
