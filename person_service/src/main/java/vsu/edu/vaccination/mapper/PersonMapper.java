package vsu.edu.vaccination.mapper;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import vsu.edu.vaccination.dto.request.PersonRequest;
import vsu.edu.vaccination.dto.response.ContactResponse;
import vsu.edu.vaccination.dto.response.DocumentResponse;
import vsu.edu.vaccination.dto.response.PersonResponse;
import vsu.edu.vaccination.model.Address;
import vsu.edu.vaccination.model.Contact;
import vsu.edu.vaccination.model.Document;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.service.CrudService;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {
    protected IdMapper<Document, UUID> idMapperDocument;
    protected IdMapper<Contact, UUID> idMapperContact;

    @Autowired
    public void setAddressService(IdMapper<Document, UUID> idMapperDocument,
                                  IdMapper<Contact, UUID> idMapperContact,
                                  CrudService<Address, UUID> addressService) {
        this.idMapperContact = idMapperContact;
        this.idMapperDocument = idMapperDocument;
    }

    public abstract Person mapRequestToItem(PersonRequest personRequest);

    @Mapping(target = "documents", expression = "java(idMapperDocument.mapItemToId(person.getDocuments()))")
    @Mapping(target = "contacts", expression = "java(idMapperContact.mapItemToId(person.getContacts()))")
    public abstract PersonResponse mapItemToResponse(Person person);

    public abstract List<PersonResponse> mapItemsToResponses(List<Person> persons);

    public abstract void updatePerson(Person source, @MappingTarget Person target);
}
