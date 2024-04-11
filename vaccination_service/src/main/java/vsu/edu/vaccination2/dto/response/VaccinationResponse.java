package vsu.edu.vaccination2.dto.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationResponse {
    private UUID id;
    private String vaccineType;
    private LocalDateTime vaccinationDate;
    private UUID personId;
    private UUID vaccinationPlaceId;
}
