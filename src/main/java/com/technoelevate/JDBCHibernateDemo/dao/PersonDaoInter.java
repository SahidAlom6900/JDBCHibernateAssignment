package com.technoelevate.JDBCHibernateDemo.dao;

import java.util.List;

import com.technoelevate.JDBCHibernateDemo.dto.Person;

public interface PersonDaoInter {
	void add(Person person);

	void update(Person person);

	void delete(Person person);

	List<Person> getAll();

	Person get(int id);
}
