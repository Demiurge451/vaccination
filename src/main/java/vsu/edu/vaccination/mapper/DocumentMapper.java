package vsu.edu.vaccination.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import vsu.edu.vaccination.dto.request.DocumentRequest;
import vsu.edu.vaccination.dto.response.ContactResponse;
import vsu.edu.vaccination.dto.response.DocumentResponse;
import vsu.edu.vaccination.model.Contact;
import vsu.edu.vaccination.model.Document;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.service.CrudService;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class DocumentMapper {
    protected CrudService<Person, UUID> personService;

    @Autowired
    public void setPersonService(@Qualifier("personServiceImpl") CrudService<Person, UUID> personService) {
        this.personService = personService;
    }
    @Mapping(target = "person", expression = "java(personService.getById(documentRequest.getPersonId()))")
    public abstract Document mapRequestToItem(DocumentRequest documentRequest);

    @Mapping(target = "personId", expression = "java(document.getPerson().getId())")
    public abstract DocumentResponse mapItemToResponse(Document document);
}
