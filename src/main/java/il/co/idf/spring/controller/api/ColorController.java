package il.co.idf.spring.controller.api;

import il.co.idf.model.Color;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/color")
public class ColorController extends GenericController<Color> {
}
