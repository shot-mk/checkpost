package il.co.idf.spring.repo;

import il.co.idf.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Passenger, Long> {
}
