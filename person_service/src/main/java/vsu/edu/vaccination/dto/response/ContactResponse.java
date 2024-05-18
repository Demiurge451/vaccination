package vsu.edu.vaccination.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import vsu.edu.vaccination.model.enums.ContactType;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse {
    private UUID id;
    private ContactType type;
    private UUID personId;
}
