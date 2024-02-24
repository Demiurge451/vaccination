package vsu.edu.vaccination.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {
    protected CrudService<Address, UUID> addressService;

    @Autowired
    public void setAddressService(@Qualifier("addressServiceImpl") CrudService<Address, UUID> addressService) {
        this.addressService = addressService;
    }
    @Mapping(target = "address", expression = "java(addressService.getById(personRequest.getAddressId()))")
    public abstract Person mapRequestToItem(PersonRequest personRequest);

    @Mapping(target = "addressId", expression = "java(person.getAddress().getId())")
    public abstract PersonResponse mapItemToResponse(Person person);

    @Mapping(target = "personId", expression = "java(document.getPerson().getId())")
    public abstract DocumentResponse mapDocumentToResponse(Document document);

    @Mapping(target = "personId", expression = "java(contact.getPerson().getId())")
    public abstract ContactResponse mapContactToResponse(Contact contact);
}
