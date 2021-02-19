package project.j2ee.StudentManagementSystem;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DeleteStudent
{
	public Scanner sc=new Scanner(System.in);
	public void deleteById() throws Exception
	{
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		String dbURL="jdbc:mysql://localhost:3306/student_info";
		String user="root";
		String password="root";
		Connection con1=DriverManager.getConnection(dbURL,user,password);
		
		System.out.println("Enter the id");
		int id=sc.nextInt();
	
		String q1="DELETE FROM student WHERE ID = ? ";
		PreparedStatement stmt1= con1.prepareStatement(q1);
		stmt1.setInt(1,id);
		int u=stmt1.executeUpdate();
		System.out.println("Record deleted successfully");
	}
	
	public void deleteByName() throws Exception
	{
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);

		String dbURL="jdbc:mysql://localhost:3306/student_info";
		String user="root";
		String password="root";
		Connection con1=DriverManager.getConnection(dbURL,user,password);
		System.out.println("Enter the Student First Name");
		String fname=sc.next();
		String q="SELECT * FROM student WHERE FNAME= ? ";
		PreparedStatement stmt =con1.prepareStatement(q);
		stmt.setString(1, fname);
		
		ResultSet r=stmt.executeQuery();
		int count=0;
		while(r.next())
		{
			count++;
		}
		
		if(count>1)
		{
			String q1="SELECT * FROM student WHERE FNAME= ? ";
			PreparedStatement stmt1 =con1.prepareStatement(q);
			stmt1.setString(1, fname);
			
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
			while(true)
			{
				System.out.println("1.delete by id \n 2.delete by phno\n 3.Back");
				int ch=sc.nextInt();
				switch(ch)
				{
					case 1:deleteById();
						break;
					case 2:deleteByPhno();
						break;
					case 3:new Student_MainClass().delete();
						 break;
					default :System.out.println("invalid choice");
				}	
			}
			}
		else if(count<=1)
		{
			deleteName(fname);
		}
		
	}
	
	public void deleteName(String fname) throws Exception
	{
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		String dbURL="jdbc:mysql://localhost:3306/student_info";
		String user="root";
		String password="root";
		Connection con1=DriverManager.getConnection(dbURL,user,password);
		
		String q1="DELETE FROM student WHERE FNAME = ? ";
		PreparedStatement stmt1= con1.prepareStatement(q1);
		stmt1.setString(1,fname);
		int u=stmt1.executeUpdate();
		System.out.println("Record deleted successfully");
	}
	
	public void deleteByPhno() throws Exception
	{
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		String dbURL="jdbc:mysql://localhost:3306/student_info";
		String user="root";
		String password="root";
		Connection con1=DriverManager.getConnection(dbURL,user,password);
		
		System.out.println("Enter the phno");
		long phno=sc.nextLong();
	
		String q1="DELETE FROM student WHERE PHNO = ? ";
		PreparedStatement stmt1= con1.prepareStatement(q1);
		stmt1.setLong(1,phno);
		int u=stmt1.executeUpdate();
		System.out.println("Record deleted successfully");
	}
}
