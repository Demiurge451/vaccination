package vsu.edu.vaccination.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import vsu.edu.vaccination.dto.request.AddressRequest;
import vsu.edu.vaccination.dto.response.AddressResponse;
import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.model.Address;
import vsu.edu.vaccination.repository.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.edu.vaccination.service.CrudService;

import java.util.List;
import java.util.UUID;

@Service("addressServiceImpl")
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AddressServiceImpl implements CrudService<Address, UUID> {
    private final AddressRepository addressRepository;
    @Override
    public List<Address> getListOfItems() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(UUID id) {
        if (id == null) {
            return null;
        }
        return addressRepository.findById(id).orElseThrow(() -> new NotFoundException("Address not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        addressRepository.delete(getById(id));
    }

    @Override
    @Transactional
    public void save(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Address update(UUID id, Address item) {
        Address address = this.getById(id);
        address.setCity(item.getCity());
        address.setStreet(item.getStreet());
        address.setBuildingNumber(item.getBuildingNumber());
        address.setRegion(item.getRegion());
        address.setPeople(item.getPeople());
        return addressRepository.save(address);
    }


}

