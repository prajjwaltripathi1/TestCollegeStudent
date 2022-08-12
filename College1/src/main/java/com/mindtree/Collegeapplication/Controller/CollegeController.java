package com.mindtree.Collegeapplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mindtree.Collegeapplication.VO.RequestTemplate;
import com.mindtree.Collegeapplication.entity.College;
import com.mindtree.Collegeapplication.service.CollegeService;

public class CollegeController {
	
	@Autowired
	CollegeService collgService;
	
	@PostMapping
	public College add(@RequestBody College collg)
	{
		return collgService.add(collg);
		
	}
	
	@GetMapping
	public List<College>list()
	{
		return collgService.list();
		
	}
	@GetMapping("/{id}")
	public College searchById(@PathVariable long id )
	{
		return collgService.searchById(id);
		
	}
     @GetMapping("/all-college-student")
     public List<RequestTemplate> listWithStu()
     {
    	 return collgService.listwithstu();
     }
     
     @GetMapping("/college-with-student/{dept_id}")
     public RequestTemplate specificCollgStu(@PathVariable long collg_id)
     {
    	 return collgService.specificCollgStudent(collg_id);
     }

}
