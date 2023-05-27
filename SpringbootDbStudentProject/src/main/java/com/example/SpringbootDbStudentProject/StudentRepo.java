package com.example.SpringbootDbStudentProject;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer>
{
	
	@Query(value="select * from student where marks=?1",nativeQuery=true)
	List<Student> findByTotalMarks(int marks);
    
}
