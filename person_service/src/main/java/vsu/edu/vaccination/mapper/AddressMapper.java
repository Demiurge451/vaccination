package vsu.edu.vaccination.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import vsu.edu.vaccination.dto.request.AddressRequest;
import vsu.edu.vaccination.dto.response.AddressResponse;
import vsu.edu.vaccination.model.Address;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.model.Region;
import vsu.edu.vaccination.service.CrudService;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class AddressMapper {
    protected IdMapper<Person, UUID> idMapper;

    @Autowired
    public void setAddressMapper(IdMapper<Person, UUID> idMapper) {
        this.idMapper = idMapper;
    }

    public abstract Address mapRequestToItem(AddressRequest addressRequest);

    @Mapping(target = "people", expression = "java(idMapper.mapItemToId(address.getPeople()))")
    public abstract AddressResponse mapItemToResponse(Address address);

    public abstract void updateAddress(Address source, @MappingTarget Address target);
    public abstract List<AddressResponse> mapItemsToResponse(List<Address> addresses);
}
