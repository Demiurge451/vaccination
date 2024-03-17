package vsu.edu.vaccination.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public ContactController(@Qualifier("contactServiceImpl") CrudService<Contact, UUID> contactService, ContactMapper mapper) {
        this.contactService = contactService;
        this.mapper = mapper;
    }

    @GetMapping
    public @Valid List<ContactResponse> getContacts(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "id") String sortParam
    ) {
        return contactService.getListOfItems(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sortParam))).stream().map(mapper::mapItemToResponse).toList();
    }

    @GetMapping("/{id}")
    public @Valid ContactResponse getContact(@PathVariable UUID id) {
        return mapper.mapItemToResponse(contactService.getById(id));
    }

    @PostMapping
    public void createContact(@Valid @RequestBody ContactRequest contactRequest) {
        contactService.save(mapper.mapRequestToItem(contactRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable UUID id) {
        contactService.delete(id);
    }

    @PutMapping("/{id}")
    public @Valid ContactResponse updateContact(@PathVariable UUID id, @Valid @RequestBody ContactRequest contactRequest) {
        return mapper.mapItemToResponse(contactService.update(id, mapper.mapRequestToItem(contactRequest)));
    }
}

