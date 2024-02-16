package vsu.edu.vaccination.service;

import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.model.Document;
import vsu.edu.vaccination.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface DocumentService {
    List<Document> getListOfDocuments();
    Document findById(UUID id);
    void delete(UUID id);
    void save(Document address);
}
