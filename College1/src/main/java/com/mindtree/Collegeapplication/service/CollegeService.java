package com.mindtree.Collegeapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.Collegeapplication.VO.RequestTemplate;
import com.mindtree.Collegeapplication.entity.College;



@Service
public interface CollegeService {
	
	College add(College collg);
	List<College> list();
	College update(long id, String name);
	College searchById(long id);
	List<RequestTemplate> listwithstu();
	RequestTemplate specificCollgStudent(long collg_id);


}
