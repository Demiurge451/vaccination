package vsu.edu.vaccination.repository;

import org.springframework.stereotype.Repository;
import vsu.edu.vaccination.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface ContactRepository extends JpaRepository<Contact, UUID> {
}
