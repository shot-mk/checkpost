package il.co.idf.spring.controller.api;

import il.co.idf.model.Passenger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController extends GenericController<Passenger> {
}
