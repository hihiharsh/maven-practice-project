package statements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementProgram {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/student?user=postgres&password=root";

		try {
			Class.forName(driver);
			System.out.println("Driver is loaded");

			Connection con = DriverManager.getConnection(url);
			System.out.println("Connection is established");

			String query = "CALL proc_save(?, ?, ?, ?)";

			CallableStatement cstm = con.prepareCall(query);
			cstm.setInt(1, 107);
			cstm.setString(2, "Kaka");
			cstm.setString(3, "kaka@gmail.com");
			cstm.setLong(4, 111222);
			System.out.println("Statement is created");

			cstm.execute();
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
