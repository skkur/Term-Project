package com.term.m;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class JdbcUtil {
	static Connection conn = null;

	// ��ȡ���ݿ�����
	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // �������ݿ�����
			String url = "jdbc:mysql://localhost:3306/ran"; // �������ݿ�URL
			String userName = "root"; // �������ݿ���û���
			String passWord = "1203"; // �������ݿ�����
			conn = DriverManager.getConnection(url, userName, passWord); // ��ȡ���ݿ�����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; // ����Connection����
	}

	public void insertEmp(Emp emp2) {
		conn = getConn(); // ��ȡ���ݿ�����
		String c = emp2.getCha();
		int c1 = emp2.getCha2();
		System.out.println(c);
		try {
			Statement a = conn.createStatement();
			ResultSet b = a.executeQuery("select * from users");
			int s = 0;
			while (b.next()) {
				if (b.getString(2).equals(c)) {
					a.executeUpdate("update users set passwd=" + c1);
					JOptionPane.showMessageDialog(null, "�����޸ĳɹ�");
					s++;
					break;
				}
			}
			if (s == 0) {
				JOptionPane.showMessageDialog(null, "�û�������");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
