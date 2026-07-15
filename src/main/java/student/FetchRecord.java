package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchRecord {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/student";
		String userName = "postgres";
		String password = "root";

		try {
			// Loading the driver
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver is loaded");

			// Establishing the connection
			Connection con = DriverManager.getConnection(url, userName, password);
			System.out.println("Connection established");

			// Creating the statement
			Statement stm = con.createStatement();
			System.out.println("Statement is created");

			String query = "SELECT * FROM student";

			// Executing the query
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				int sid = rs.getInt("sid");
				String name = rs.getString("name");
				String email = rs.getString("email");
				long phone = rs.getLong("phone");
				System.out.println("ID: " + sid + ", Name: " + name + ", Email: " + email + ", Phone: " + phone);
			}
			System.out.println("Query is executed");

			// Close the connection
			con.close();
			System.out.println("Connection is closed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
