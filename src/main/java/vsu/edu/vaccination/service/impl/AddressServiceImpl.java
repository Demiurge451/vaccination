package vsu.edu.vaccination.service.impl;

import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.model.Address;
import vsu.edu.vaccination.repository.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.edu.vaccination.service.AddressService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public List<Address> getListOfAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(UUID id) {
        return addressRepository.findById(id).orElseThrow(() -> new NotFoundException("Address not found"));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        addressRepository.delete(findById(id));
    }

    @Override
    @Transactional
    public void save(Address address) {
        addressRepository.save(address);
    }
}

