package vsu.edu.vaccination.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import vsu.edu.vaccination.dto.request.ContactRequest;
import vsu.edu.vaccination.dto.response.ContactResponse;
import vsu.edu.vaccination.model.Contact;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.service.CrudService;

import java.util.UUID;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class ContactMapper {
    protected CrudService<Person, UUID> personService;

    @Autowired
    public void setPersonService(@Qualifier("personServiceImpl") CrudService<Person, UUID> personService)  {
        this.personService = personService;
    }

    @Mapping(target = "person", expression = "java(personService.getById(contactRequest.getPersonId()))")
    public abstract Contact mapRequestToItem(ContactRequest contactRequest);

    @Mapping(target = "personId", source = "contact.person.id")
    public abstract ContactResponse mapItemToResponse(Contact contact);

    public abstract void updateContact(Contact source, @MappingTarget Contact target);
}
