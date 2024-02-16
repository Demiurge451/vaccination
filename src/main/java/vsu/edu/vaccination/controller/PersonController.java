package vsu.edu.vaccination.controller;

import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.service.PersonService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public List<Person> getPersons() {
        return personService.getListOfPersons();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable UUID id) {
        return personService.findById(id);
    }

    @PostMapping("/")
    public void createPerson(@RequestBody Person person) {
        personService.save(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable UUID id) {
        personService.delete(id);
    }
}
