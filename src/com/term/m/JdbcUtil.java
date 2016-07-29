package com.term.m;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class JdbcUtil {
	static Connection conn = null;

	// 获取数据库连接
	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载数据库驱动
			String url = "jdbc:mysql://localhost:3306/ran"; // 连接数据库URL
			String userName = "root"; // 连接数据库的用户名
			String passWord = "1203"; // 连接数据库密码
			conn = DriverManager.getConnection(url, userName, passWord); // 获取数据库连接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; // 返回Connection对象
	}

	public void insertEmp(Emp emp2) {
		conn = getConn(); // 获取数据库连接
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
					JOptionPane.showMessageDialog(null, "密码修改成功");
					s++;
					break;
				}
			}
			if (s == 0) {
				JOptionPane.showMessageDialog(null, "用户不存在");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
