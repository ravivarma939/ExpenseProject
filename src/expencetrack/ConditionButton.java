package expencetrack;

import java.sql.*;
import java.util.Scanner;

public class ConditionButton {
public static  void checkCondition() {
	Expense expense = new Expense();
	Scanner sc = new Scanner(System.in);
	try(sc;) {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ravivarma");
		PreparedStatement ps = con.prepareStatement("select * from expenses where AMOUNT_SPENT> =?");
		System.out.println("enter the Amount to get Details");
		expense.setCheckamount(sc.nextDouble());
		ps.setDouble(1, expense.getCheckamount());
		ResultSet rs = ps.executeQuery();
		//System.out.println(rs);
		while(rs.next()) {
			System.out.println(rs.getDouble(1)+"   '"+rs.getString(2)+"'   "+rs.getDate(3));
		}
		} catch (Exception e) {
		e.printStackTrace();
	}
}
}
