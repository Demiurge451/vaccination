package vsu.edu.vaccination.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import vsu.edu.vaccination.dto.request.RegionRequest;
import vsu.edu.vaccination.dto.response.RegionResponse;
import vsu.edu.vaccination.model.Address;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.model.Region;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class RegionMapper {
    protected IdMapper<Address, UUID> idMapper;
    @Autowired
    protected void setAlbumMapper(IdMapper<Address, UUID> idMapper) {
        this.idMapper = idMapper;
    }

    public abstract Region mapRequestToItem(RegionRequest regionRequest);

    @Mapping(target = "addresses", expression = "java(idMapper.mapItemToId(region.getAddresses()))")
    public abstract RegionResponse mapItemToResponse(Region region);

    public abstract void updateRegion(Region source, @MappingTarget Region target);

    public abstract List<RegionResponse> mapItemsToResponse(List<Region> regions);
}
