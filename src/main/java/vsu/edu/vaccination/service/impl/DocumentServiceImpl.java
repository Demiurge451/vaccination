package vsu.edu.vaccination.service.impl;

import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.model.Document;
import vsu.edu.vaccination.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.edu.vaccination.service.DocumentService;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }


    @Override
    public List<Document> getListOfDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Document findById(UUID id) {
        return documentRepository.findById(id).orElseThrow(() -> new NotFoundException("Document not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        documentRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(Document address) {
        documentRepository.save(address);
    }
}
