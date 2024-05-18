package vsu.edu.vaccination.dto.response;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {
    private UUID id;

    private String login;

    private String password;

    private String fullName;

    private LocalDate birthDate;

    private List<UUID> contacts;

    private UUID addressId;

    private List<UUID> documents;
}
