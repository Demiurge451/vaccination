package vsu.edu.vaccination.repository;

import org.springframework.stereotype.Repository;
import vsu.edu.vaccination.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
}
