package com.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtil2 {
	static Connection conn = null;

	// 获取数据库连接
	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载数据库驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/ran"; // 连接数据库URL
		String userName = "root"; // 连接数据库的用户名
		String passWord = "1203"; // 连接数据库密码
		try {
			conn = DriverManager.getConnection(url, userName, passWord); // 获取数据库连接
			if (conn != null) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; // 返回Connection对象
	}

	public void insertEmp(Emp2 emp) {
		conn = getConn(); // 获取数据库连接
		try {
			PreparedStatement statement = conn
					.prepareStatement("insert into info values(?,?,?,?,?,?)"); // 定义插入数据库的预处理语句
			// 为sql语句中的参数赋值;
			statement.setInt(1, emp.getName()); // 设置预处理语句的参数值
			statement.setString(2, emp.getSex());
			statement.setInt(3, emp.getAge());
			statement.setInt(4, emp.getDept());
			statement.setInt(5, emp.getPhone());
			statement.setString(6, emp.getRemark());
			statement.executeUpdate(); // 执行预处理语句
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}