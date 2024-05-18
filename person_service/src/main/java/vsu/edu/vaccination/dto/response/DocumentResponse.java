package vsu.edu.vaccination.dto.response;

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
    private DocumentType type;
    private UUID personId;
}
