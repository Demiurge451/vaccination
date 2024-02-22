package vsu.edu.vaccination.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination.dto.request.DocumentRequest;
import vsu.edu.vaccination.dto.response.DocumentResponse;
import vsu.edu.vaccination.mapper.DocumentMapper;
import vsu.edu.vaccination.model.Document;
import vsu.edu.vaccination.service.CrudService;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/document")
public class DocumentController {
    private final CrudService<Document, UUID> documentService;
    private final DocumentMapper mapper;

    @Autowired
    public DocumentController(@Qualifier("documentServiceImpl") CrudService<Document, UUID> documentService, DocumentMapper mapper) {
        this.documentService = documentService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<DocumentResponse> getDocuments() {
        return documentService.getListOfItems().stream().map(mapper::mapItemToResponse).toList();
    }

    @GetMapping("/{id}")
    public DocumentResponse getDocument(@PathVariable UUID id) {
        return mapper.mapItemToResponse(documentService.getById(id));
    }

    @PostMapping
    public void createDocument(@RequestBody DocumentRequest documentRequest) {
        documentService.save(mapper.mapRequestToItem(documentRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable UUID id) {
        documentService.delete(id);
    }
}
