package il.co.idf.spring.controller.api;

import il.co.idf.model.District;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/district")
public class DistrictController extends GenericController<District> {
}
