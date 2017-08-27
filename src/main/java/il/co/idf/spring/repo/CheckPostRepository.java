package il.co.idf.spring.repo;

import il.co.idf.model.CheckPost;
import il.co.idf.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckPostRepository extends JpaRepository<CheckPost, Long> {

    Long countAllByDistrict(District district);

    Long countAllByDistrictName(String name);

    List<CheckPost> findTop10ByOrderByDateCreatedDesc();

}
