package vsu.edu.vaccination2.repository;

import vsu.edu.vaccination2.model.VaccinationPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VaccinationPlaceRepository extends JpaRepository<VaccinationPlace, UUID> {
}
