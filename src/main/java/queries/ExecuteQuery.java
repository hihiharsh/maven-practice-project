// Returns fetched records as ResultSet type and is used for SELECT queries. Throws exception for non-SELECT queries
package queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQuery {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgrsql://localhost:5432/student?user=postgres&password=root";

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
			String anotherQuery = "INSERT INTO student VALUES (110, 'Coco', 'coco@gmail.com', 676767)";
			// non-SELECT query is executed at the database and record is inserted and an
			// exception is thrown after

			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				System.out.println("ID: " + res.getInt(1));
				System.out.println("Name: " + res.getString(2));
				System.out.println("Email: " + res.getString(3));
				System.out.println("Phone: " + res.getLong(4));
				System.out.println();
			}
			System.out.println("Query is executed");
			System.out.println("Connection is closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
