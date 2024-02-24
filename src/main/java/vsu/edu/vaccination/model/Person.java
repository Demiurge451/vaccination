package vsu.edu.vaccination.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends IdContainer{
    @Column(unique = true)
    private String login;

    private String password;

    private String fullName;

    private LocalDate birthDate;

    @OneToMany(mappedBy = "person")
    private List<Contact> contacts;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "person")
    private List<Document> documents;
}
