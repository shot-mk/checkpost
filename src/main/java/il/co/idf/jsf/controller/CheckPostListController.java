package il.co.idf.jsf.controller;

import il.co.idf.model.CheckPost;
import il.co.idf.spring.repo.CheckPostRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean
@Getter
@Setter
public class CheckPostListController {

	List<CheckPost> checkPosts = new ArrayList<>();

	List<CheckPost> filteredCheckPosts = new ArrayList<>();

	@ManagedProperty("#{checkPostRepository}")
	private CheckPostRepository checkPostRepository;

	@PostConstruct
	public void init() {
		checkPosts = checkPostRepository.findAll();
	}

	public void remove(CheckPost checkPost) {
		checkPostRepository.delete(checkPost.getId());
		checkPosts = checkPostRepository.findAll();
	}

}
