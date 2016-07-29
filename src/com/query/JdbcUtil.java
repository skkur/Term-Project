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

	// ��ȡ���ݿ�����
	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // �������ݿ�����
			String url = "jdbc:mysql://127.0.0.1:3306/ran"; // �������ݿ�URL
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

	public List<Emp> insertEmp(Emper emp) {
		conn = getConn(); // ��ȡ���ݿ�����
		List<Emp> list = new ArrayList<Emp>();
		int c = emp.getQuery();
		/* System.out.println(c);test������ */
		try {
			Statement a = conn.createStatement();
			ResultSet b = a.executeQuery("select * from info");
			while (b.next()) {
				if (b.getInt(1) == c) {
					/*
					 * System.out.println("���ݱ��:" + b.getInt(1));
					 * System.out.println("���ݱ��:" + b.getString(2));
					 * System.out.println("���ݱ��:" + b.getInt(3));
					 * System.out.println("���ݱ��:" + b.getInt(4));
					 * System.out.println("���ݱ��:" + b.getString(5));
					 * System.out.println("���ݱ��:" + b.getString(6));
					 */
					Emp Emp = new Emp();
					Emp.setId(b.getInt(1)); // ���ö�������
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

		return list; // ���ؼ���

	}

}