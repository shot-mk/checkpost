package il.co.idf.spring.repo;

import il.co.idf.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

	Destination findByName(String name);

	List<Destination> findAllDestinationByNameContaining(String name);

}
