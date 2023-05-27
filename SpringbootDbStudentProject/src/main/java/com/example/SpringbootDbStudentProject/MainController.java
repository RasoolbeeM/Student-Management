package com.example.SpringbootDbStudentProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@Autowired
	StudentRepo repo;
	
	@RequestMapping("show")
	String stdFrontEnd()
	{
		System.out.println("xxxxx");
		return "addStudent.jsp";
	}
	
	@RequestMapping("addStudent")
	String backtoMain(Student s)
	{
		repo.save(s);
		return "addStudent.jsp";
	}
	
	@RequestMapping("findStdByMarks")
	
	String findByTotalMarks(HttpSession h1, Integer marks)
	{
		
		
		List<Student> std= repo.findByTotalMarks(marks);
		System.out.println("---------------");
		
		h1.setAttribute("student", std);
		return "display.jsp";		
	}
	
	
	@RequestMapping("display")
	Student displayDetails(Student s)
	{
		return s;
	}
}
