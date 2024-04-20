package vsu.edu.vaccination2.service.impl;

import vsu.edu.vaccination2.exception.NotFoundException;
import vsu.edu.vaccination2.exception.UniqueException;
import lombok.RequiredArgsConstructor;
import vsu.edu.vaccination2.mapper.VaccinationPlaceMapper;
import vsu.edu.vaccination2.model.Vaccination;
import vsu.edu.vaccination2.model.VaccinationPlace;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.edu.vaccination2.repository.VaccinationPlaceRepository;
import vsu.edu.vaccination2.service.CrudService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VaccinationPlaceServiceImpl implements CrudService<VaccinationPlace, UUID> {
    private final VaccinationPlaceRepository vaccinationPlaceRepository;
    private final VaccinationPlaceMapper vaccinationPlaceMapper;
    @Override
    public List<VaccinationPlace> getListOfItems(PageRequest pageRequest) {
        return vaccinationPlaceRepository.findAll(pageRequest).getContent();
    }

    @Override
    public VaccinationPlace getById(UUID id) {
        return vaccinationPlaceRepository.findById(id).orElseThrow(() -> new NotFoundException("VaccinationPlace not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        vaccinationPlaceRepository.delete(getById(id));
    }

    @Override
    @Transactional
    public void save(VaccinationPlace vaccination) throws UniqueException {
        vaccinationPlaceRepository.save(vaccination);
    }

    @Override
    @Transactional
    public VaccinationPlace update(UUID id, VaccinationPlace item) {
        VaccinationPlace vaccination = this.getById(id);
        vaccinationPlaceMapper.updateVaccinationPlace(item, vaccination);
        return vaccinationPlaceRepository.save(vaccination);
    }
}
