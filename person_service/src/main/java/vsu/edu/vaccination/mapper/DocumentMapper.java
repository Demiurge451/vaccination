package vsu.edu.vaccination.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import vsu.edu.vaccination.dto.request.DocumentRequest;
import vsu.edu.vaccination.dto.response.ContactResponse;
import vsu.edu.vaccination.dto.response.DocumentResponse;
import vsu.edu.vaccination.model.Contact;
import vsu.edu.vaccination.model.Document;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.service.CrudService;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class DocumentMapper {

    public abstract Document mapRequestToItem(DocumentRequest documentRequest);

    public abstract DocumentResponse mapItemToResponse(Document document);

    public abstract void updateDocument(Document source, @MappingTarget Document target);

    public abstract List<DocumentResponse> mapItemsToResponses(List<Document> documents);
}
