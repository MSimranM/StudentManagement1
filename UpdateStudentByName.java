package project.j2ee.StudentManagementSystem;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateStudentByName 
{
	
	public Scanner sc=new Scanner(System.in);
	public void updateStudentByName() throws Exception
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
				System.out.println("1.update by id \n 2.update by phno\n 3.Back");
				int ch=sc.nextInt();
				switch(ch)
				{
					case 1:new UpdateStudent().updateById();
						break;
					case 2:new UpdateStudentByphno().updateByPhno();
						break;
					case 3:new Student_MainClass().main(null);
						break;
					default :System.out.println("invalid choice");
				}	
			}
			}
		else if(count<=1)
		{
			updateName(fname);
		}
	}
	
	public void updateName(String fname) throws Exception
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
					 case 1:updateStudent(fname);
					 	break;
					 case 2:updateStudentLname(fname);
						 break;
					 case 3:updateStudPhno(fname);
						 break;
					 case 4:updateStudDob(fname);
						 break;
					 case 5:updateStudMarks(fname);
						 break;
					 case 6:updateStudAddress(fname);
						 break;
					 case 7:new Student_MainClass().main(null);
					 	break;
					 case 8:System.exit(0);
						 break;
						 
				}			
			}
		}
		
		public void updateStudent(String fname) throws Exception
		{
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			String dbURL="jdbc:mysql://localhost:3306/student_info";
			String user="root";
			String password="root";
			Connection con1=DriverManager.getConnection(dbURL,user,password);
			System.out.println("Enter the name to update");
			String fname2=sc.next();
			
			String q1="UPDATE student SET FNAME = ? WHERE FName = ? ";
			PreparedStatement stmt1= con1.prepareStatement(q1);
			stmt1.setString(1, fname2);
			stmt1.setString(2, fname);
			int u=stmt1.executeUpdate();
			System.out.println("Update succesfull");
		}
		
		public void updateStudentLname(String fname) throws Exception
		{
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			String dbURL="jdbc:mysql://localhost:3306/student_info";
			String user="root";
			String password="root";
			Connection con1=DriverManager.getConnection(dbURL,user,password);
			
			System.out.println("Enter the last name");
			String lname=sc.next();
			
			String q="UPDATE student SET LNAME = ? WHERE FName = ? ";
			PreparedStatement stmt=con1.prepareStatement(q);
			stmt.setString(1,lname);
			stmt.setString(2, fname);
			int u=stmt.executeUpdate();
			System.out.println("Update succesfull");
		}
		
		public void updateStudPhno(String fname) throws Exception
		{
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			String dbURL="jdbc:mysql://localhost:3306/student_info";
			String user="root";
			String password="root";
			Connection con1=DriverManager.getConnection(dbURL,user,password);
			
			System.out.println("Enter the phone number");
			long phno=sc.nextLong();
			
			String q="UPDATE student SET PHNO = ? WHERE FName = ? ";
			PreparedStatement stmt=con1.prepareStatement(q);
			stmt.setLong(1,phno);
			stmt.setString(2, fname);
			int u=stmt.executeUpdate();
			System.out.println("Update succesfull");
		}
		
		public void updateStudDob(String fname) throws Exception
		{
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			String dbUrl="jdbc:mysql://localhost:3306/student_info";
			String user="root";
			String password="root";
			Connection con1=DriverManager.getConnection(dbUrl, user, password);
			
			System.out.println("Enter the date of birth");
			String dob=sc.next();
			
			String q="UPDATE student SET DOB = ? WHERE FName = ? ";
			PreparedStatement stmt=con1.prepareStatement(q);
			stmt.setString(1,dob);
			stmt.setString(2, fname);
			int u=stmt.executeUpdate();
			System.out.println("Update succesfull");
		}
		
		public void updateStudMarks(String fname) throws Exception
		{
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			String url="jdbc:mysql://localhost:3306/student_info";
			String user="root";
			String password="root";
			Connection con1=DriverManager.getConnection(url,user,password);
			
			System.out.println("Enter the marks");
			double marks=sc.nextDouble();
			
			String q="UPDATE student SET Marks = ? WHERE FName = ? ";
			PreparedStatement stmt=con1.prepareStatement(q);
			stmt.setDouble(1,marks);
			stmt.setString(2, fname);
			int u=stmt.executeUpdate();
			System.out.println("Update succesfull");
		}
		
		public void updateStudAddress(String fname) throws Exception
		{
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			String url="jdbc:mysql://localhost:3306/student_info";
			String user="root";
			String password="root";
			Connection con1=DriverManager.getConnection(url,user,password);
			System.out.println("Enter the address");
			String  address=sc.next();
			
			String q="UPDATE student SET ADDRESS = ? WHERE FName = ? ";
			PreparedStatement stmt=con1.prepareStatement(q);
			stmt.setString(1,address);
			stmt.setString(2, fname);
			int u=stmt.executeUpdate();
			System.out.println("Update succesfull");
		}
	}

