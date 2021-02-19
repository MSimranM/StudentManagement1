package project.j2ee.StudentManagementSystem;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStudent 
{
	public Scanner sc=new Scanner(System.in);
	public void updateById() throws Exception
	{
		
		
		while(true)
		{
			System.out.println("1.Update Student First Name");
			System.out.println("2.Update Student Last Name");
			System.out.println("3.Update Student PhoneNumber");
			System.out.println("4.Update Student DOB");
			System.out.println("5.Update Student Marks");
			System.out.println("6.Update Student Address");
			System.out.println("7.Back");
			System.out.println("8.exit");
			System.out.println("Enter your choice");
			int ch=sc.nextInt();
			switch(ch)
			{
				 case 1:updateStudent();
				 	break;
				 case 2:updateStudentLname();
					 break;
				 case 3:updateStudPhno();
					 break;
				 case 4:updateStudDob();
					 break;
				 case 5:updateStudMarks();
					 break;
				 case 6:updateStudAddress();
					 break;
				 case 7:new Student_MainClass().main(null);
				 	break;
				 case 8:System.exit(0);
					 break;
					 
			}			
		}
	}
	
	public void updateStudent() throws Exception
	{
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		String dbURL="jdbc:mysql://localhost:3306/student_info";
		String user="root";
		String password="root";
		Connection con1=DriverManager.getConnection(dbURL,user,password);
		
		System.out.println("Enter the id");
		int id=sc.nextInt();
		System.out.println("Enter the first name");
		String fname=sc.next();
		
		String q1="UPDATE student SET FNAME = ? WHERE ID = ? ";
		PreparedStatement stmt1= con1.prepareStatement(q1);
		stmt1.setString(1, fname);
		stmt1.setInt(2,id);
		int u=stmt1.executeUpdate();
		System.out.println("Update succesfull");
	}
	
	public void updateStudentLname() throws Exception
	{
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		String dbURL="jdbc:mysql://localhost:3306/student_info";
		String user="root";
		String password="root";
		Connection con1=DriverManager.getConnection(dbURL,user,password);
		
		System.out.println("Enter the id");
		int id=sc.nextInt();
		System.out.println("Enter the last name");
		String lname=sc.next();
		
		String q="UPDATE student SET LNAME = ? WHERE ID = ? ";
		PreparedStatement stmt=con1.prepareStatement(q);
		stmt.setString(1,lname);
		stmt.setInt(2, id);
		int u=stmt.executeUpdate();
		System.out.println("Update succesfull");
	}
	
	public void updateStudPhno() throws Exception
	{
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		String dbURL="jdbc:mysql://localhost:3306/student_info";
		String user="root";
		String password="root";
		Connection con1=DriverManager.getConnection(dbURL,user,password);
		
		System.out.println("Enter the id");
		int id=sc.nextInt();
		System.out.println("Enter the phone number");
		long phno=sc.nextLong();
		
		String q="UPDATE student SET PHNO = ? WHERE ID = ? ";
		PreparedStatement stmt=con1.prepareStatement(q);
		stmt.setLong(1,phno);
		stmt.setInt(2, id);
		int u=stmt.executeUpdate();
		
	}
	
	public void updateStudDob() throws Exception
	{
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		String dbUrl="jdbc:mysql://localhost:3306/student_info";
		String user="root";
		String password="root";
		Connection con1=DriverManager.getConnection(dbUrl, user, password);
		
		System.out.println("Enter the id");
		int id=sc.nextInt();
		System.out.println("Enter the date of brith");
		String dob=sc.next();
		
		String q="UPDATE student SET DOB = ? WHERE ID = ? ";
		PreparedStatement stmt=con1.prepareStatement(q);
		stmt.setString(1,dob);
		stmt.setInt(2, id);
		int u=stmt.executeUpdate();
		System.out.println("Update succesfull");
	}
	
	public void updateStudMarks() throws Exception
	{
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		String url="jdbc:mysql://localhost:3306/student_info";
		String user="root";
		String password="root";
		Connection con1=DriverManager.getConnection(url,user,password);
		
		System.out.println("Enter the id");
		int id=sc.nextInt();
		System.out.println("Enter the student marks ");
		double marks=sc.nextDouble();
		
		String q="UPDATE student SET Marks = ? WHERE ID = ? ";
		PreparedStatement stmt=con1.prepareStatement(q);
		stmt.setDouble(1,marks);
		stmt.setInt(2, id);
		int u=stmt.executeUpdate();
		System.out.println("Update succesfull");
	}
	
	public void updateStudAddress() throws Exception
	{
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		String url="jdbc:mysql://localhost:3306/student_info";
		String user="root";
		String password="root";
		Connection con1=DriverManager.getConnection(url,user,password);
		
		System.out.println("Enter the id");
		int id=sc.nextInt();
		System.out.println("Enter the address");
		String  address=sc.next();
		
		String q="UPDATE student SET ADDRESS = ? WHERE ID = ? ";
		PreparedStatement stmt=con1.prepareStatement(q);
		stmt.setString(1,address);
		stmt.setInt(2, id);
		int u=stmt.executeUpdate();
		System.out.println("Update succesfull");
	}
}
