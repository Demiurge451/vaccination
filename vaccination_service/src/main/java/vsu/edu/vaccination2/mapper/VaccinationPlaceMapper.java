package vsu.edu.vaccination2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import vsu.edu.vaccination2.dto.request.VaccinationPlaceRequest;
import vsu.edu.vaccination2.dto.response.VaccinationPlaceResponse;
import vsu.edu.vaccination2.dto.response.VaccinationResponse;
import vsu.edu.vaccination2.model.Region;
import vsu.edu.vaccination2.model.Vaccination;
import vsu.edu.vaccination2.model.VaccinationPlace;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class VaccinationPlaceMapper {
    protected IdMapper<Vaccination, UUID> idMapper;

    @Autowired
    protected void setAlbumMapper(IdMapper<Vaccination, UUID> idMapper) {
        this.idMapper = idMapper;
    }

    public abstract VaccinationPlace mapRequestToItem(VaccinationPlaceRequest vaccinationPlaceRequest);

    @Mapping(target = "vaccinations", expression = "java(idMapper.mapItemToId(vaccinationPlace.getVaccinations()))")
    public abstract VaccinationPlaceResponse mapItemToResponse(VaccinationPlace vaccinationPlace);

    public abstract void updateVaccinationPlace(VaccinationPlace source, @MappingTarget VaccinationPlace target);

    public abstract List<VaccinationPlaceResponse> mapItemsToResponses(List<VaccinationPlace> sources);
}
