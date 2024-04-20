package vsu.edu.vaccination.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public DocumentController(@Qualifier("documentServiceImpl") CrudService<Document, UUID> documentService, DocumentMapper mapper) {
        this.documentService = documentService;
        this.mapper = mapper;
    }

    @GetMapping
    public @Valid List<DocumentResponse> getDocuments(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "id") String sortParam
    ) {
        return documentService.getListOfItems(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sortParam))).stream().map(mapper::mapItemToResponse).toList();
    }

    @GetMapping("/{id}")
    public @Valid DocumentResponse getDocument(@PathVariable UUID id) {
        return mapper.mapItemToResponse(documentService.getById(id));
    }

    @PostMapping
    public void createDocument(@Valid @RequestBody DocumentRequest documentRequest) {
        documentService.save(mapper.mapRequestToItem(documentRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable UUID id) {
        documentService.delete(id);
    }

    @PutMapping("/{id}")
    public DocumentResponse updateDocument(@PathVariable UUID id, @Valid @RequestBody DocumentRequest documentRequest) {
        return mapper.mapItemToResponse(documentService.update(id, mapper.mapRequestToItem(documentRequest)));
    }
}
