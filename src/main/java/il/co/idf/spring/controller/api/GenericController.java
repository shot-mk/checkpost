package il.co.idf.spring.controller.api;

import il.co.idf.model.CheckPost;
import il.co.idf.model.GenericEntity;
import il.co.idf.spring.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class GenericController<MODEL extends GenericEntity> {

    @Autowired
    GenericService<MODEL> genericService;

    @RequestMapping(method = RequestMethod.GET)
    public List<MODEL> findAll() {
        return genericService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCheckPost(@RequestBody MODEL checkPost) {
        genericService.save(checkPost);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MODEL findOne(@PathVariable("id") Long id) {
        return genericService.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public MODEL editOne(@PathVariable("id") Long id, @RequestBody MODEL model) {
        return genericService.save(model);
    }
}
