package com.technoelevate.JDBCHibernateDemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.technoelevate.JDBCHibernateDemo.conn.GetPropOrConn;
import com.technoelevate.JDBCHibernateDemo.dto.Person;

public class PersonDaoJDBCImpl implements PersonDaoInter {
	private static Properties prop = GetPropOrConn.getProp();
	private static Connection conn;
	private static PreparedStatement pst;
	static {
		try {
			conn = DriverManager.getConnection(prop.getProperty("dburl"));
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	@Override
	public void add(Person person){
		try {
			pst = conn.prepareStatement(prop.getProperty("dynamicQueryInsert"));
			pst.setString(1, person.getName());
			pst.setString(2, person.getAddress());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Person person) {
		try {
			pst = conn.prepareStatement(prop.getProperty("dynamicQueryUpdate"));
			pst.setString(1, person.getName());
			pst.setString(2, person.getAddress());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Person person) {
		try {
			pst=conn.prepareStatement(prop.getProperty("dynamicQueryDelete"));
			pst.setInt(1, person.getPid());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Person> getAll() {
		List<Person> rs=new ArrayList<Person>();
		try {
			pst=conn.prepareStatement(prop.getProperty("dynamicQuerySelectAll"));
			rs = (List<Person>) pst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public Person get(int id) {
		Person person=null;
		try {
			pst=conn.prepareStatement(prop.getProperty("dynamicQuerySelect"));
			pst.setInt(1, id);
			person = (Person) pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}

}
