package statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementProgram {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/student?user=postgres&password=root";

		try {
			Class.forName(driver);
			System.out.println("Driver is loaded");

			Connection con = DriverManager.getConnection(url);
			System.out.println("Connection is established");

			String query = "INSERT INTO student VALUES (?, ?, ?, ?)";

			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, 106);
			pstm.setString(2, "Bhavesh");
			pstm.setString(3, "bhavesh@gmail.com");
			pstm.setLong(4, 444555);
			System.out.println("Statement is created");

			pstm.execute();
			System.out.println("Query is executed");

			con.close();
			System.out.println("Connection is closed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
