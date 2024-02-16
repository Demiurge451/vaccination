package vsu.edu.vaccination.controller;

import org.springframework.web.bind.annotation.*;
import vsu.edu.vaccination.model.Address;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.service.AddressService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    public List<Address> getAddresses() {
        return addressService.getListOfAddresses();
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable UUID id) {
        return addressService.findById(id);
    }

    @PostMapping("/")
    public void createAddress(@RequestBody Address address) {
        addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable UUID id) {
        addressService.delete(id);
    }
}
