package com.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
	static Connection conn = null;

	// 获取数据库连接
	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载数据库驱动
			String url = "jdbc:mysql://127.0.0.1:3306/ran"; // 连接数据库URL
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

	public List<Emp> insertEmp(Emper emp) {
		conn = getConn(); // 获取数据库连接
		List<Emp> list = new ArrayList<Emp>();
		int c = emp.getQuery();
		/* System.out.println(c);test输出编号 */
		try {
			Statement a = conn.createStatement();
			ResultSet b = a.executeQuery("select * from info");
			while (b.next()) {
				if (b.getInt(1) == c) {
					/*
					 * System.out.println("房屋编号:" + b.getInt(1));
					 * System.out.println("房屋编号:" + b.getString(2));
					 * System.out.println("房屋编号:" + b.getInt(3));
					 * System.out.println("房屋编号:" + b.getInt(4));
					 * System.out.println("房屋编号:" + b.getString(5));
					 * System.out.println("房屋编号:" + b.getString(6));
					 */
					Emp Emp = new Emp();
					Emp.setId(b.getInt(1)); // 设置对象属性
					Emp.setliveName(b.getString(2));
					Emp.setarea(b.getInt(3));
					Emp.setmoney(b.getInt(4));
					Emp.setcost(b.getInt(5));
					Emp.setareaT(b.getString(6));
					list.add(Emp);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list; // 返回集合

	}

}