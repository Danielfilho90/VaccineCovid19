package school.cesar.hackaton.project.vaccine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.cesar.hackaton.project.vaccine.entity.Vaccine;
import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

    List<Vaccine> findByNameContainingOrderByNameAsc(final String name);

}
