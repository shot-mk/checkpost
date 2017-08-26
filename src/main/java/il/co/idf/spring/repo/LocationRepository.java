package il.co.idf.spring.repo;


import il.co.idf.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	List<Location> findLocationsByNameContaining(String name);

	Location findByName(String trim);
}
