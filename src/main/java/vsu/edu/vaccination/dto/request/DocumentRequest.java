package vsu.edu.vaccination.dto.request;

import lombok.*;
import vsu.edu.vaccination.model.enums.DocumentType;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentRequest {
    private DocumentType type;
    private UUID personId;
}
