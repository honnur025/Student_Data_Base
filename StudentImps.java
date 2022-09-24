package StudentDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentImps implements StudentInterface{
	Scanner sc= new Scanner(System.in);
	
	@Override
	public void addStudent() {
		System.out.println("Enter id");
		int id=sc.nextInt();
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter Age");
		int age=sc.nextInt();
		System.out.println("Enter marks");
		Double marks=sc.nextDouble();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			//Statement st=con.createStatement();
			PreparedStatement ps= con.prepareStatement("Insert into studentdb values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setDouble(4, marks);
			ps.execute();
			con.close();
			System.out.println("Student data Saved\n");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent() {
		System.out.println("Enter Id");
		int id=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement ps=con.prepareStatement("delete from studentdb where id=?");
			ps.setInt(1, id);
			ps.execute();
			con.close();
			System.out.println("\nStudent Is Deleted\n");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getStudent() {
		try {
			System.out.println("Enter Id ");
			int id=sc.nextInt();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement ps=con.prepareStatement("select * from studentdb where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("\nStudent Details :");
				System.out.println("Id :"+rs.getInt(1)+",  Name :"+rs.getString(2));
				System.out.println("Age :"+rs.getInt(3)+",  Marks :"+rs.getDouble(4));
			}
			con.close();
			System.out.println();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent() {
		try{
			System.out.println("1.Update Name\n2.Update Age\n3.Update Marks");
			int c=sc.nextInt();
			switch(c) {
			case 1:
				System.out.println("Enter Id");
				int id1=sc.nextInt();
				System.out.println("Enter Name");
				String name=sc.next();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
				PreparedStatement ps= con1.prepareStatement("update studentdb set name=? where id=?");
				ps.setString(1, name);
				ps.setInt(2,id1);
				ps.execute();
				con1.close();
				System.out.println("Name Updated\n");
				break;
			case 2:
				System.out.println("Enter Id");
				int id2=sc.nextInt();
				System.out.println("Enter Age");
				int age=sc.nextInt();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con2= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");				
				PreparedStatement ps1= con2.prepareStatement("update studentdb set age=? where id=?");
				ps1.setInt(1, age);
				ps1.setInt(2,id2);
				ps1.execute();
				con2.close();
				System.out.println("Age Updated\n");
				break;
			case 3:
				System.out.println("Enter Id");
				int id3=sc.nextInt();
				System.out.println("Enter marks");
				Double marks=sc.nextDouble();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
				PreparedStatement ps2= con.prepareStatement("update studentdb set marks=? where id=?");
				ps2.setDouble(1, marks);
				ps2.setInt(2,id3);
				ps2.execute();
				con.close();
				System.out.println("Marks Updated\n");
				break;
			}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getAllStudents() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement ps=con.prepareStatement("select * from studentdb");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				System.out.println("Id :"+rs.getString(1)+", Name :"+rs.getString(2)+", Age :"+rs.getString(3)+", Marks :"+rs.getString(4));
			}
			System.out.println();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteAllStudents() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement ps=con.prepareStatement("delete From studentdb");
			ps.execute();
			con.close();
			System.out.println("\nAll Students Are Deleted\n");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}	
}
