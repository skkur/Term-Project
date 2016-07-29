package com.term.service;

import java.sql.*;
import java.util.Properties;
import java.util.Vector;
import java.io.*;

/*
 * �������ݿ���
 * */
public class SqlHelper {

	private Connection connect = null;
	private PreparedStatement statement = null;
	private ResultSet result = null;
	private ResultSetMetaData metaData = null;
	// �������ݿ������
	private String driver, url, userName, password;
	Properties properties = new Properties();

	// ��ʼ������
	public SqlHelper() {
		// ʹ��������������ļ�
		InputStream input = this.getClass().getClassLoader()
				.getResourceAsStream("DB.properties");
		try {
			// �����ļ�
			properties.load(input);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			userName = properties.getProperty("userName");
			password = properties.getProperty("password");
			// ��������
			Class.forName(driver);

		} catch (IOException e) {
			System.out.println("�����ļ�ʧ��");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("����û���ҵ�");
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

	// ��ѯ����
	public Vector<Object[]> executeQuery(String sql, String[] parameters) {

		Vector<Object[]> vector = new Vector<Object[]>();

		try {
			// �õ�����
			connect = DriverManager.getConnection(url, userName, password);

			statement = connect.prepareStatement(sql);
			// ���ʺŸ�ֵ
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					statement.setString(i + 1, parameters[i]);
				}
			}
			result = statement.executeQuery();
			// �õ����ж�����
			metaData = result.getMetaData();
			int column = metaData.getColumnCount();
			// ѭ����ȡ������
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

	// �ر���Դ����
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
