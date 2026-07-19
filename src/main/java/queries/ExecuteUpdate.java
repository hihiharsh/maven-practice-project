// Returns number of rows affected and is used for non-SELECT queries. Throws exception for SELECT queries
package queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteUpdate {
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

			String query = "UPDATE student SET phone = 123456 WHERE name LIKE 'K%'";

			System.out.println("Rows affected: " + stm.executeUpdate(query));
			System.out.println("Query is executed");
			System.out.println("Connection is closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
