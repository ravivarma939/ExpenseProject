package expencetrack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewDetails {
	public static void view() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ravivarma");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from expenses");//input ouput streams //
			System.out.println("----Details----");
			while (rs.next()) {//rs = data;20 lines 
				System.out.println(rs.getDouble(1) + "\t " + rs.getString(2) + "\t" + rs.getDate(3));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();//int double string 
		}

	}

}
