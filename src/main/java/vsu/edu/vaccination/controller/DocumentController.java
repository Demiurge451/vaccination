package vsu.edu.vaccination.controller;


import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination.model.Document;
import vsu.edu.vaccination.service.DocumentService;
import vsu.edu.vaccination.service.PersonService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/document")
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/")
    public List<Document> getDocuments() {
        return documentService.getListOfDocuments();
    }

    @GetMapping("/{id}")
    public Document getDocument(@PathVariable UUID id) {
        return documentService.findById(id);
    }

    @PostMapping("/")
    public void createDocument(@RequestBody Document person) {
        documentService.save(person);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable UUID id) {
        documentService.delete(id);
    }
}
