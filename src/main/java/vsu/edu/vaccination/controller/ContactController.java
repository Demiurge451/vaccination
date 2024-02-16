package vsu.edu.vaccination.controller;

import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination.model.Contact;
import vsu.edu.vaccination.service.ContactService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public List<Contact> getContacts() {
        return contactService.getListOfContacts();
    }

    @GetMapping("/{id}")
    public Contact getContact(@PathVariable UUID id) {
        return contactService.findById(id);
    }

    @PostMapping("/")
    public void createContact(@RequestBody Contact contact) {
        contactService.save(contact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable UUID id) {
        contactService.delete(id);
    }
}

