package Step2FormTest.repositories;

import Step2FormTest.models.ControlStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlStructureRepository extends JpaRepository<ControlStructure, Long> {}
