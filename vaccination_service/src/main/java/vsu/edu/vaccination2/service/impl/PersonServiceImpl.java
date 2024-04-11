package vsu.edu.vaccination2.service.impl;

import vsu.edu.vaccination2.exception.NotFoundException;
import vsu.edu.vaccination2.exception.UniqueException;
import lombok.RequiredArgsConstructor;
import vsu.edu.vaccination2.mapper.PersonMapper;
import vsu.edu.vaccination2.model.Person;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.edu.vaccination2.repository.PersonRepository;
import vsu.edu.vaccination2.service.CrudService;


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
        personRepository.save(person);
    }

    @Override
    @Transactional
    public Person update(UUID id, Person item) {
        Person person = this.getById(id);
        personMapper.updatePerson(item, person);
        return personRepository.save(person);
    }
}
