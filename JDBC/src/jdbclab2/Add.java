package jdbclab2;


import java.sql.*;
import java.util.Scanner;

public class Add{
    
    static final String URL = "jdbc:mysql://localhost:3306/lab2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "Carolina92";

    public static final String sAll = null;



    public static void add() {

	System.out.println("Please Enter Category name:");

	Connection conn = null;
	@SuppressWarnings("unused")
	Statement stmt = null;

	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);

	System.out.println("Enter the Id: ");
	int Id = scanner.nextInt();
	scanner.nextLine();
	
	System.out.print("Enter your first name: ");
	String firstName = scanner.nextLine();

	
	System.out.print("Enter your last name: ");
	String lastName = scanner.nextLine();

	
	System.out.print("Enter your age: ");
	int age = scanner.nextInt();
	scanner.nextLine();
	try {

	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(URL, USER, PASS);
	    System.out.println("Connected database successfully...");


	      System.out.println("Inserting records into the table...");
	      stmt = conn.createStatement();
	      
	      PreparedStatement ps = conn.prepareStatement("INSERT INTO Artist (id, first_name, last_name, age) VALUES (?, ?, ?, ?)");
	      ps.setInt(1, Id);
	      ps.setString(2, firstName);
	      ps.setString(3, lastName);
	      ps.setInt(4, age);
	       
	      ps.executeUpdate();



	      System.out.println("Inserted records into the table...");
	} catch (SQLException se) {

	    se.printStackTrace();
	}

	System.out.println("You will now be returned to the main menu!");
    }
}
