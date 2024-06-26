package vsu.edu.vaccination.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.mapper.DocumentMapper;
import vsu.edu.vaccination.model.Document;
import vsu.edu.vaccination.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.edu.vaccination.service.CrudService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DocumentServiceImpl implements CrudService<Document, UUID> {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;
    @Override
    public List<Document> getListOfItems(PageRequest pageRequest) {

        return documentRepository.findAll(pageRequest).getContent();
    }

    @Override
    public Document getById(UUID id) {
        return documentRepository.findById(id).orElseThrow(() -> new NotFoundException("Document not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        documentRepository.delete(getById(id));
    }

    @Override
    @Transactional
    public void save(Document address) {
        documentRepository.save(address);
    }

    @Override
    @Transactional
    public Document update(UUID id, Document item) {
        Document document = this.getById(id);
        documentMapper.updateDocument(item, document);
        return documentRepository.save(document);
    }
}
