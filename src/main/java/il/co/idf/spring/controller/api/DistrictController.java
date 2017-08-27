package il.co.idf.spring.controller.api;

import il.co.idf.model.District;
import il.co.idf.spring.repo.CheckPostRepository;
import il.co.idf.spring.repo.DistrictRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/district")
public class DistrictController extends GenericController<District> {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private CheckPostRepository checkPostRepository;

    @RequestMapping("/details")
    public List<DistrictDetail> getDistrictDetails() {
        List<District> districts = districtRepository.findAll();
        List<DistrictDetail> districtDetails = new ArrayList<>();
        for (District district : districts) {
            Long numberOfCheckposts = checkPostRepository.countAllByDistrict(district);
            districtDetails.add(new DistrictDetail(district, numberOfCheckposts));
        }
        return districtDetails;
    }


    @Data
    @AllArgsConstructor
    class DistrictDetail {

        private District district;
        private Long numberOfCheckposts;

    }
}
