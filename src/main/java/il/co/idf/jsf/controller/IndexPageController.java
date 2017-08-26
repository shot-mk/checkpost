package il.co.idf.jsf.controller;

import il.co.idf.model.District;
import il.co.idf.model.CheckPost;
import il.co.idf.spring.repo.DistrictRepository;
import il.co.idf.spring.service.CheckPostService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@Getter
@Setter
@ManagedBean
public class IndexPageController {

	@ManagedProperty("#{checkPostService}")
	private CheckPostService checkPostService;

	@ManagedProperty("#{areaRepository}")
	private DistrictRepository districtRepository;

	private List<District> districts = new ArrayList<>();

	private List<CheckPost> latestCheckPosts = new ArrayList<>();

	@PostConstruct
	public void init() {
		districts = districtRepository.findAllByOrderByName();
		latestCheckPosts = checkPostService.findLastCreatedCheckPosts();
	}

	public Long getCheckPostNumberForArea(String name) {
		return checkPostService.getCheckpostNumberForArea(name);
	}

	public Long getTelephone(String telephone) {
		String telephoneOnlyNumbers = telephone.replaceAll("\\D+","");
		return Long.decode(telephoneOnlyNumbers);
	}



}
