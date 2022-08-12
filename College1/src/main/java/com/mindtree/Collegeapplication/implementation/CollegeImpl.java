package com.mindtree.Collegeapplication.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.Collegeapplication.Repository.CollegeRepository;
import com.mindtree.Collegeapplication.VO.RequestTemplate;
import com.mindtree.Collegeapplication.VO.Student;
import com.mindtree.Collegeapplication.entity.College;
import com.mindtree.Collegeapplication.service.CollegeService;

@Component
public class CollegeImpl implements CollegeService  {
	
	@Autowired
	CollegeRepository collgRepo;
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public College add(College collg) {
		// TODO Auto-generated method stub
		return collgRepo.save(collg);
	}
	@Override
	public List<College> list() {
		// TODO Auto-generated method stub
		return collgRepo.findAll();
	}
	@Override
	public College update(long id, String name) {
		// TODO Auto-generated method stub
		College collg = collgRepo.findById(id);
		collg.setName(name);
		
		return collgRepo.save(collg);
	}
	@Override
	public College searchById(long id) {
		// TODO Auto-generated method stub
		if(collgRepo.findById(id)==null)
		{
			return null;
			
		}
		return collgRepo.findById(id);
	}
	@Override
	public List<RequestTemplate> listwithstu() {
		// TODO Auto-generated method stub
		List<RequestTemplate> fullList = new ArrayList<RequestTemplate>();
		List<College> allCollg= this.list();
		Iterator<College> ir = allCollg.iterator();
		while(ir.hasNext())
		{
         College  collg = ir.next();
			ResponseEntity<Student[]> response= restTemplate.getForEntity("http://STUDENT-SERVICE/student/student-with-ascname/"+collg.getId(), Student[].class);
			Student[] students = response.getBody();
			List< Student> stu = Arrays.asList(students);
			RequestTemplate RTm = new RequestTemplate();
			RTm.setCollege(collg);
			RTm.setStudentList(stu);
			fullList.add(RTm);
			
		}
		
		return fullList;
	}
	@Override
	public RequestTemplate specificCollgStudent(long collg_id) {
		// TODO Auto-generated method stub
		
		College college = this.searchById(collg_id);
		ResponseEntity<Student[]> response= restTemplate.getForEntity("http://STUDENT-SERVICE/student/student-with-desc-age/"+college.getId(), Student[].class);
		Student[] student = response.getBody();
		List< Student> students = Arrays.asList(student);
		RequestTemplate requestTemplate = new RequestTemplate();
		
		requestTemplate.setCollege(college);
		requestTemplate.setStudentList(students);
	    
		return requestTemplate;
	}
	
	

}
