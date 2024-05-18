package vsu.edu.vaccination.controller;


import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination.dto.request.RegionRequest;
import vsu.edu.vaccination.dto.response.RegionResponse;
import vsu.edu.vaccination.mapper.RegionMapper;
import vsu.edu.vaccination.model.Region;
import vsu.edu.vaccination.service.CrudService;
import vsu.edu.vaccination.sort_enums.RegionSortParam;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/region")
public class RegionController {
    private final CrudService<Region, UUID> regionService;
    private final RegionMapper mapper;

    public RegionController(CrudService<Region, UUID> regionService, RegionMapper mapper) {
        this.regionService = regionService;
        this.mapper = mapper;
    }


    @GetMapping
    public @Valid List<RegionResponse> getRegions(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "ID_ASC") RegionSortParam sortParam
    ) {
        return mapper.mapItemsToResponse(
                regionService.getAll(PageRequest.of(page, size, sortParam.getSortValue()))
        );
    }

    @GetMapping("/{id}")
    public @Valid RegionResponse getRegion(@PathVariable UUID id) {
        return mapper.mapItemToResponse(regionService.getById(id));
    }

    @PostMapping
    public void createRegion(@Valid @RequestBody RegionRequest request) {
        regionService.save(mapper.mapRequestToItem(request));
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable UUID id) {
        regionService.delete(id);
    }

    @PutMapping("/{id}")
    public @Valid RegionResponse updateRegion(@PathVariable UUID id, @Valid @RequestBody RegionRequest regionRequest) {
        return mapper.mapItemToResponse(regionService.update(id, mapper.mapRequestToItem(regionRequest)));
    }
}

