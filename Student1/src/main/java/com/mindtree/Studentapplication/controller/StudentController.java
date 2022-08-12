package com.mindtree.Studentapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.Studentapplication.VO.ResponseTemplate;
import com.mindtree.Studentapplication.entity.Student;
import com.mindtree.Studentapplication.service.StudentService;

@RestController
@RequestMapping("/student")

public class StudentController {
	
	@Autowired
	StudentService stuService;
	
	@PostMapping
	public Student add(@RequestBody Student stu)
	{
		return stuService.add(stu);
	}
	
	@GetMapping
	public List<Student> listStu(){
		return stuService.list();
	}
	@GetMapping("/{stuId}")
	public ResponseTemplate stuWithCollg(@PathVariable long stuId)
	{
		return stuService.stuWithCollg(stuId);
	}
	
	@PutMapping("/{stuId}/{collgId}")
	public String updateCollege(@PathVariable long stuId,@PathVariable long collgId)
	{
		Student stu = stuService.assignCollege(stuId, collgId);
		if(stu != null)
		{
			return stu.toString();
			
		}
		return "Student Not Found";
	}
	
		
	
	@GetMapping("/student-with-ascname/{collg_id}")
	public List<Student>getByCollgId(@PathVariable long collg_id)
	{
		return stuService.getByCollgId(collg_id);
	}
	@GetMapping("/student-with-desc-age/{collg_id}")
	public List<Student> getStudentByCollegeWithDescAge(@PathVariable long collg_id)
	{
		return stuService.getStudentByCollegeWithDescAge(collg_id);
	}

}
