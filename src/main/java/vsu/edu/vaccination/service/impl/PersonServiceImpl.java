package vsu.edu.vaccination.service.impl;

import lombok.RequiredArgsConstructor;
import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.edu.vaccination.service.CrudService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PersonServiceImpl implements CrudService<Person, UUID> {
    private final PersonRepository personRepository;
    @Override
    public List<Person> getListOfItems() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(UUID id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        personRepository.delete(getById(id));
    }

    @Override
    @Transactional
    public void save(Person person) {
        personRepository.save(person);
    }
}
