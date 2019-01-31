package jdbclab2;

//STEP 1. Import required packages
import java.sql.*;
import java.util.Scanner;

public class Update{
    // JDBC driver name and database URL
    static final String URL = "jdbc:mysql://localhost:3306/lab2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Carolina92";

    public static final String sAll = null;



    public static void update() {
	Connection conn = null;
	Statement stmt = null;
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	    

        
	int Id;
        System.out.println("Enter id to update: ");
        Id = scanner.nextInt();
        
        String firstName;
        System.out.println("Enter first name: ");
        firstName = scanner.next();

        String lastName;
        System.out.println("Enter last name: ");
        lastName = scanner.next();

        int age;
        System.out.println("Enter age: ");
        age = scanner.nextInt();

	try {
	    // STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(URL, USER, PASS);
	    System.out.println("Connected database successfully...");
	      stmt = conn.createStatement();
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      String sql = "UPDATE artist SET first_name = '" + firstName + "',last_name = '" + lastName + "',age = '" + age + "' WHERE id = " + Id;
	      stmt.executeUpdate(sql);	

	        System.out.println("The Record has successfully been updated");

	        
	} catch (SQLException se) {
	    // Handle errors for JDBC
	    se.printStackTrace();
	}
	// end try
	System.out.println("You will now be returned to the main menu!");
    }
}
