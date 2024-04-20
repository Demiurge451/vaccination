package vsu.edu.vaccination.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    private String fullName;

    @Past
    @NotNull
    private LocalDate birthDate;

    private List<ContactResponse> contacts;

    private UUID addressId;
    private List<DocumentResponse> documents;
}
