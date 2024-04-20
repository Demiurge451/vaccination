package vsu.edu.vaccination2.dto.response;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {
    private UUID id;
    private List<VaccinationResponse> vaccinations;
}
