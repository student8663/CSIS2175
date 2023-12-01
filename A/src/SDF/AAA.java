package SDF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AAA {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			Class.forName("net.ucanaccess.jdbc.Ucanaccess");
		} catch (ClassNotFoundException ex) {
			System.out.println("problem in loading the driver");
			ex.printStackTrace();
		}

		try {
			String dbName = "Employee.accdb";
			String dbURL = "jdbc:ucanaccess://" + dbName;
			conn = DriverManager.getConnection(dbURL);
			String n = "emily";
			double sa = 10002;
			stat = conn.createStatement();
			String query = "INSERT INTO EMP (EName,Salary)" + "values ('" + n + "'," + sa + ")";
			// stat.executeUpdate(query);

			query = "UPDATE EMP SET Salary = 12000 where EName" + " = 'ABC'";
			stat.executeUpdate(query);

			query = "DELETE FROM EMP where EName = 'emily'";
			stat.executeUpdate(query);

			rs = stat.executeQuery("SELECT * FROM Emp");
			int id;
			String name;
			double sal;
			while (rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				sal = rs.getDouble(3);
				System.out.println("id  " + id + " name " + name + " salary " + sal);

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					rs.close();
					stat.close();
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	}

}
