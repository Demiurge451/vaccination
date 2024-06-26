package vsu.edu.vaccination.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import vsu.edu.vaccination.model.enums.DocumentType;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentRequest {
    @NotNull
    private DocumentType type;
    @NotNull
    private UUID personId;
}
