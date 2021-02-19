
package project.j2ee.StudentManagementSystem;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchStudent 
{
	public Scanner sc=new Scanner(System.in);
	public void SearchById() throws Exception
	{
	Driver d=new com.mysql.jdbc.Driver();
	DriverManager.registerDriver(d);
	
	String dbURL="jdbc:mysql://localhost:3306/student_info";
	String user="root";
	String password="root";
	Connection con1=DriverManager.getConnection(dbURL,user,password);
	
	System.out.println("Enter the id");
	int id=sc.nextInt();

	String q1="SELECT * FROM student WHERE ID= ? ";
	PreparedStatement stmt1 =con1.prepareStatement(q1);
	stmt1.setInt(1,id);
	
	
	ResultSet res1=stmt1.executeQuery();
	int count=0;
	while(res1.next())
	{
		count++;
	}
	
	if(count>0)
	{
		ResultSet res=stmt1.executeQuery();
		System.out.println("RegId\tFirst Name\tLast Name\tPhone Number\tDateOfBirth\tAddress\tMarks");
		System.out.println("---------------------------------------------------------------------------");
		while(res.next())
		{ 
			
			System.out.print(res.getInt(1)+"\t\t");
			System.out.print(res.getString(2)+"\t\t");
			System.out.print(res.getString(3)+"\t\t");
			System.out.print(res.getLong(4)+"\t\t");
			System.out.print(res.getString(5)+"\t\t");
			System.out.print(res.getString(6)+"\t\t");
			System.out.print(res.getDouble(7)+"\t\t");
			System.out.println();
		}
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Search Successfull");
	}
	else
	{
		System.out.println("Student with ID "+id+" Not found");
	}
}
	
	public void SearchByName() throws Exception
	{
	Driver d=new com.mysql.jdbc.Driver();
	DriverManager.registerDriver(d);
	
	String dbURL="jdbc:mysql://localhost:3306/student_info";
	String user="root";
	String password="root";
	Connection con1=DriverManager.getConnection(dbURL,user,password);
	
	System.out.println("Enter the fname");
	String fname=sc.next();

	String q1="SELECT * FROM student WHERE FNAME= ? ";
	PreparedStatement stmt1 =con1.prepareStatement(q1);
	stmt1.setString(1,fname);
	
	ResultSet res1=stmt1.executeQuery();
	int count=0;
	while(res1.next())
	{
		count++;
	}
	
	if(count>0)
	{
		ResultSet res=stmt1.executeQuery();
		System.out.println("RegId\tFirst Name\tLast Name\tPhone Number\tDateOfBirth\tAddress\tMarks");
		System.out.println("---------------------------------------------------------------------------");
		while(res.next())
		{ 
			
			System.out.print(res.getInt(1)+"\t\t");
			System.out.print(res.getString(2)+"\t\t");
			System.out.print(res.getString(3)+"\t\t");
			System.out.print(res.getLong(4)+"\t\t");
			System.out.print(res.getString(5)+"\t\t");
			System.out.print(res.getString(6)+"\t\t");
			System.out.print(res.getDouble(7)+"\t\t");
			System.out.println();
		}
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("search succesfull");
	}
	else
	{
		System.out.println("Student with First Name"+fname+" Not found");
	}
}
	
	public void SearchByPhno() throws Exception
	{
	Driver d=new com.mysql.jdbc.Driver();
	DriverManager.registerDriver(d);
	
	String dbURL="jdbc:mysql://localhost:3306/student_info";
	String user="root";
	String password="root";
	Connection con1=DriverManager.getConnection(dbURL,user,password);
	
	System.out.println("Enter the phone number");
	long phno=sc.nextLong();

	String q1="SELECT * FROM student WHERE PHNO= ? ";
	PreparedStatement stmt1 =con1.prepareStatement(q1);
	stmt1.setLong(1,phno);
	ResultSet res1=stmt1.executeQuery();
	int count=0;
	while(res1.next())
	{
		count++;
	}
	
	if(count>0)
	{
	
		ResultSet res=stmt1.executeQuery();
		System.out.println("RegId\tFirst Name\tLast Name\tPhone Number\tDateOfBirth\tAddress\tMarks");
		System.out.println("---------------------------------------------------------------------------");
		while(res.next())
		{ 
			
			System.out.print(res.getInt(1)+"\t\t");
			System.out.print(res.getString(2)+"\t\t");
			System.out.print(res.getString(3)+"\t\t");
			System.out.print(res.getLong(4)+"\t\t");
			System.out.print(res.getString(5)+"\t\t");
			System.out.print(res.getString(6)+"\t\t");
			System.out.print(res.getDouble(7)+"\t\t");
			System.out.println();
		}
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("search successfull");
	}
	else
	{
		System.out.println("Student with Phone number "+phno+" Not found");
	}
}
	
}
