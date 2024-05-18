package vsu.edu.vaccination.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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
    @Size(min = 1, max = 50)
    private String login;

    @NotBlank
    @Size(min = 1, max = 50)
    private String password;

    @NotBlank
    @Size(min = 1, max = 255)
    private String fullName;

    @Past
    @NotNull
    private LocalDate birthDate;

    @NotNull
    private UUID addressId;
}
