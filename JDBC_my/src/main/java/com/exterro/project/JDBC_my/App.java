package com.exterro.project.JDBC_my;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)

	{
		System.out.println("Enter Employee Details");
		homePage();

	}

	private static void homePage() {
		Scanner scn = new Scanner(System.in);
		int a;
		System.out.println("To add a data in database enter 1 ");
		System.out.println("To view the db enter 2 ");
		System.out.println("To Delete data in database enter 3");
		System.out.println("To Update value in database enter 4");
		a = scn.nextInt();

		switch (a) {
		case 1:
			createrow();
			break;
		case 2:
			showrow();
			break;
		case 3:
			deleterow();
			break;
		case 4:
			updateFromtable();
			break;

		default:
			break;
		}

	}

	private static void updateFromtable() {
		int choice = 0;
		String firstname;
		String Lastname;
		String Age ;
		System.out.println("Which field to update");
		System.out.println("Enter 1 To Update First_Name of the emp:");
		System.out.println("Enter 2 To Update Last_Name of the emp:");
		System.out.println("Enter 3 To Update Age of the emp:");
		JDBC_Implementation jdbc = new JDBC_Implementation();
		Scanner scn = new Scanner(System.in);
		choice = scn.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter a First Name");
			firstname = scn.next();
			System.out.println("ENTER A NAME TO UPDATE IN FIRST NAME");
			String updated_name = scn.next();
			jdbc.update_Table(firstname,1,updated_name);
			break;
		case 2:
			System.out.println("Enter a Last Name");
			Lastname = scn.next();
			System.out.println("ENTER A NAME TO UPDATE IN LAST NAME");
			String upda_name = scn.next();
			jdbc.update_Table(Lastname,2,upda_name);
			
			break;
		case 3:
			System.out.println("Enter a Age");
			Age = scn.next();
			System.out.println("ENTER A age TO UPDATE IN Age ");
			String upd_age = scn.next();
			jdbc.update_Table(Age,3,upd_age);
			break;

		default:
			System.out.println("invalid number");
			break;
		}
		homePage();

	}

	private static void showrow() {
		JDBC_Implementation jdbc = new JDBC_Implementation();
		jdbc.showData();
		homePage();
	}

	private static void deleterow() {
		JDBC_Implementation jdbc = new JDBC_Implementation();
		Scanner scn = new Scanner(System.in);
		System.out.println("ok then enter a proprer First name");
		String sc = scn.next();
		jdbc.deleteRow(sc);
		homePage();
	}

	private static void createrow() {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter first name   ");
		String F_name = scn.next();
		System.out.println("enter Second name   ");
		String L_name = scn.next();
		System.out.println("enter Age   ");
		int age = scn.nextInt();
		Emp_POJO empInfo = new Emp_POJO(F_name, L_name, age);
		JDBC_Implementation jdbc = new JDBC_Implementation();
		jdbc.insert_Data(empInfo);
		homePage();
	}
}
