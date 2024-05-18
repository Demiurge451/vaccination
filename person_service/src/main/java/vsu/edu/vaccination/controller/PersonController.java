package vsu.edu.vaccination.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination.dto.request.PersonRequest;
import vsu.edu.vaccination.dto.response.PersonResponse;
import vsu.edu.vaccination.mapper.PersonMapper;
import vsu.edu.vaccination.service.PersonService;
import vsu.edu.vaccination.sort_enums.PersonSortParam;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("api/person")
public class PersonController {
    private final PersonService personService;
    private final PersonMapper mapper;

    public PersonController(PersonService personService, PersonMapper mapper) {
        this.personService = personService;
        this.mapper = mapper;
    }

    @GetMapping
    public @Valid List<PersonResponse> getPersons(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "ID_ASC") PersonSortParam sortParam
    ) {
        return mapper.mapItemsToResponses(
                personService.getAll(PageRequest.of(page, size, sortParam.getSortValue()))
        );
    }

    @GetMapping("/by_region")
    public @Valid List<PersonResponse> getPersonsByRegion(@RequestParam @Size(min = 1, max = 255) String region,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "ID_ASC") PersonSortParam sortParam
    ) {
        return mapper.mapItemsToResponses(
                personService.getAllByRegion(region, PageRequest.of(page, size, sortParam.getSortValue()))
        );
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

    @PostMapping("/verify")
    public boolean verifyPerson(@RequestParam @Size(min = 1, max = 255) String name,
                                @RequestParam @Pattern(regexp = "^\\d{4}\\s?\\d{6}$") String passport,
                                @RequestParam @Past @NotNull LocalDate birthDate) {
        return personService.verify(name, birthDate,  passport);
    }
}
