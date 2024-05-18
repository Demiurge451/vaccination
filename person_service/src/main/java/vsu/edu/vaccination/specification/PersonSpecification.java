package vsu.edu.vaccination.specification;

import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import vsu.edu.vaccination.model.Address;
import vsu.edu.vaccination.model.Person;
import vsu.edu.vaccination.model.Region;

public class PersonSpecification {
    public static Specification<Person> byRegion(String region) {
        return (root, query, criteriaBuilder) -> {
            Join<Person, Address> personAddress = root.join("address");
            Join<Address, Region> personRegion = personAddress.join("region");
            return criteriaBuilder.like(personRegion.get("administrativeDivision"), "%" + region + "%");
        };
    }
}
