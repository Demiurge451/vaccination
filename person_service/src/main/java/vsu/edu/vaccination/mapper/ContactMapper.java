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

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class ContactMapper {

    public abstract Contact mapRequestToItem(ContactRequest contactRequest);

    public abstract ContactResponse mapItemToResponse(Contact contact);

    public abstract void updateContact(Contact source, @MappingTarget Contact target);

    public abstract List<ContactResponse> mapItemsToResponse(List<Contact> source);
}
