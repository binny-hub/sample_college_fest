package com.college.fest.service;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.college.fest.entity.Students;

@Repository

public class StudentsServiceImpl implements StudentService {
	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	
	StudentsServiceImpl(SessionFactory sessionFactory)
	{  
		this.sessionFactory=sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} 
		
		catch (HibernateException e) {
			session = sessionFactory.openSession();
		}


	}
	
	
	//@Transactional
	
	@Override
	public List<Students> findAll(){
		Transaction transaction = session.beginTransaction();
		List<Students> students = session.createQuery("from Students").list();
		
		transaction.commit();
		return students;
	}
	
	@Override
	public void save(Students students) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(students);
		transaction.commit();
		
		
	}
	
	@Override
	public void deleteById(int StudentsId) {
		Transaction transaction = session.beginTransaction();
		Students student = session.get(Students.class, StudentsId);
		session.delete(student);
		transaction.commit();
		
	}
	
	@Override
	public Students findById(int StudentsId) {
		Transaction transaction = session.beginTransaction();
		Students student = session.get(Students.class, StudentsId);
		
		transaction.commit();
		return student;
		
	}


	@Override
	public List<Students> searchBy(String firstName, String LastName) {
		// TODO Auto-generated method stub
		return null;
	}

  
	
}
