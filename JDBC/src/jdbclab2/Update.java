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

	System.out.println("Enter the Id: ");
	int Id1 = scanner.nextInt();
	scanner.nextLine();
	
	System.out.println("Enter the new Id: ");
	int Id2 = scanner.nextInt();
	scanner.nextLine();
	
	System.out.print("Enter the new last name: ");
	String lastName = scanner.nextLine();
	scanner.nextLine();
	
	System.out.print("Enter the new first name: ");
	String firstName = scanner.nextLine();
	scanner.nextLine();

	System.out.print("Enter the new age: ");
	int age = scanner.nextInt();
	scanner.nextLine();

	try {
	    // STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(URL, USER, PASS);
	    System.out.println("Connected database successfully...");

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from Artist where id="+Id1+" ");
//	      while(rs.next()){
//	         //Retrieve by column name
//	         int id  = rs.getInt("id");
//	         int age1 = rs.getInt("age");
//	         String first = rs.getString("first_name");
//	         String last = rs.getString("last_name");
//
//	         //Display values
//	         System.out.print("ID: " + id);
//	         System.out.print(", Age: " + age1);
//	         System.out.print(", First: " + first);
//	         System.out.println(", Last: " + last);
//	      }
	      PreparedStatement ps = conn.prepareStatement("Update Artist where id=(?) (id,first_name, last_name, age) VALUES (?, ?, ?, ?)");
	      ps.setInt(1, Id1);
	      ps.setInt(2, Id2);
	      ps.setString(3, firstName);
	      ps.setString(4, lastName);
	      ps.setInt(5, age);
	      
	       
	      ps.executeUpdate();
	      rs.close();
	} catch (SQLException se) {
	    // Handle errors for JDBC
	    se.printStackTrace();
	}
	// end try
	System.out.println("You will now be returned to the main menu!");
    }
}
