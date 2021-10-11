package com.technoelevate.JDBCHibernateDemo.service;

import java.util.List;

import com.technoelevate.JDBCHibernateDemo.dto.Person;

public interface PersonServiceInter {
	
	void add(Person person);
	void update(int id);
	void delete(int id);
	List<Person> getAll();
	Person get(int id);

}
