package jdbclab2;


import java.sql.*;
import java.util.Scanner;

public class SearchId{

    static final String URL = "jdbc:mysql://localhost:3306/lab2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    static final String USER = "root";
    static final String PASS = "Carolina92";

    public static final String sAll = null;



    public static void sId() {
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

	      System.out.println("Fetching records with condition...");
	      ResultSet rs = stmt.executeQuery("select * from Artist where id="+Id+" ");

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

	      rs.close();
	} catch (SQLException se) {

	    se.printStackTrace();
	}

	System.out.println("You will now be returned to the main menu!");
    }
}
