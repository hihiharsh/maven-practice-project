// Returns boolean if there is any value fetched from records and used for SELECT and non-SELECT queries
package queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/student?user=postgres&password=root";

		try {
			Class.forName(driver);
			System.out.println("Driver is loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(url)) {
			System.out.println("Connection is established");

			Statement stm = con.createStatement();
			System.out.println("Statement is created");

			String query = "SELECT * FROM student";

			System.out.println("Query returned? " + stm.execute(query));
			System.out.println("Query is executed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
