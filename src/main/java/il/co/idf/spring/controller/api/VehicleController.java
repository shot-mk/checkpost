package il.co.idf.spring.controller.api;

import il.co.idf.model.Vehicle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController extends GenericController<Vehicle> {
}
