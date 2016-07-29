package com.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.query.Emp;

public class JdbcIn {
	static Connection conn = null;

	// ��ȡ���ݿ�����
	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // �������ݿ�����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://127.0.0.1/ran"; // �������ݿ�URL
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

	public void insertEmp(Emp emp) {
		conn = getConn(); // ��ȡ���ݿ�����
		try {
			PreparedStatement statement = conn
					.prepareStatement("insert into info values(?,?,?,?,?,?)"); // ����������ݿ��Ԥ�������
			statement.setInt(1, emp.getId()); // ����Ԥ�������Ĳ���ֵ
			statement.setString(2, emp.getliveName());
			statement.setInt(3, emp.getarea());
			statement.setInt(4, emp.getMoney());
			statement.setInt(5, emp.getcost());
			statement.setString(6, emp.getareaT());
			statement.executeUpdate(); // ִ��Ԥ�������
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
