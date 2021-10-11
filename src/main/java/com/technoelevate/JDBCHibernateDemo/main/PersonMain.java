package com.technoelevate.JDBCHibernateDemo.main;

import java.util.List;
import java.util.Scanner;

import com.technoelevate.JDBCHibernateDemo.dto.Person;
import com.technoelevate.JDBCHibernateDemo.service.PersonServiceInter;
import com.technoelevate.JDBCHibernateDemo.service.PersonServiceJPAImpl;

/**
 * Hello world!
 *
 */
public class PersonMain {
	private static PersonServiceInter jpaImpl = new PersonServiceJPAImpl();
	private static int pid;
	private static String name;
	private static String address;
	private static boolean quit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter either Hibernate or jdbc");
		String str = sc.next();
		System.out.println("Press 1 Insert the Element\nPress 2 delete by id\nPress 3 Display By "
				+ "Id\nPress 4 Update the Data By Id\nPress 5 Get All\nPress 6 Quit the Program");

		if (str.equalsIgnoreCase("hibernate")) {
			while (!quit) {
				String ch = sc.next();
				switch (ch) {
				case "1":
					System.out.println("Enter the name and address");
					name = sc.next();
					address = sc.next();
					jpaImpl.add(new Person(name, address));
					System.err.println("Do you want to y/n");
					break;
				case "2":
					System.out.println("Enter the id");
					pid = sc.nextInt();
					jpaImpl.delete(pid);
					System.err.println("Do you want to y/n");
					break;
				case "3":
					System.out.println("Enter the id");
					pid = sc.nextInt();
					System.out.println(jpaImpl.get(pid));
					System.err.println("Do you want to y/n");
					break;
				case "4":
					System.out.println("Enter the id");
					pid = sc.nextInt();
					jpaImpl.update(pid);
					System.err.println("Do you want to y/n");
					break;
				case "5":
					List<Person> all = jpaImpl.getAll();
					all.forEach(i->System.out.println(i));
					System.err.println("Do you want to y/n");
					break;
				case "y":
					System.out.println("Press 1 Insert the Element\nPress 2 delete by id\nPress 3 Display By "
							+ "Id\nPress 4 Update the Data By Id\nPress 5 Get All\nPress 6 Quit the Program");

					break;
				case "n":
					System.err.println("Shutdown...");
					quit = true;
					break;
				case "6":
					System.err.println("Shutdown...");
					quit = true;
					break;

				default:
					System.out.println("Enter the Correct option");
					break;
				}
			}
		} else if(str.equalsIgnoreCase("jdbc")){
			System.out.println("Hi From JDBC");
			while (!quit) {
				String ch = sc.next();
				switch (ch) {
				case "1":
					System.out.println("Enter the name and address");
					name = sc.next();
					address = sc.next();
					jpaImpl.add(new Person(name, address));
					System.err.println("Do you want to y/n");
					break;
				case "2":
					System.out.println("Enter the id");
					pid = sc.nextInt();
					jpaImpl.delete(pid);
					System.err.println("Do you want to y/n");
					break;
				case "3":
					System.out.println("Enter the id");
					pid = sc.nextInt();
					System.out.println(jpaImpl.get(pid));
					System.err.println("Do you want to y/n");
					break;
				case "4":
					System.out.println("Enter the id");
					pid = sc.nextInt();
					jpaImpl.update(pid);
					System.err.println("Do you want to y/n");
					break;
				case "5":
					List<Person> all = jpaImpl.getAll();
					all.forEach(i->System.out.println(i));
					System.err.println("Do you want to y/n");
					break;
				case "y":
					System.out.println("Press 1 Insert the Element\nPress 2 delete by id\nPress 3 Display By "
							+ "Id\nPress 4 Update the Data By Id\nPress 5 Get All\nPress 6 Quit the Program");

					break;
				case "n":
					System.err.println("Shutdown...");
					quit = true;
					break;
				case "6":
					System.err.println("Shutdown...");
					quit = true;
					break;

				default:
					System.out.println("Enter the Correct option");
					break;
				}
			}
		}
	}
}
