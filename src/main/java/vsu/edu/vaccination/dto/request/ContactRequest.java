package vsu.edu.vaccination.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import vsu.edu.vaccination.model.enums.ContactType;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {
    @NotNull
    private ContactType type;
    @NotNull
    private UUID personId;
}
