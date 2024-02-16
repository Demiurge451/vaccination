package vsu.edu.vaccination.service;

import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.model.Region;
import vsu.edu.vaccination.repository.RegionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface RegionService {
    List<Region> getListOfRegions();
    Region findById(UUID id);
    void delete(UUID id);
    void save(Region address);
}
