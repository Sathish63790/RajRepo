package com.exterro.project.JDBC_my;

public class Emp_POJO {
	
	private String Fname;
	private String Lname;
	private int Age;
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public Emp_POJO(String fname, String lname, int age) {
		super();
		Fname = fname;
		Lname = lname;
		Age = age;
	}
	

	

}
