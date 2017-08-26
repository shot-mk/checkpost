package il.co.idf.spring.service;

import il.co.idf.model.District;
import il.co.idf.model.CheckPost;
import il.co.idf.spring.repo.DistrictRepository;
import il.co.idf.spring.repo.CheckPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckPostService extends GenericService<CheckPost> {

	@Autowired
	CheckPostRepository checkPostRepository;

	@Autowired
	DistrictRepository districtRepository;

	public Map<District, Long> getCheckPostNumberPerArea() {
		Map<District, Long> checkPostPerArea = new HashMap<>();
		List<District> districts = districtRepository.findAll();
		for (District district : districts) {
			Long number = checkPostRepository.countAllByDistrict(district);
			if (number != null) {
				checkPostPerArea.put(district, number);
			} else {
				checkPostPerArea.put(district, 0L);
			}
		}
		return checkPostPerArea;
	}

	public Long getCheckpostNumberForArea(String areaName) {
		return checkPostRepository.countAllByDistrictName(areaName);
	}

	public List<CheckPost> findLastCreatedCheckPosts() {
		return checkPostRepository.findTop10ByOrderByDateCreatedDesc();
	}

}
