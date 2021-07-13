package Step2FormTest.repositories;

import Step2FormTest.models.ControlledProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlledProcessRepository extends JpaRepository<ControlledProcess, Long> {}
