package vsu.edu.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    public PersonController(@Qualifier("personServiceImpl") CrudService<Person, UUID> personService, PersonMapper mapper) {
        this.personService = personService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PersonResponse> getPersons() {
        return personService.getListOfItems().stream().map(mapper::mapItemToResponse).toList();
    }

    @GetMapping("/{id}")
    public PersonResponse getPerson(@PathVariable UUID id) {
        return mapper.mapItemToResponse(personService.getById(id));
    }

    @PostMapping
    public void createPerson(@RequestBody PersonRequest personRequest) {
        personService.save(mapper.mapRequestToItem(personRequest));
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable UUID id) {
        personService.delete(id);
    }
}
