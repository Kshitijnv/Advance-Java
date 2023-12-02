package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Course;
import com.app.pojos.Student;
import com.app.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/addStudent")
	public String homeController() {
		System.out.println("in method addStudent " + getClass().getName());
		return "/students/add_student_form";
	}
	
	
	@PostMapping("/show")
	public String addPlayer(@RequestParam String fn, @RequestParam String ln, @RequestParam String city,
			@RequestParam String myCourse, Model map) {
		Student stu = new Student(fn, ln, city, Course.valueOf(myCourse));
		String result = studentService.addStudent(stu);
		map.addAttribute("student", result);
		return "/students/show";
	}
	
	@RequestMapping("/display")
	public String diplayStudent(Model map) {
		System.out.println("in displayStudent controller");
		List<Student> list = studentService.displayStudents();
//		list.forEach(p->System.out.println(p));
		map.addAttribute("listOfStu",list);
		return "/students/display_list";
	}
	@PostMapping("/course")
	public String viewStudent(@RequestParam String myCourse, Model map) {
		System.out.println("in view student");
		List<Student> list =studentService.findByCourse(Course.valueOf(myCourse));
		map.addAttribute("filterStudent",list);
		return "/students/filter_students";
	}
	@RequestMapping("/find")
	public String mycontrol() {
		return "/students/search_student";
	}
}
