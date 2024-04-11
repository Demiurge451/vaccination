package vsu.edu.vaccination2.controller;

import jakarta.validation.Valid;
import vsu.edu.vaccination2.dto.request.VaccinationPlaceRequest;
import vsu.edu.vaccination2.dto.response.VaccinationPlaceResponse;
import vsu.edu.vaccination2.mapper.VaccinationPlaceMapper;
import vsu.edu.vaccination2.model.VaccinationPlace;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination2.service.CrudService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/vaccination_place")
public class VaccinationPlaceController {
    private final CrudService<VaccinationPlace, UUID> vaccinationPlaceService;
    private final VaccinationPlaceMapper vaccinationPlaceMapper;

    public VaccinationPlaceController(@Qualifier("vaccinationPlaceServiceImpl") CrudService<VaccinationPlace, UUID> vaccinationPlaceService, VaccinationPlaceMapper vaccinationPlaceMapper) {
        this.vaccinationPlaceService = vaccinationPlaceService;
        this.vaccinationPlaceMapper = vaccinationPlaceMapper;
    }

    @GetMapping
    public List<VaccinationPlaceResponse> getVaccinationPlaces(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "id") String sortParam
    ) {
        return vaccinationPlaceService.getListOfItems(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sortParam)))
                .stream().map(vaccinationPlaceMapper::mapItemToResponse).toList();
    }

    @GetMapping("/{id}")
    public @Valid VaccinationPlaceResponse getVaccinationPlace(@PathVariable UUID id) {
        return vaccinationPlaceMapper.mapItemToResponse(vaccinationPlaceService.getById(id));
    }

    @PostMapping
    public void createVaccinationPlace(@RequestBody VaccinationPlaceRequest vaccinationPlaceRequest) {
        vaccinationPlaceService.save(vaccinationPlaceMapper.mapRequestToItem(vaccinationPlaceRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteVaccinationPlace(@PathVariable UUID id) {
        vaccinationPlaceService.delete(id);
    }

    @PutMapping("/{id}")
    public VaccinationPlaceResponse updateVaccinationPlace(@PathVariable UUID id, @RequestBody VaccinationPlaceRequest vaccinationPlaceRequest) {
         return vaccinationPlaceMapper.mapItemToResponse(vaccinationPlaceService.update(id, vaccinationPlaceMapper.mapRequestToItem(vaccinationPlaceRequest)));
    }
}
