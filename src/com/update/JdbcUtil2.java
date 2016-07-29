package com.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtil2 {
	static Connection conn = null;

	// ��ȡ���ݿ�����
	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // �������ݿ�����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/ran"; // �������ݿ�URL
		String userName = "root"; // �������ݿ���û���
		String passWord = "1203"; // �������ݿ�����
		try {
			conn = DriverManager.getConnection(url, userName, passWord); // ��ȡ���ݿ�����
			if (conn != null) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; // ����Connection����
	}

	public void insertEmp(Emp2 emp) {
		conn = getConn(); // ��ȡ���ݿ�����
		try {
			PreparedStatement statement = conn
					.prepareStatement("insert into info values(?,?,?,?,?,?)"); // ����������ݿ��Ԥ�������
			// Ϊsql����еĲ�����ֵ;
			statement.setInt(1, emp.getName()); // ����Ԥ�������Ĳ���ֵ
			statement.setString(2, emp.getSex());
			statement.setInt(3, emp.getAge());
			statement.setInt(4, emp.getDept());
			statement.setInt(5, emp.getPhone());
			statement.setString(6, emp.getRemark());
			statement.executeUpdate(); // ִ��Ԥ�������
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}