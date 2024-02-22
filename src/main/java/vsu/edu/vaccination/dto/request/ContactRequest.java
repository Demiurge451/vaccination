package vsu.edu.vaccination.dto.request;

import lombok.*;
import vsu.edu.vaccination.model.enums.ContactType;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {
    private ContactType type;
    private UUID personId;
}
