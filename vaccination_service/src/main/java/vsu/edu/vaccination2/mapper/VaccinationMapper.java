package vsu.edu.vaccination2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import vsu.edu.vaccination2.dto.request.VaccinationRequest;
import vsu.edu.vaccination2.dto.response.VaccinationResponse;
import vsu.edu.vaccination2.model.Person;
import vsu.edu.vaccination2.model.Vaccination;
import vsu.edu.vaccination2.model.VaccinationPlace;
import vsu.edu.vaccination2.service.CrudService;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class VaccinationMapper {
    public abstract Vaccination mapRequestToItem(VaccinationRequest vaccinationRequest);

    public abstract VaccinationResponse mapItemToResponse(Vaccination vaccination);

    public abstract void updateVaccination(Vaccination source, @MappingTarget Vaccination target);

    public abstract List<VaccinationResponse> mapItemsToResponse(List<Vaccination> source);
}
