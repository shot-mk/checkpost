package il.co.idf.spring.repo;


import il.co.idf.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	List<Location> findLocationsByLocationContaining(String location);

	Location findByLocation(String trim);
}
