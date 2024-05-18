package vsu.edu.vaccination.model;

import jakarta.persistence.*;
import lombok.*;
import vsu.edu.vaccination.model.enums.ContactType;
import vsu.edu.vaccination.model.id_container.IdContainer;

import java.util.UUID;


@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact extends IdContainer<UUID> {
    @Enumerated(EnumType.STRING)
    private ContactType type;

    @ManyToOne(targetEntity = Person.class, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private Person person;

    @Column(name = "person_id")
    private UUID personId;
}
