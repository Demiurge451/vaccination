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

import java.util.UUID;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class VaccinationMapper {
    protected CrudService<Person, UUID> personService;
    protected CrudService<VaccinationPlace, UUID> vaccinationPlaceService;

    @Autowired
    protected void setVaccinationMapper(@Qualifier("personServiceImpl") CrudService<Person, UUID> personService,
                                        @Qualifier("vaccinationPlaceServiceImpl") CrudService<VaccinationPlace, UUID> vaccinationPlaceService) {
        this.personService = personService;
        this.vaccinationPlaceService = vaccinationPlaceService;
    }

    @Mapping(target = "person", expression = "java(personService.getById(vaccinationRequest.getPersonId()))")
    @Mapping(target = "vaccinationPlace", expression = "java(vaccinationPlaceService.getById(vaccinationRequest.getVaccinationPlaceId()))")
    public abstract Vaccination mapRequestToItem(VaccinationRequest vaccinationRequest);

    @Mapping(target = "personId", source = "vaccination.person.id")
    @Mapping(target = "vaccinationPlaceId", source = "vaccination.vaccinationPlace.id")
    public abstract VaccinationResponse mapItemToResponse(Vaccination vaccination);

    public abstract void updateVaccination(Vaccination source, @MappingTarget Vaccination target);
}
