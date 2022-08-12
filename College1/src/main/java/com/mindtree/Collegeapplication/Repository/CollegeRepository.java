package com.mindtree.Collegeapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.Collegeapplication.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College , Long > {
	
	College findById(long id);

	

}
