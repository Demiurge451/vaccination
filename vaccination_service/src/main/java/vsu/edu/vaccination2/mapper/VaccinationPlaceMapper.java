package vsu.edu.vaccination2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import vsu.edu.vaccination2.dto.request.VaccinationPlaceRequest;
import vsu.edu.vaccination2.dto.response.VaccinationPlaceResponse;
import vsu.edu.vaccination2.dto.response.VaccinationResponse;
import vsu.edu.vaccination2.model.Vaccination;
import vsu.edu.vaccination2.model.VaccinationPlace;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class VaccinationPlaceMapper {
    public abstract VaccinationPlace mapRequestToItem(VaccinationPlaceRequest vaccinationPlaceRequest);

    public abstract VaccinationPlaceResponse mapItemToResponse(VaccinationPlace vaccinationPlace);

    @Mapping(target = "personId", source = "vaccination.person.id")
    @Mapping(target = "vaccinationPlaceId", source = "vaccination.vaccinationPlace.id")
    public abstract VaccinationResponse mapVaccinationToResponse(Vaccination vaccination);

    public abstract void updateVaccinationPlace(VaccinationPlace source, @MappingTarget VaccinationPlace target);
}
