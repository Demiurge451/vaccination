package vsu.edu.vaccination.model;

import jakarta.persistence.*;
import lombok.*;
import vsu.edu.vaccination.model.id_container.IdContainer;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends IdContainer {
    @Column(unique = true)
    private String login;

    private String password;

    private String fullName;

    private LocalDate birthDate;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Contact> contacts;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Document> documents;
}
