package vsu.edu.vaccination.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import vsu.edu.vaccination.model.enums.DocumentType;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentResponse {
    private UUID id;
    @NotNull
    private DocumentType type;
    @NotNull
    private UUID personId;
}
