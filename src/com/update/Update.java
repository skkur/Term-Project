package com.update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Update extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel a, a1;
	JLabel b;
	JTextField c;
	JTable table;

	JButton d;

	public Update() {
		setTitle("修改信息");
		this.setLocation(500, 300);

		a = new JPanel();
		a.setLayout(null);
		a1 = new JPanel();
		b = new JLabel("房屋编号");
		b.setBounds(12, 25, 150, 21);
		c = new JTextField(10);
		c.setBounds(75, 25, 200, 21);
		d = new JButton("更新");

		d.addActionListener(this);
		a.add(b);
		a.add(c);
		a1.add(d);
		this.add(a1, "South");
		this.add(a, "Center");
		this.setSize(300, 200);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Update();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JdbcUtil util = new JdbcUtil();
		Emp emp = new Emp();
		int gg = Integer.parseInt(c.getText());
		emp.setCha(gg);
		util.insertEmp(emp);

	}
}
