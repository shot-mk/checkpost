package il.co.idf.spring.controller.api;

import il.co.idf.model.Manufacturer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/manufacturer")
public class ManufacturerController extends GenericController<Manufacturer> {
}
