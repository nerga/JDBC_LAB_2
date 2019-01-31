package jdbclab2;


import java.sql.*;
import java.util.Scanner;

public class SearchFirstName{

    static final String URL = "jdbc:mysql://localhost:3306/lab2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    static final String USER = "root";
    static final String PASS = "Carolina92";

    public static final String sAll = null;



    public static void sName() {
	Connection conn = null;
	@SuppressWarnings("unused")
	Statement stmt = null;
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);

	System.out.println("Enter the first name: ");
	String firstName = scanner.nextLine();


	try {

	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(URL, USER, PASS);
	    System.out.println("Connected database successfully...");


	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();


	      System.out.println("Fetching records with condition...");

	      PreparedStatement ps = conn.prepareStatement("SELECT * from Artist where first_name=(?)");
	      ps.setString(1, firstName);
	      ResultSet rs = ps.executeQuery();


	      while(rs.next()){

	         int id  = rs.getInt("id");
	         int age = rs.getInt("age");
	         String first = rs.getString("first_name");
	         String last = rs.getString("last_name");


	         System.out.print("ID: " + id);
	         System.out.print(", Age: " + age);
	         System.out.print(", First: " + first);
	         System.out.println(", Last: " + last);
	      }

	      ps.close();
	} catch (SQLException se) {

	    se.printStackTrace();
	}

	System.out.println("You will now be returned to the main menu!");
    }
}
