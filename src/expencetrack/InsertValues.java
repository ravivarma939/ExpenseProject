package expencetrack;

import java.util.Scanner;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsertValues {
	static Expense expense = new Expense();

	public static void insert() {
		Scanner sc = new Scanner(System.in);
		try (sc;) 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ravivarma");
			PreparedStatement ps1 = con.prepareStatement("insert into expenses values(?,?,?)");//insert into expenses values (250,'food'.'02-10-2024');
			PreparedStatement ps2 = con.prepareStatement("select * from expenses");
			System.out.println("Enter the Amount Spent");
			expense.setAmount(sc.nextDouble());
			sc.nextLine();
			System.out.println("Enter the Purpose of Spent");
			expense.setSpentfor(sc.nextLine());//food
			System.out.println("Enter the Date Of Spent Format(MM-dd-yyyy):");//to_date(02-10-2024,'dd-mm-yyyy');//10-02-2024
			String dateInput = sc.nextLine(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");//2024-02-10;
		    java.util.Date utilDate = null;//util.date ,,sql.date
		    try 
		    {
		    	  utilDate = dateFormat.parse(dateInput);//string to date 
		            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());//sql date;
		            expense.setDate(sqlDate);
		            ps1.setDouble(1, expense.getAmount());
					ps1.setString(2, expense.getSpentfor());
					ps1.setDate(3, (Date) expense.getDate());
					int k = ps1.executeUpdate();//commit 
					if(k>0) {
						System.out.println("Updated values");
					}
		    } 
		    catch (ParseException e)
		   {
              System.out.println("Invalid date format. Please enter a date in MM-dd-yyyy format.");
            }
		}
	catch (Exception e) 
	{
              e.printStackTrace();
		}
	}
}



