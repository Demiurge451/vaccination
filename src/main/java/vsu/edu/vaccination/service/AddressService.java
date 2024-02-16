package vsu.edu.vaccination.service;



import vsu.edu.vaccination.model.Address;

import java.util.List;
import java.util.UUID;

public interface AddressService {
    List<Address> getListOfAddresses();
    Address findById(UUID id);
    void delete(UUID id);
    void save(Address address);
}
