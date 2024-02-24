package vsu.edu.vaccination.service.impl;

import lombok.RequiredArgsConstructor;
import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.model.Region;
import vsu.edu.vaccination.repository.RegionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.edu.vaccination.service.CrudService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegionServiceImpl implements CrudService<Region, UUID> {
    private final RegionRepository regionRepository;

    @Override
    public List<Region> getListOfItems() {
        return regionRepository.findAll();
    }

    @Override
    public Region getById(UUID id) {
        return regionRepository.findById(id).orElseThrow(() -> new NotFoundException("Region not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id){
        regionRepository.delete(getById(id));
    }

    @Override
    @Transactional
    public void save(Region address) {
        regionRepository.save(address);
    }

    @Override
    public Region update(UUID id, Region item) {
        Region region = this.getById(id);
        region.setCountry(item.getCountry());
        region.setAdministrativeDivision(item.getAdministrativeDivision());
        region.setAddresses(item.getAddresses());
        return regionRepository.save(region);
    }
}
