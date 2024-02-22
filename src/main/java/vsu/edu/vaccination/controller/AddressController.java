package vsu.edu.vaccination.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination.dto.request.AddressRequest;
import vsu.edu.vaccination.dto.response.AddressResponse;
import vsu.edu.vaccination.mapper.AddressMapper;
import vsu.edu.vaccination.model.Address;
import vsu.edu.vaccination.service.CrudService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final CrudService<Address, UUID> addressService;
    private final AddressMapper mapper;

    @Autowired
    public AddressController(@Qualifier("addressServiceImpl") CrudService<Address, UUID> addressService, AddressMapper mapper) {
        this.addressService = addressService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<AddressResponse> getAddresses() {
        return addressService.getListOfItems().stream()
                .map(mapper::mapItemToResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public AddressResponse getAddress(@PathVariable UUID id) {
        return mapper.mapItemToResponse(addressService.getById(id));
    }

    @PostMapping
    public void createAddress(@RequestBody AddressRequest addressRequest) {
        addressService.save(mapper.mapRequestToItem(addressRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable UUID id) {
        addressService.delete(id);
    }
}
