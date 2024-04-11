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
import vsu.edu.vaccination.model.Region;
import vsu.edu.vaccination.service.CrudService;

import java.util.UUID;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class AddressMapper {

    protected CrudService<Region, UUID> regionService;

    @Autowired
    public void setAddressMapper(@Qualifier("regionServiceImpl") CrudService<Region, UUID> regionService) {
        this.regionService = regionService;
    }

    @Mapping(target = "region", expression = "java(regionService.getById(addressRequest.getRegionId()))")
    public abstract Address mapRequestToItem(AddressRequest addressRequest);

    @Mapping(target = "regionId", source = "address.region.id")
    public abstract AddressResponse mapItemToResponse(Address address);

    public abstract void updateAddress(Address source, @MappingTarget Address target);
}
