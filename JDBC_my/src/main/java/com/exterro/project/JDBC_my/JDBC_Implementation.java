package com.exterro.project.JDBC_my;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_Implementation {
	Properties prop = null;
	 InputStream inn = null;

	 JDBC_Implementation() {
	try {
		 this.inn = new FileInputStream("C:\\Users\\sathishs\\eclipse-workspace\\JDBC_my\\src\\main\\resource\\constance.properties");
			
			this.prop = new Properties();
			
		
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
			
}

	public void insert_Data(Emp_POJO pojo) {
		try {
			prop.load(inn);
			System.out.println("hits");
			Class.forName(prop.getProperty("forname"));
			Connection connect = DriverManager.getConnection(prop.getProperty("dbname"),prop.getProperty("uname"),prop.getProperty("password"));
			String str = "insert into Emp_Details values('" + pojo.getFname() + "','" + pojo.getLname() + "',"
					+ pojo.getAge() + ")";
			Statement sta = connect.createStatement();
			sta.executeUpdate(str);
			System.out.println("Done!!!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void showData() {
		try {
			prop.load(inn);
			Class.forName(prop.getProperty("forname"));

			Connection connect = DriverManager.getConnection(
					prop.getProperty("dbname"),
					prop.getProperty("uname"),
					prop.getProperty("password"));

			String str = "SELECT * FROM Emp_Details";

			Statement sta = connect.createStatement();
			ResultSet rst = sta.executeQuery(str);

			while (rst.next()) {

				String fname = rst.getString("F_name");

				String lname = rst.getString("L_name");
				int ag = rst.getInt("Age");
				System.out.println(fname + " " + lname + " :" + ag);

				System.out.println("Done!!!!");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	public void deleteRow(String str) {
		try {
			prop.load(inn);
			// String str2 = ""'+str+'";
			System.out.println("del1");
			Class.forName(prop.getProperty("forname"));
			System.out.println("del2");
			Connection con = DriverManager.getConnection(
					prop.getProperty("dbname"),
					prop.getProperty("uname"),
					prop.getProperty("password"));
			System.out.println("del3");
			String delete = "DELETE FROM Emp_Details WHERE F_name = \'" + str + "\';";
			Statement sta = con.createStatement();
			System.out.println("del4" + delete);
			sta.executeUpdate(delete);
			System.out.println("delete Done");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void update_Table(String str, int choice, String str2) {
		try {
			prop.load(inn);
			String delete;
			System.out.println("up1");
			Class.forName(prop.getProperty("forname"));
			System.out.println("up2");
			Connection con = DriverManager.getConnection(
					prop.getProperty("dbname"),
					prop.getProperty("uname"),
					prop.getProperty("password"));
			System.out.println("up3");
			if (choice == 1) {
				delete = "UPDATE  Emp_Details SET F_name =\'" + str2 + "\' WHERE F_name =\'" + str + "\'; ";
				Statement sta = con.createStatement();

				System.out.println("up4" + delete);
				sta.executeQuery(delete);
				System.out.println("Update Done");
			} else if (choice == 2) {
				delete = "UPDATE  Emp_Details SET L_name=\'" + str2 + "\' WHERE L_name='" + str + "\'; ";
				Statement sta = con.createStatement();

				System.out.println("up4" + delete);
				sta.executeUpdate(delete);
				System.out.println("Update Done");
			} else if (choice == 3) {
				int a = Integer.parseInt(str);
				int b = Integer.parseInt(str2);

				delete = "UPDATE  Emp_Details SET Age =  " + b + "  WHERE Age=" + a + ";";
				Statement sta = con.createStatement();

				System.out.println("up4" + delete);
				sta.executeUpdate(delete);
				System.out.println("Update Done");
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
