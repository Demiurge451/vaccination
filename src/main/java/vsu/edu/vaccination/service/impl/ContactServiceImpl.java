package vsu.edu.vaccination.service.impl;

import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.model.Contact;
import vsu.edu.vaccination.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.edu.vaccination.service.ContactService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    public List<Contact> getListOfContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(UUID id) {
        return contactRepository.findById(id).orElseThrow(() -> new NotFoundException("Contact not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        contactRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(Contact address) {
        contactRepository.save(address);
    }
}
