package vsu.edu.vaccination2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import vsu.edu.vaccination2.dto.request.PersonRequest;
import vsu.edu.vaccination2.dto.response.PersonResponse;
import vsu.edu.vaccination2.dto.response.VaccinationResponse;
import vsu.edu.vaccination2.model.Person;
import vsu.edu.vaccination2.model.Vaccination;


@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class PersonMapper {
    public abstract Person mapRequestToItem(PersonRequest personRequest);

    public abstract PersonResponse mapItemToResponse(Person person);

    @Mapping(target = "personId", source = "vaccination.person.id")
    @Mapping(target = "vaccinationPlaceId", source = "vaccination.vaccinationPlace.id")
    public abstract VaccinationResponse mapVaccinationToResponse(Vaccination vaccination);

    public abstract void updatePerson(Person source, @MappingTarget Person target);
}
