package vsu.edu.vaccination.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination.dto.request.AddressRequest;
import vsu.edu.vaccination.dto.response.AddressResponse;
import vsu.edu.vaccination.mapper.AddressMapper;
import vsu.edu.vaccination.model.Address;
import vsu.edu.vaccination.service.CrudService;
import vsu.edu.vaccination.sort_enums.AddressSortParam;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final CrudService<Address, UUID> addressService;
    private final AddressMapper mapper;

    public AddressController(CrudService<Address, UUID> addressService, AddressMapper mapper) {
        this.addressService = addressService;
        this.mapper = mapper;
    }

    @GetMapping
    public @Valid List<AddressResponse> getAddresses(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "ID_ASC") AddressSortParam sortParam) {
        return mapper.mapItemsToResponse(
                addressService.getAll(PageRequest.of(page, size, sortParam.getSortValue()))
        );
    }

    @GetMapping("/{id}")
    public @Valid AddressResponse getAddress(@PathVariable UUID id) {
        return mapper.mapItemToResponse(addressService.getById(id));
    }

    @PostMapping
    public void createAddress(@Valid @RequestBody AddressRequest addressRequest) {
        addressService.save(mapper.mapRequestToItem(addressRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable UUID id) {
        addressService.delete(id);
    }

    @PutMapping("/{id}")
    public @Valid AddressResponse updateAddress(@PathVariable UUID id, @Valid @RequestBody AddressRequest addressRequest) {
        return mapper.mapItemToResponse(addressService.update(id, mapper.mapRequestToItem(addressRequest)));
    }
}
