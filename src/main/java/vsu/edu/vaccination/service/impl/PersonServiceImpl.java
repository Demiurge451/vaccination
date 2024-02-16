package vsu.edu.vaccination.service.impl;

import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.edu.vaccination.service.PersonService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getListOfPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(UUID id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        personRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(Person person) {
        personRepository.save(person);
    }
}
