package il.co.idf.spring.controller;

import il.co.idf.model.CheckPost;
import il.co.idf.spring.service.CheckPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

	@Autowired
	CheckPostService checkPostService;

	@GetMapping("/findAll")
	@ResponseBody
	public List<CheckPost> findAll() {
		return checkPostService.findAll();
	}

}





