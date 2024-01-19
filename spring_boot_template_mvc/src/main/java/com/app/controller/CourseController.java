package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.pojos.Course;
import com.app.service.CourseService;

@Controller
public class CourseController {
	
    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String home(Model model) {
    	List<Course> allCourses = courseService.getAllCourses();
    	allCourses.forEach(p->System.out.println(p));
        model.addAttribute("courses", allCourses);
        return "/index";
    }
   
    @GetMapping("/add")
    public String addCourse(Model model) {
    	
        model.addAttribute("course", new Course());
        return "/course";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.addCourse(course);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editCourse(@PathVariable(value = "id") Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "/course";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable(value = "id") Long id) {
        courseService.deleteCourse(id);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateCourse(@ModelAttribute("course") Course course) {
        courseService.updateCourse(course);
        return "redirect:/";
    }
}
