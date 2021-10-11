package com.technoelevate.JDBCHibernateDemo.service;

import java.util.List;
import java.util.Scanner;

import com.technoelevate.JDBCHibernateDemo.dao.PersonDaoInter;
import com.technoelevate.JDBCHibernateDemo.dao.PersonDaoJPAImpl;
import com.technoelevate.JDBCHibernateDemo.dto.Person;

public class PersonServiceJPAImpl implements PersonServiceInter {
	private PersonDaoInter personDaoInter =  new PersonDaoJPAImpl();
	Scanner sc = new Scanner(System.in);

	public void add(Person person) {
		if (person != null) {
			personDaoInter.add(person);
		}

	}

	public void update(int id) {
		Person person = get(id);
		if (id > 0 && person != null) {
			System.out.println("Do you want update name y/n");
			String str = sc.next();
			if (str.equalsIgnoreCase("y")) {
				System.out.println("Enter the Name");
				person.setName(sc.next());
			}
			System.out.println("Do you want update Address y/n");
			String str1 = sc.next();
			if (str1.equalsIgnoreCase("y")) {
				System.out.println("Enter the Address");
				person.setAddress(sc.next());
			}
			personDaoInter.update(person);
		}
	}

	public void delete(int id) {
		Person person = get(id);
		if (id > 0 && person != null) {
			personDaoInter.delete(person);
		}
	}

	@Override
	public List<Person> getAll() {
		return personDaoInter.getAll();
	}

	@Override
	public Person get(int id) {
		if (id > 0) {
			return personDaoInter.get(id);
		}
		return null;
	}

}
