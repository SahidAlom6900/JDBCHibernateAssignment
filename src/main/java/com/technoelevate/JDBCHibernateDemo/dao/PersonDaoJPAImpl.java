package com.technoelevate.JDBCHibernateDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.technoelevate.JDBCHibernateDemo.conn.GetPropOrConn;
import com.technoelevate.JDBCHibernateDemo.dto.Person;

public class PersonDaoJPAImpl implements PersonDaoInter {
	private EntityManager manager = GetPropOrConn.getEntityManager();
	private String findAll = "from Person";

	public void add(Person person) {
		manager.getTransaction().begin();
		manager.persist(person);
		manager.getTransaction().commit();
	}

	@Override
	public List<Person> getAll() {
		Query query = manager.createQuery(findAll);
		List<Person> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public Person get(int id) {
		Person find = manager.find(Person.class, id);
		return find;
	}

	@Override
	public void update(Person person) {
		manager.getTransaction().begin();
		manager.persist(person);
		manager.getTransaction().commit();

	}

	@Override
	public void delete(Person person) {
		manager.getTransaction().begin();
		manager.remove(person);
		manager.getTransaction().commit();

	}

}
