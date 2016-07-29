package com.term.service;

import java.util.Vector;

import com.term.service.User;
import com.term.service.SqlHelper;

public class UserService {

	// ��֤�û��Ƿ�Ϸ�
	public boolean checkUser(User user) {

		boolean b = false;
		String sql = "select * from users where userName=? and passwd=?";
		String parameters[] = { user.getUserName(), user.getPasswd() };
		Vector<Object[]> vector = new SqlHelper().executeQuery(sql, parameters);
		if (vector.size() != 0) {
			b = true;
		}
		return b;
	}
}
