package vsu.edu.vaccination.model;

import jakarta.persistence.*;
import lombok.*;
import vsu.edu.vaccination.model.enums.DocumentType;
import vsu.edu.vaccination.model.id_container.IdContainer;

import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Document extends IdContainer<UUID> {

    @Enumerated(EnumType.STRING)
    private DocumentType type;

    @ManyToOne(targetEntity = Person.class, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", insertable  = false, updatable = false)
    private Person person;

    @Column(name = "person_id")
    private UUID personId;

    @Column(name = "document_id")
    private String documentId;
}
