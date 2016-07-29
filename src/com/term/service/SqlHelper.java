package com.term.service;

import java.sql.*;
import java.util.Properties;
import java.util.Vector;
import java.io.*;

/*
 * 操作数据库类
 * */
public class SqlHelper {

	private Connection connect = null;
	private PreparedStatement statement = null;
	private ResultSet result = null;
	private ResultSetMetaData metaData = null;
	// 连接数据库的属性
	private String driver, url, userName, password;
	Properties properties = new Properties();

	// 初始化数据
	public SqlHelper() {
		// 使用类加载器关联文件
		InputStream input = this.getClass().getClassLoader()
				.getResourceAsStream("DB.properties");
		try {
			// 加载文件
			properties.load(input);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			userName = properties.getProperty("userName");
			password = properties.getProperty("password");
			// 加载驱动
			Class.forName(driver);

		} catch (IOException e) {
			System.out.println("加载文件失败");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("驱动没有找到");
			e.printStackTrace();
		} finally {
			try {
				if (input != null)
					input.close();
			} catch (IOException e) {
				input = null;
				e.printStackTrace();
			}
		}
	}

	// 查询函数
	public Vector<Object[]> executeQuery(String sql, String[] parameters) {

		Vector<Object[]> vector = new Vector<Object[]>();

		try {
			// 得到连接
			connect = DriverManager.getConnection(url, userName, password);

			statement = connect.prepareStatement(sql);
			// 给问号赋值
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					statement.setString(i + 1, parameters[i]);
				}
			}
			result = statement.executeQuery();
			// 得到共有多少列
			metaData = result.getMetaData();
			int column = metaData.getColumnCount();
			// 循环的取出数据
			while (result.next()) {
				Object[] objects = new Object[column];
				for (int i = 0; i < objects.length; i++) {

					objects[i] = result.getObject(i + 1);
				}
				vector.add(objects);
			}

		} catch (SQLException e) {
			new RuntimeException(e.getMessage());
			e.printStackTrace();
		} finally {
			this.close();
		}

		return vector;

	}

	// 关闭资源函数
	public void close() {
		try {
			if (result != null)
				result.close();
			result = null;
			if (statement != null)
				statement.close();
			statement = null;
			if (connect != null)
				connect.close();
			connect = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
