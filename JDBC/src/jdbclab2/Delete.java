package jdbclab2;


import java.sql.*;
import java.util.Scanner;

public class Delete{

    static final String URL = "jdbc:mysql://localhost:3306/lab2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    static final String USER = "root";
    static final String PASS = "Carolina92";

    public static final String sAll = null;



    public static void delete() {
	Connection conn = null;
	Statement stmt = null;
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);

	System.out.println("Enter the id: ");
	int Id = scanner.nextInt();
	scanner.nextLine();

	try {

	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(URL, USER, PASS);
	    System.out.println("Connected database successfully...");


	     System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql = ("DELETE from Artist where id="+Id+" ");
	      stmt.executeUpdate(sql);
	      
	      
	} catch (SQLException se) {

	    se.printStackTrace();
	}

	System.out.println("You will now be returned to the main menu!");
    }
}
