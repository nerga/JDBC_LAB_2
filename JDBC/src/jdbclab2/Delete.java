package jdbclab2;

//STEP 1. Import required packages
import java.sql.*;

public class Delete{
    // JDBC driver name and database URL
    static final String URL = "jdbc:mysql://localhost:3306/lab2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "Carolina92";

    public static final String sAll = null;



    public static void delete() {
	Connection conn = null;
	Statement stmt = null;

	try {
	    // STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(URL, USER, PASS);
	    System.out.println("Connected database successfully...");

	    // STEP 4: Execute a query
	     System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql = "DELETE FROM Artist " +
	                   "WHERE id = 100";
	      stmt.executeUpdate(sql);

	      // Now you can extract all the records
	      // to see the remaining records
	      sql = "SELECT id, first_name, last_name, age FROM Artist";
	      ResultSet rs = stmt.executeQuery(sql);

	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("id");
	         int age = rs.getInt("age");
	         String first = rs.getString("first_name");
	         String last = rs.getString("last_name");

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.print(", Age: " + age);
	         System.out.print(", First: " + first);
	         System.out.println(", Last: " + last);
	      }
	      rs.close();
	} catch (SQLException se) {
	    // Handle errors for JDBC
	    se.printStackTrace();
	}
	// end try
	System.out.println("You will now be returned to the main menu!");
    }
}
