package com.insert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.insert.Emp;
import com.term.service.Utils;

public class Delete extends JDialog implements ActionListener {
	/* ɾ����Ϣ */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField Id_Text;

	public Delete() {
		this.setLocation(700, 300);
		this.setSize(400, 300);
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("��Ϣɾ��");
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 390, 322);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel nameLabel = new JLabel("���ݱ��");
		nameLabel.setFont(Utils.f2);
		nameLabel.setBounds(63, 24, 100, 15);
		panel.add(nameLabel);

		Id_Text = new JTextField();
		Id_Text.setBounds(125, 21, 194, 21);
		panel.add(Id_Text);
		Id_Text.setColumns(10);

		JButton deleteButton = new JButton("ɾ��");
		deleteButton.addActionListener(this);
		deleteButton.setBounds(63, 86, 100, 25);
		panel.add(deleteButton);

		JButton closeButton = new JButton("�ر�ϵͳ");
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_closeButton(arg0);
			}
		});
		closeButton.setBounds(230, 86, 100, 25);
		panel.add(closeButton);

	}

	// �رհ�ť�ĵ����¼�
	protected void do_closeButton(ActionEvent arg0) {
		int n = JOptionPane.showConfirmDialog(getContentPane(), "ȷ����ȷ��",
				"ȷ�϶Ի���", JOptionPane.YES_NO_CANCEL_OPTION);
		if (n == JOptionPane.YES_OPTION) { // ����û�ȷ����Ϣ
			System.exit(0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JdbcDel util = new JdbcDel();
		Emp emp = new Emp();
		int gg = Integer.parseInt(Id_Text.getText());
		emp.setCha(gg);
		util.insertEmp(emp);

	}
}
