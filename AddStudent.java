package project.j2ee.StudentManagementSystem;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddStudent 
{
	public void addStudent() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		String dbURL="jdbc:mysql://localhost:3306/student_info";
		String user="root";
		String password="root";
		Connection con1=DriverManager.getConnection(dbURL,user,password);
		
		System.out.println("Enter the Number of Student to Insert");
		int num=sc.nextInt();
		int count=0;
		for(int i=0;i<num;i++)
		{
			count++;
		System.out.println("Enter ID\n");
		int id=sc.nextInt();
		System.out.println("Enter Student First Name\n");
		String fname=sc.next();
		
		System.out.println("Enter Student Last Name\n");
		String lname=sc.next();
	
		System.out.println("Enter Student Date of Brith\n");
		String dob=sc.next();
		
		System.out.println("Enter Student Address");
		String address=sc.next();
		
		System.out.println("Enter Student Marks");
		double marks=sc.nextDouble();
		
		System.out.println("Enter Student phone number\n");
		long phno=sc.nextLong();
		
		String q="INSERT INTO student VALUES(?,?,?,?,?,?,?) ";
		PreparedStatement stmt1= con1.prepareStatement(q);
		stmt1.setInt(1,id);
		stmt1.setString(2,fname);
		stmt1.setString(3,lname);
		
		String p=phno+"";
		try
		{
			if(p.length()==10)
			{
				stmt1.setLong(4,phno);
			}
			
			stmt1.setString(5,dob);
			stmt1.setString(6,address);
			stmt1.setDouble(7,marks);
			int u=stmt1.executeUpdate();
			System.out.println(count+" record successfully inserted");
		}
		catch(SQLException e)
		{
			System.out.println("wrong phone number!!!");
			System.out.println("Enter right phone number");
			phno=sc.nextLong();
			stmt1.setLong(4,phno);
			stmt1.setString(5,dob);
			stmt1.setString(6,address);
			stmt1.setDouble(7,marks);
			int u=stmt1.executeUpdate();
			System.out.println(count+" record successfully inserted");
		}
		
		
	
		}
	}
}
