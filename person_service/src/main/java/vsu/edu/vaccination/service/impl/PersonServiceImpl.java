package vsu.edu.vaccination.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.exception.UniqueException;
import vsu.edu.vaccination.mapper.PersonMapper;
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
    private final PersonMapper personMapper;
    @Override
    public List<Person> getListOfItems(PageRequest pageRequest) {
        return personRepository.findAll(pageRequest).getContent();
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
    public void save(Person person) throws UniqueException {
        //TODO add unique exception
        try {
            personRepository.save(person);
        } catch (Exception e) {
            throw new UniqueException("Login isn't unique");
        }
    }

    @Override
    @Transactional
    public Person update(UUID id, Person item) {
        Person person = this.getById(id);
        personMapper.updatePerson(item, person);
        return personRepository.save(person);
    }
}
