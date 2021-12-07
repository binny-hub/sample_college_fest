package com.college.fest.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.college.fest.entity.Students;

@Service

public interface StudentService {
	public List<Students> findAll();

	public Students findById(int StudentsId);

	public void save(Students theStudent);

	public void deleteById(int theStudent);

	public List<Students> searchBy(String firstName, String LastName);

	

}
