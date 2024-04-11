package vsu.edu.vaccination.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import vsu.edu.vaccination.dto.request.AddressRequest;
import vsu.edu.vaccination.dto.response.AddressResponse;
import vsu.edu.vaccination.exception.NotFoundException;
import vsu.edu.vaccination.mapper.AddressMapper;
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
    private final AddressMapper addressMapper;
    @Override
    public List<Address> getListOfItems(PageRequest pageRequest) {
        return addressRepository.findAll(pageRequest).getContent();
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
    @Transactional
    public Address update(UUID id, Address item) {
        Address address = this.getById(id);
        addressMapper.updateAddress(item, address);
        return addressRepository.save(address);
    }


}

