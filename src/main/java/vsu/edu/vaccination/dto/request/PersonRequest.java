package vsu.edu.vaccination.dto.request;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {
    private String login;
    private String password;
    private String fullName;
    private UUID addressId;
}
