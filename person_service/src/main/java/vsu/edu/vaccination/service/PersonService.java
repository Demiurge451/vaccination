package vsu.edu.vaccination.service;

import org.springframework.data.domain.PageRequest;
import vsu.edu.vaccination.model.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PersonService extends CrudService<Person, UUID> {
    List<Person> getAllByRegion(String region, PageRequest page);
    boolean verify(String name, LocalDate birthDate, String passport);
}
