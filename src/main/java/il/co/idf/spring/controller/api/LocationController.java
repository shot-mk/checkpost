package il.co.idf.spring.controller.api;

import il.co.idf.model.Location;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/location")
public class LocationController extends GenericController<Location> {
}
