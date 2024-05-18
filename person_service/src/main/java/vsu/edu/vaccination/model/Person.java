package vsu.edu.vaccination.model;

import jakarta.persistence.*;
import lombok.*;
import vsu.edu.vaccination.model.id_container.IdContainer;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends IdContainer<UUID> {
    @Column(unique = true)
    private String login;

    private String password;

    private String fullName;

    private LocalDate birthDate;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Contact> contacts;

    @ManyToOne(targetEntity = Address.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private Address address;

    @Column(name = "address_id")
    private UUID addressId;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Document> documents;
}
