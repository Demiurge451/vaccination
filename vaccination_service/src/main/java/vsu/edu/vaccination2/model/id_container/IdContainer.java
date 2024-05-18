package vsu.edu.vaccination2.model.id_container;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class IdContainer<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected T id;
}
