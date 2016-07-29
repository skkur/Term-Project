package com.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.insert.Emp;

public class JdbcDel {
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

		int c = emp2.getCha();
		System.out.println(c);

		try {
			Statement a = conn.createStatement();
			ResultSet b = a.executeQuery("select * from info");
			int s = 0;
			while (b.next()) {
				if (b.getInt(1) == c) {
					a.executeUpdate("delete from info where id=" + c);
					JOptionPane.showMessageDialog(null, "删除成功");
					s++;
					break;
				}

			}
			if (s == 0) {
				JOptionPane.showMessageDialog(null, "删除的内容不存在");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
