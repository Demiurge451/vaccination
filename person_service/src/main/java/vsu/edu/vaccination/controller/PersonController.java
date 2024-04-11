package vsu.edu.vaccination.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination.dto.request.PersonRequest;
import vsu.edu.vaccination.dto.response.PersonResponse;
import vsu.edu.vaccination.mapper.PersonMapper;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.service.CrudService;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/person")
public class PersonController {
    private final CrudService<Person, UUID> personService;
    private final PersonMapper mapper;

    public PersonController(@Qualifier("personServiceImpl") CrudService<Person, UUID> personService, PersonMapper mapper) {
        this.personService = personService;
        this.mapper = mapper;
    }

    @GetMapping
    public @Valid List<PersonResponse> getPersons(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "id") String sortParam
    ) {
        List<PersonResponse> l = personService.getListOfItems(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sortParam))).stream().map(mapper::mapItemToResponse).toList();
        return l;
    }

    @GetMapping("/{id}")
    public @Valid PersonResponse getPerson(@PathVariable UUID id) {
        return mapper.mapItemToResponse(personService.getById(id));
    }

    @PostMapping
    public void createPerson(@Valid @RequestBody PersonRequest personRequest) {
        personService.save(mapper.mapRequestToItem(personRequest));
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable UUID id) {
        personService.delete(id);
    }

    @PutMapping("/{id}")
    public @Valid PersonResponse updatePerson(@PathVariable UUID id, @Valid @RequestBody PersonRequest personRequest) {
        return mapper.mapItemToResponse(personService.update(id, mapper.mapRequestToItem(personRequest)));
    }
}
