package vsu.edu.vaccination.model;

import jakarta.persistence.*;
import lombok.*;
import vsu.edu.vaccination.model.enums.ContactType;
import vsu.edu.vaccination.model.id_container.IdContainer;


@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact extends IdContainer {
    @Enumerated(EnumType.STRING)
    private ContactType type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id")
    private Person person;
}
