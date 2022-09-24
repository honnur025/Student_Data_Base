package StudentDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
	public static void main(String[] args) {
		System.out.println("<-------WELLCOME STUDENT DATABASE------->");
		Scanner sc= new Scanner(System.in);
		StudentInterface s=new StudentImps();
		while(true) {
			System.out.println("|---1:Add Student----|\n|---2:Get Student----|\n|--3:Update Student--|\n|--4:Delete Student--|\n|-5:Get All Students-|\n|6:Dalete All Student|\n|-------7:Exit-------|");
			System.out.println("\n     Enter Choice ");
			System.out.println("     ------------ ");
			int c=sc.nextInt();
			switch(c) {
			case 1:
				s.addStudent();
				break;
			case 2:
				s.getStudent();
				break;
			case 3:
				s.updateStudent();
				break;
			case 4:
				s.deleteStudent();
				break;
			case 5:
				s.getAllStudents();
				break;
			case 6:
				s.deleteAllStudents();
				break;
			case 7:
				System.out.println("Thank You..!");
				System.exit(0);
			default :
				System.out.println("Invalid Choice");
			}
		}
	}
}
