package vsu.edu.vaccination.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import vsu.edu.vaccination.dto.request.RegionRequest;
import vsu.edu.vaccination.dto.response.RegionResponse;
import vsu.edu.vaccination.model.Region;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class RegionMapper {
    public abstract Region mapRequestToItem(RegionRequest regionRequest);
    public abstract RegionResponse mapItemToResponse(Region region);

    public abstract void updateRegion(Region source, @MappingTarget Region target);
}
