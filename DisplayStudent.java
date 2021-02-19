package project.j2ee.StudentManagementSystem;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayStudent 
{
	public void disp() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		String dbURL="jdbc:mysql://localhost:3306/student_info";
		String user="root";
		String password="root";
		Connection con1=DriverManager.getConnection(dbURL,user,password);
		
		String q="SELECT * FROM student";
		Statement stmt =con1.createStatement();
		
		ResultSet r=stmt.executeQuery(q);
		
		System.out.println("");
		while(r.next())
		{
			System.out.print(r.getInt(1)+"\t");
			System.out.print(r.getString(2)+"\t");
			System.out.print(r.getString(3)+"\t");
			System.out.print(r.getLong(4)+"\t");
			System.out.print(r.getString(5)+"\t");
			System.out.print(r.getString(6)+"\t");
			System.out.print(r.getDouble(7)+"\t");
			System.out.println();
		}
	}
}
