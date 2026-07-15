package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecord {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/student";
		String userName = "postgres";
		String password = "root";

		try {
			Class.forName(driver);
			System.out.println("Driver is loaded");

			Connection con = DriverManager.getConnection(url, userName, password);
			System.out.println("Connection established");

			Statement stm = con.createStatement();
			System.out.println("Statement is created");

			String query = "UPDATE student SET phone = 222333 WHERE sid = 105";

			stm.execute(query);
			System.out.println("Query is executed");

			con.close();
			System.out.println("Connection is closed");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
