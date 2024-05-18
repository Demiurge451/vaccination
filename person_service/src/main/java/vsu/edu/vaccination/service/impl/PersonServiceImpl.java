package vsu.edu.vaccination.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.exception.UniqueException;
import vsu.edu.vaccination.mapper.PersonMapper;
import vsu.edu.vaccination.model.Document;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.model.enums.DocumentType;
import vsu.edu.vaccination.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.edu.vaccination.service.PersonService;
import vsu.edu.vaccination.specification.PersonSpecification;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public List<Person> getAll(PageRequest pageRequest) {
        return personRepository.findAll(pageRequest).getContent();
    }

    @Override
    public List<Person> getAllByRegion(String region, PageRequest pageRequest) {
        return personRepository.findAll(Specification.where(PersonSpecification.byRegion(region)), pageRequest).getContent();
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

    @Override
    public boolean verify(String name, LocalDate birthDate, String passport) {
        return personRepository.findAllByFullNameAndBirthDate(name, birthDate)
                .stream()
                .map(Person::getDocuments)
                .flatMap(Collection::stream)
                .anyMatch(document -> document.getType() == DocumentType.PASSPORT && document.getDocumentId().equals(passport));
    }
}
