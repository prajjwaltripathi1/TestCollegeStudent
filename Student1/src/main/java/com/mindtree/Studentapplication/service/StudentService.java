package com.mindtree.Studentapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.Studentapplication.VO.ResponseTemplate;
import com.mindtree.Studentapplication.entity.Student;

@Service
public interface StudentService {

	Student add(Student stu);
	List<Student> list();
	Student searchById(long id);
	ResponseTemplate stuWithCollg(long stuId);
	Student assignCollege(long stuId, long collgId);
	List<Student> getByCollgId(long collg_id);
	List<Student> getStudentByCollegeWithDescAge(long collg_id);
}
