package vsu.edu.vaccination.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {
    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    private String fullName;

    @Past
    @NotNull
    private LocalDate birthDate;

    private UUID addressId;
}
