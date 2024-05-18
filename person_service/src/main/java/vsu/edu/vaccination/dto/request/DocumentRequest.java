package vsu.edu.vaccination.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 1, max = 255)
    private String documentId;
}
