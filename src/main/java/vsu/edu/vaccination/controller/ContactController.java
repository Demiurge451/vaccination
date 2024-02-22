package vsu.edu.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination.dto.request.ContactRequest;
import vsu.edu.vaccination.dto.response.ContactResponse;
import vsu.edu.vaccination.mapper.ContactMapper;
import vsu.edu.vaccination.model.Contact;
import vsu.edu.vaccination.service.CrudService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private final CrudService<Contact, UUID> contactService;
    private final ContactMapper mapper;

    @Autowired
    public ContactController(@Qualifier("contactServiceImpl") CrudService<Contact, UUID> contactService, ContactMapper mapper) {
        this.contactService = contactService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ContactResponse> getContacts() {
        return contactService.getListOfItems().stream().map(mapper::mapItemToResponse).toList();
    }

    @GetMapping("/{id}")
    public ContactResponse getContact(@PathVariable UUID id) {
        return mapper.mapItemToResponse(contactService.getById(id));
    }

    @PostMapping
    public void createContact(@RequestBody ContactRequest contactRequest) {
        contactService.save(mapper.mapRequestToItem(contactRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable UUID id) {
        contactService.delete(id);
    }
}

