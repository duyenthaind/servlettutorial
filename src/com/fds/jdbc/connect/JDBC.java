package com.fds.jdbc.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	@SuppressWarnings("finally")
	public static Connection getJBDCconnection() {
		final String url = "jdbc:mysql://localhost:3306/new_schema1";
		final String user = "root";
		final String password = "minh9102000";
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			// } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return connection;
		}
	}
	
	public void ExeQuery(String sql) throws SQLException {
		Connection cn = getJBDCconnection();
		Statement st = cn.createStatement();
		System.out.println(sql);
		st.executeUpdate(sql);
		
		
	}
	
	public ResultSet traVeKetQua(String sql) throws Exception{
		Connection cn = getJBDCconnection();
		Statement st = cn.createStatement();
		System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		return rs;
		
	}
	
	public static void main(String[] args) throws SQLException {
		Connection cn = getJBDCconnection();
		if (cn != null) {
			System.out.println("Thanh cong");
		} else {
			System.out.println("ko thanh cong");
		}	
		cn.close();
		
	}
}
