package il.co.idf.spring.service;

import il.co.idf.model.GenericEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class GenericService<MODEL extends GenericEntity> {

    @Autowired
    private JpaRepository<MODEL, Long> repo;

    public List<MODEL> findAll() {
        return repo.findAll();
    }

    public MODEL save(MODEL model) {
        return repo.save(model);
    }

    public void delete(MODEL model) {
        repo.delete(model);
    }

    public void delete(Long id) {
        repo.delete(id);
    }

    public MODEL findOne(Long id) {
        return repo.findOne(id);
    }


}
