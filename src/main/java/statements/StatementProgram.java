// Recommended for DDL commands or static queries which does not take any data

package statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementProgram {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/student?user=postgres&password=root";

		try {
			Class.forName(driver);
			System.out.println("Driver is loaded");

			Connection con = DriverManager.getConnection(url);
			System.out.println("Connection is established");

			Statement stm = con.createStatement();
			System.out.println("Statement is created");

			String query = "SELECT * FROM student";

			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				System.out.println("ID: " + rs.getInt(1));
				System.out.println("Name: " + rs.getString(2));
				System.out.println("Email: " + rs.getString(3));
				System.out.println("Phone: " + rs.getLong(4));
				System.out.println();
			}

			System.out.println("Query is exectued");

			con.close();
			System.out.println("Connection is closed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
