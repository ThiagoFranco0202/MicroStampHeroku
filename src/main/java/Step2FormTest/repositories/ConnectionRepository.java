package Step2FormTest.repositories;

import Step2FormTest.models.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {

    @Query(value = "SELECT * FROM connection c WHERE c.control_structure_id = ?1", nativeQuery = true)
    List<Connection> findConnectionsByControlStructureId(long id);
}
