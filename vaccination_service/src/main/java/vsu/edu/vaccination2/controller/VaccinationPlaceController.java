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
import vsu.edu.vaccination2.sort_enums.VaccinationPlaceSortParam;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/vaccination_place")
public class VaccinationPlaceController {
    private final CrudService<VaccinationPlace, UUID> vaccinationPlaceService;
    private final VaccinationPlaceMapper vaccinationPlaceMapper;

    public VaccinationPlaceController(CrudService<VaccinationPlace, UUID> vaccinationPlaceService, VaccinationPlaceMapper vaccinationPlaceMapper) {
        this.vaccinationPlaceService = vaccinationPlaceService;
        this.vaccinationPlaceMapper = vaccinationPlaceMapper;
    }

    @GetMapping
    public @Valid List<VaccinationPlaceResponse> getVaccinationPlaces(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "ID_ASC") VaccinationPlaceSortParam sortParam
    ) {
        return vaccinationPlaceMapper.mapItemsToResponses(
                vaccinationPlaceService.getListOfItems(PageRequest.of(page, size, sortParam.getSortValue()))
        );
    }

    @GetMapping("/{id}")
    public @Valid VaccinationPlaceResponse getVaccinationPlace(@PathVariable UUID id) {
        return vaccinationPlaceMapper.mapItemToResponse(vaccinationPlaceService.getById(id));
    }

    @PostMapping
    public void createVaccinationPlace(@Valid @RequestBody VaccinationPlaceRequest vaccinationPlaceRequest) {
        vaccinationPlaceService.save(vaccinationPlaceMapper.mapRequestToItem(vaccinationPlaceRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteVaccinationPlace(@PathVariable UUID id) {
        vaccinationPlaceService.delete(id);
    }

    @PutMapping("/{id}")
    public @Valid VaccinationPlaceResponse updateVaccinationPlace(@PathVariable UUID id, @Valid @RequestBody VaccinationPlaceRequest vaccinationPlaceRequest) {
         return vaccinationPlaceMapper.mapItemToResponse(vaccinationPlaceService.update(id, vaccinationPlaceMapper.mapRequestToItem(vaccinationPlaceRequest)));
    }
}
