package com.term.service;

import java.awt.Font;

public class Utils {

	// ��������
	public static Font f1 = new Font("����", Font.PLAIN, 24);
	public static Font f2 = new Font("����", Font.PLAIN, 14);

	// ���˿��ַ���
	public static boolean isEmpty(String str) {

		boolean b = false;

		if (str != null && str.length() != 0) {
			b = true;
		}

		return b;
	}
}
