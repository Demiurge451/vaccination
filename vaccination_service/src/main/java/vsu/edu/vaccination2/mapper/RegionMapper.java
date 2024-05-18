package vsu.edu.vaccination2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import vsu.edu.vaccination2.dto.request.RegionRequest;
import vsu.edu.vaccination2.dto.response.RegionResponse;
import vsu.edu.vaccination2.model.Region;
import vsu.edu.vaccination2.model.VaccinationPlace;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class RegionMapper {
    protected IdMapper<VaccinationPlace, UUID> idMapper;

    @Autowired
    protected void setAlbumMapper(IdMapper<VaccinationPlace, UUID> idMapper) {
        this.idMapper = idMapper;
    }

    public abstract Region mapRequestToItem(RegionRequest regionRequest);

    @Mapping(target = "vaccinationPlaces", expression = "java(idMapper.mapItemToId(region.getVaccinationPlaces()))")
    public abstract RegionResponse mapItemToResponse(Region region);

    public abstract void updateRegion(Region source, @MappingTarget Region target);

    public abstract List<RegionResponse> mapItemsToResponse(List<Region> regions);
}
