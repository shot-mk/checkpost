package il.co.idf.spring.controller.api;

import il.co.idf.model.Destination;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/destination")
public class DestinationController extends GenericController<Destination> {
}
