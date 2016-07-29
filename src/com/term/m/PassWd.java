package com.term.m;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PassWd extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel a, a1;
	JLabel b, b1;
	JTextField c, c1;
	JTable table;

	JButton d;

	public PassWd() {
		setTitle("密码修改");

		a = new JPanel();
		a1 = new JPanel();
		a.setLayout(null);
		b = new JLabel("用户名:");
		b.setBounds(63, 24, 100, 15);
		c = new JTextField(10);
		c.setBounds(130, 21, 194, 21);
		b1 = new JLabel("新密码:");
		b1.setBounds(63, 50, 100, 15);
		c1 = new JTextField(10);
		c1.setBounds(130, 50, 194, 21);
		d = new JButton("修改");

		d.addActionListener(this);
		a.add(b);
		a.add(c);
		a.add(b1);
		a.add(c1);
		a1.add(d);
		this.add(a1, "South");
		this.add(a, "Center");
		this.setSize(400, 200);
		this.setVisible(true);
		this.setLocation(700, 300);

	}

	public static void main(String[] args) {
		new PassWd();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JdbcUtil util = new JdbcUtil();
		Emp emp = new Emp();
		// erEmp Emp = new erEmp();
		String gg = c.getText();
		int gg1 = Integer.parseInt(c1.getText());
		emp.setCha(gg);
		emp.setCha2(gg1);
		util.insertEmp(emp);

	}
}
