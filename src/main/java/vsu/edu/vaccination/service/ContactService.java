package vsu.edu.vaccination.service;

import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.model.Contact;
import vsu.edu.vaccination.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface ContactService {
    List<Contact> getListOfContacts();
    Contact findById(UUID id);
    void delete(UUID id);
    void save(Contact address);
}
