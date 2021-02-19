package project.j2ee.StudentManagementSystem;

import java.util.Scanner;

public class Student_MainClass 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		for(;;)
		{
			System.out.println("1.Add Student");
			System.out.println("2.Update ");
			System.out.println("3.Delete ");
			System.out.println("4.Search");
			System.out.println("5.display");
			System.out.println("6. Exit");
			System.out.println("Enter your choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1: new AddStudent().addStudent();
			break;
			case 2: new Student_MainClass().update();
			break;
			case 3: new Student_MainClass().delete();
			break;
			case 4: new Student_MainClass().search();
			break;
			case 5: new DisplayStudent().disp();
			break;
			case 6: System.exit(0);
			default: System.out.println("Invalid choice !!!");
			}
		}
	}
	
	
	public  void update() throws Exception
	{
		
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("1.update by id");
			System.out.println("2.update by phno");
			System.out.println("3.Update by name");
			System.out.println("4.Back to main menu");
			System.out.println("5.Exit");
			System.out.println("Enter your choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:new UpdateStudent().updateById();
				break;
			case 2:new UpdateStudentByphno().updateByPhno();
				break;
			case 3:new UpdateStudentByName().updateStudentByName();
				break;
			case 4:main(null);
			    break;
			case 5:System.exit(0);
			default: System.out.println("invalid choice");
			}
		}
	}
	
	public void delete() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("1.delete by id");
			System.out.println("2.delete by phno");
			System.out.println("3.delete by name");
			System.out.println("4.Back to main menu");
			System.out.println("5.Exit");
			System.out.println("Enter your choice\n");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:new DeleteStudent().deleteById();
				break;
			case 2: new DeleteStudent().deleteByPhno();
				break;
			case 3:new DeleteStudent().deleteByName();
				break;
			case 4:main(null);
			    break;
			    
			case 5:System.exit(0);
			default: System.out.println("invalid choice");
			}
		}
	}
	
	public void search() throws Exception
	{

		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("1.search by id");
			System.out.println("2.search by phno");
			System.out.println("3.search by name");
			System.out.println("4.Back to main menu");
			System.out.println("5.Exit");
			System.out.println("Enter your choice\n");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:new SearchStudent().SearchById();
				break;
			case 2: new SearchStudent().SearchByPhno();
				break;
			case 3:new SearchStudent().SearchByName();
				break;
			case 4:main(null);
			    break;
			case 5:System.exit(0);
			default: System.out.println("invalid choice");
			}
		}
	}
}
