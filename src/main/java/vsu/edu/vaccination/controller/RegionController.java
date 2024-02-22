package vsu.edu.vaccination.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination.dto.request.RegionRequest;
import vsu.edu.vaccination.dto.response.RegionResponse;
import vsu.edu.vaccination.mapper.RegionMapper;
import vsu.edu.vaccination.model.Region;
import vsu.edu.vaccination.service.CrudService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/region")
public class RegionController {
    private final CrudService<Region, UUID> regionService;
    private final RegionMapper mapper;

    @Autowired
    public RegionController(@Qualifier("regionServiceImpl") CrudService<Region, UUID> regionService, RegionMapper mapper) {
        this.regionService = regionService;
        this.mapper = mapper;
    }


    @GetMapping
    public List<RegionResponse> getRegions() {
        return regionService.getListOfItems().stream().map(mapper::mapItemToResponse).toList();
    }

    @GetMapping("/{id}")
    public RegionResponse getRegion(@PathVariable UUID id) {
        return mapper.mapItemToResponse(regionService.getById(id));
    }

    @PostMapping
    public void createRegion(@RequestBody RegionRequest request) {
        regionService.save(mapper.mapRequestToItem(request));
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable UUID id) {
        regionService.delete(id);
    }
}

