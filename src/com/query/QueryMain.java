package com.query;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class QueryMain extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel a, a1;
	JLabel b;
	JTextField c;
	JTable table;
	LocalTableModel model = new LocalTableModel();
	JButton d;

	public QueryMain() {
		setTitle("查询信息");
		a = new JPanel();
		a1 = new JPanel();
		b = new JLabel("房屋编号:");
		c = new JTextField(10);
		d = new JButton("查询");

		JScrollPane scrollPane = new JScrollPane();
		a1.add(scrollPane);

		JTable table = new JTable(model);
		scrollPane.setViewportView(table);

		d.addActionListener(this);
		a.add(b);
		a.add(c);
		a.add(d);
		this.add(a, "South");
		this.add(a1, "Center");
		this.setSize(480, 400);
		this.setVisible(true);
		this.setLocation(700, 300);

	}

	public static void main(String[] args) {
		new QueryMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JdbcUtil util = new JdbcUtil();
		Emper emp = new Emper();

		emp.setQuery(Integer.parseInt(c.getText()));

		model.setRowCount(0);
		List<?> list = util.insertEmp(emp);

		int i;
		int ggg = 0;
		for (i = 0; i < list.size(); i++) {
			Emp grade = (Emp) list.get(i);
			model.addRow(new Object[] { grade.getId(), grade.getliveName(),
					grade.getarea(), grade.getMoney(), grade.getcost(),
					grade.getareaT() });
			ggg = grade.getId();
		}
		int ggx = Integer.parseInt(c.getText());
		if (ggx == ggg) {

		} else {
			JOptionPane.showMessageDialog(this, "未找到相关信息");
		}
	}
}