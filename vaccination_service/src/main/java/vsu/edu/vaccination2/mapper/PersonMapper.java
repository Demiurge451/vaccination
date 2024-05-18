package vsu.edu.vaccination2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import vsu.edu.vaccination2.dto.request.PersonRequest;
import vsu.edu.vaccination2.dto.response.PersonResponse;
import vsu.edu.vaccination2.dto.response.VaccinationResponse;
import vsu.edu.vaccination2.model.Person;
import vsu.edu.vaccination2.model.Region;
import vsu.edu.vaccination2.model.Vaccination;

import java.util.List;
import java.util.UUID;


@Mapper(componentModel = "spring")
public abstract class PersonMapper {
    protected IdMapper<Vaccination, UUID> idMapper;

    @Autowired
    protected void setAlbumMapper(IdMapper<Vaccination, UUID> idMapper) {
        this.idMapper = idMapper;
    }

    public abstract Person mapRequestToItem(PersonRequest personRequest);

    @Mapping(target = "vaccinations", expression = "java(idMapper.mapItemToId(person.getVaccinations()))")
    public abstract PersonResponse mapItemToResponse(Person person);

    public abstract void updatePerson(Person source, @MappingTarget Person target);

    public abstract List<PersonResponse> mapItemsToResponse(List<Person> source);
}
