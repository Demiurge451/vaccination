package vsu.edu.vaccination2.controller;

import jakarta.validation.Valid;
import vsu.edu.vaccination2.dto.request.VaccinationRequest;
import vsu.edu.vaccination2.dto.response.VaccinationResponse;
import vsu.edu.vaccination2.mapper.VaccinationMapper;
import vsu.edu.vaccination2.model.Vaccination;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination2.service.CrudService;
import vsu.edu.vaccination2.sort_enums.VaccinationSortParam;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/vaccination")
public class VaccinationController {
    private final CrudService<Vaccination, UUID> vaccinationService;
    private final VaccinationMapper vaccinationMapper;
    public VaccinationController(CrudService<Vaccination, UUID> vaccinationService, VaccinationMapper vaccinationMapper) {
        this.vaccinationService = vaccinationService;
        this.vaccinationMapper = vaccinationMapper;
    }

    @GetMapping
    public @Valid List<VaccinationResponse> getVaccinations(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "ID_ASC") VaccinationSortParam sortParam
    ) {
        return vaccinationMapper.mapItemsToResponse(
                vaccinationService.getListOfItems(PageRequest.of(page, size, sortParam.getSortValue()))
        );
    }

    @GetMapping("/{id}")
    public @Valid VaccinationResponse getVaccination(@PathVariable UUID id) {
        return vaccinationMapper.mapItemToResponse(vaccinationService.getById(id));
    }

    @PostMapping
    public void createVaccination(@Valid @RequestBody VaccinationRequest vaccinationRequest) {
        vaccinationService.save(vaccinationMapper.mapRequestToItem(vaccinationRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteVaccination(@PathVariable UUID id) {
        vaccinationService.delete(id);
    }

    @PutMapping("/{id}")
    public @Valid VaccinationResponse updateVaccination(@PathVariable UUID id, @Valid @RequestBody VaccinationRequest vaccinationRequest) {
        return vaccinationMapper.mapItemToResponse(vaccinationService.update(id, vaccinationMapper.mapRequestToItem(vaccinationRequest)));
    }
}
