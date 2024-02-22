package vsu.edu.vaccination.model;

import jakarta.persistence.*;
import lombok.*;
import vsu.edu.vaccination.model.enums.DocumentType;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Document extends IdContainer{
    @Enumerated(EnumType.STRING)
    private DocumentType type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id")
    private Person person;
}
