package vsu.edu.vaccination.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.mapper.ContactMapper;
import vsu.edu.vaccination.model.Contact;
import vsu.edu.vaccination.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.edu.vaccination.service.CrudService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ContactServiceImpl implements CrudService<Contact, UUID> {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Override
    public List<Contact> getListOfItems(PageRequest pageRequest) {

        return contactRepository.findAll(pageRequest).getContent();
    }

    @Override
    public Contact getById(UUID id) {
        return contactRepository.findById(id).orElseThrow(() -> new NotFoundException("Contact not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        contactRepository.delete(getById(id));
    }

    @Override
    @Transactional
    public void save(Contact address) {
        contactRepository.save(address);
    }

    @Override
    @Transactional
    public Contact update(UUID id, Contact item) {
        Contact contact = this.getById(id);
        contactMapper.updateContact(item, contact);
        return contactRepository.save(contact);
    }
}
