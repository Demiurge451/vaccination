package vsu.edu.vaccination2.dto.request;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VaccinationRequest {
    private String vaccineType;
    private LocalDateTime vaccinationDate;
    private UUID personId;
    private UUID vaccinationPlaceId;
}
