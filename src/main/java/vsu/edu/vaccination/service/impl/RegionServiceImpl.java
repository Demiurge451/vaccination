package vsu.edu.vaccination.service.impl;

import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.model.Region;
import vsu.edu.vaccination.repository.RegionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.edu.vaccination.service.RegionService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }


    @Override
    public List<Region> getListOfRegions() {
        return regionRepository.findAll();
    }

    @Override
    public Region findById(UUID id) {
        return regionRepository.findById(id).orElseThrow(() -> new NotFoundException("Region not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id){
        regionRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(Region address) {
        regionRepository.save(address);
    }
}
