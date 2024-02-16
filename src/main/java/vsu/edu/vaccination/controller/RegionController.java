package vsu.edu.vaccination.controller;


import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination.model.Region;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.service.RegionService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/region")
public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/")
    public List<Region> getRegions() {
        return regionService.getListOfRegions();
    }

    @GetMapping("/{id}")
    public Region getRegion(@PathVariable UUID id) {
        return regionService.findById(id);
    }

    @PostMapping("/")
    public void createRegion(@RequestBody Region address) {
        regionService.save(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable UUID id) {
        regionService.delete(id);
    }
}

