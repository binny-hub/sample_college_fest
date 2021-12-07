package com.college.fest.controller;

import com.college.fest.entity.Students;
import com.college.fest.service.StudentService;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Students")
public class StudentsController {

	@Autowired
	private StudentService studentService;

	// add mapping for "/list"

	@RequestMapping("/list")
	public String listStudents(Model theModel) {

		// get Students from db
		List<Students> theStudents = studentService.findAll();

		// add to the spring model
		theModel.addAttribute("Students", theStudents);

		return "list-students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Students theStudent = new Students();

		theModel.addAttribute("Students", theStudent);

		return "student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("StudentId") int theId, Model theModel) {

		// get the Student from the service
		Students theStudent = studentService.findById(theId);

		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("Students", theStudent);

		// send over to our form
		return "student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("StudentsId") int StudentsId, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("Departmenet") String departmenet,
			@RequestParam("country") String country) 
		{

		System.out.println(StudentsId);
		Students theStudent;
		if (StudentsId != 0) {
			theStudent = studentService.findById(StudentsId);
			theStudent.setFirstName(firstName);
			theStudent.setLastName(lastName);
			theStudent.setDepartmenet(departmenet);
			theStudent.setCountry(country);
		} else
			theStudent = new Students(firstName, lastName, departmenet, country);
		// save the Student
		studentService.save(theStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/Students/list";
		}

	

	@RequestMapping("/delete")
		public String delete(@RequestParam("StudentId") int theId) {

			// delete the Book
	     studentService.deleteById(theId);

			// redirect to /students/list
			return "redirect:/Students/list";

	}


	@RequestMapping("/search")
		public String search(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
					Model theModel) {

			// check names, if both are empty then just give list of all Books

			if (firstName.trim().isEmpty() && lastName.trim().isEmpty()) {
				return "redirect:/Students/list";
			}
			else {
				// else, search by first name and last name
				List<Students> theStudents = studentService.searchBy(firstName, lastName);

				// add to the spring model
				theModel.addAttribute("Students", theStudents);

				// send to list-Books
				return "list-students";
			}

		}
		
}
