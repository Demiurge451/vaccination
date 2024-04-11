package vsu.edu.vaccination2.service.impl;

import vsu.edu.vaccination2.exception.NotFoundException;
import vsu.edu.vaccination2.exception.UniqueException;
import lombok.RequiredArgsConstructor;
import vsu.edu.vaccination2.mapper.VaccinationMapper;
import vsu.edu.vaccination2.model.Person;
import vsu.edu.vaccination2.model.Vaccination;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.edu.vaccination2.repository.VaccinationRepository;
import vsu.edu.vaccination2.service.CrudService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VaccinationServiceImpl implements CrudService<Vaccination, UUID> {
    private final VaccinationRepository vaccinationRepository;
    private final VaccinationMapper vaccinationMapper;
    @Override
    public List<Vaccination> getListOfItems(PageRequest pageRequest) {
        return vaccinationRepository.findAll(pageRequest).getContent();
    }

    @Override
    public Vaccination getById(UUID id) {
        return vaccinationRepository.findById(id).orElseThrow(() -> new NotFoundException("Vaccination not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        vaccinationRepository.delete(getById(id));
    }

    @Override
    @Transactional
    public void save(Vaccination vaccination) throws UniqueException {
        vaccinationRepository.save(vaccination);
    }

    @Override
    @Transactional
    public Vaccination update(UUID id, Vaccination item) {
        Vaccination vaccination = this.getById(id);
        vaccinationMapper.updateVaccination(item, vaccination);
        return vaccinationRepository.save(vaccination);
    }
}
