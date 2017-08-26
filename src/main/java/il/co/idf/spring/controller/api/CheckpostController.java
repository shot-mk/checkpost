package il.co.idf.spring.controller.api;


import il.co.idf.model.CheckPost;
import il.co.idf.spring.service.CheckPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/checkpost")
public class CheckpostController extends GenericController<CheckPost> {

    @Autowired
    private CheckPostService checkPostService;


}
