package jdbclab2;


import java.util.Scanner;

public class Driver {
    static boolean loop = true;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

	while (loop) {
	    mainMenu();

	}
    }

    public static void mainMenu() {
	System.out.println("Choose the operation you want to perform ");
	System.out.println("1, Add ");
	System.out.println("2, Delete ");
	System.out.println("3, Update ");
	System.out.println("4, Show all");
	System.out.println("5, Search by id");
	System.out.println("6, Search by age");
	System.out.println("7, Search by first name");
	System.out.println("8, Search by last name");
	System.out.println("9, Search by full name");
	String menu = sc.nextLine();
	
	switch (menu) {
	// Add
	case "1":
	    Add.add();
	    break;

	// Delete
	case "2":
	    Delete.delete();
	    break;

	// Update
	case "3":
	    Update.update();
	    break;

	// Show all
	case "4":
	    ShowAll.sAll();
	    break;

	// Search by Id
	case "5":
	    SearchId.sId();
	    break;

	// Search by age
	case "6":
	    SearchAge.sAge();
	    break;

	// Search by first name
	case "7":
	    SearchFirstName.sName();
	    break;
	    
	// Search by last name    
	case "8": 
	    SearchLastName.sName();
	    break;
	    
	// Search by full name
	case "9":
	    SearchFullName.sName();
	    break;
	}
	
		

    }



}
