package jdbclab2;


import java.sql.*;

public class ShowAll{

    static final String URL = "jdbc:mysql://localhost:3306/lab2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    static final String USER = "root";
    static final String PASS = "Carolina92";

    public static final String sAll = null;



    public static void sAll() {
	Connection conn = null;
	Statement stmt = null;

	try {

	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(URL, USER, PASS);
	    System.out.println("Connected database successfully...");


	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    String sql = "SELECT id, first_name, last_name, age FROM Artist";
	    ResultSet rs = stmt.executeQuery(sql);

	    while (rs.next()) {

		int id = rs.getInt("id");
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
