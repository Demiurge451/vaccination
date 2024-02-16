package vsu.edu.vaccination.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(unique = true)
    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    private String fullName;

    @OneToMany(mappedBy = "person")
    @NotEmpty
    @NotNull
    private List<Contact> contacts;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "person")
    private List<Document> documents;
}
