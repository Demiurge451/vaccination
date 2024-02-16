package vsu.edu.vaccination.service;

import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    List<Person> getListOfPersons();
    Person findById(UUID id);
    void delete(UUID id);
    void save(Person person);
}
