package com.mindtree.Studentapplication.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.Studentapplication.VO.College;
import com.mindtree.Studentapplication.VO.ResponseTemplate;
import com.mindtree.Studentapplication.entity.Student;
import com.mindtree.Studentapplication.repository.StudentRepository;
import com.mindtree.Studentapplication.service.StudentService;

@Component
public class StudentImpl implements StudentService {
	
	@Autowired
	private StudentRepository stuRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Student add(Student stu) {
		// TODO Auto-generated method stub
		return stuRepo.save(stu);
	}

	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		return stuRepo.findAll();
	}

	@Override
	public Student searchById(long id) {
		// TODO Auto-generated method stub
		return stuRepo.findById(id);
	}

	@Override
	public ResponseTemplate stuWithCollg(long stuId) {
		// TODO Auto-generated method stub
		ResponseTemplate RT = new ResponseTemplate();
		Student std = stuRepo.findById(stuId);
		
		long collg_id = std.getcollg_id();
		College collg = restTemplate.getForObject("http://COLLEGE-SERVICE/college/" +collg_id, College.class);
		RT.setCollege(collg);
		RT.setStudent(std);
		return RT;
	}

	@Override
	public Student assignCollege(long stuId, long collgId) {
		// TODO Auto-generated method stub
		Student stu = stuRepo.findById(stuId);
		College collg = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+ collgId, College.class);
		if(stu== null || collg==null )
		{
			return null;
			
		}
		stu.setCollg_id(collgId);
		stuRepo.save(stu);
		return stu;
	}

	@Override
	public List<Student> getByCollgId(long collg_id) {
		// TODO Auto-generated method stub
		return stuRepo.getByCollgId(collg_id);
	}

	@Override
	public List<Student> getStudentByCollegeWithDescAge(long dept_id) {
		// TODO Auto-generated method stub
		return stuRepo.getStudentByCollegeWithDescAge(dept_id);
	}

}
