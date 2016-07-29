package com.insert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.query.Emp;
import com.term.service.Utils;

public class Insert extends JDialog implements ActionListener {
	/* ¼����Ϣ */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField nameTextField;
	JTextField ageTextField;
	JTextField deptTextField;
	JTextField phoneTextField;
	JTextField sexTextField;
	JTextArea remakeTextArea = new JTextArea();

	public Insert() {
		this.setLocation(700, 300);
		this.setSize(400, 400);
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("��Ϣ���");
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 390, 322);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel nameLabel = new JLabel("���ݱ��");
		nameLabel.setFont(Utils.f2);
		nameLabel.setBounds(63, 24, 100, 15);
		panel.add(nameLabel);

		nameTextField = new JTextField();
		nameTextField.setBounds(125, 21, 194, 21);
		panel.add(nameTextField);
		nameTextField.setColumns(10);

		JLabel sexLabel = new JLabel("ҵ������");
		sexLabel.setFont(Utils.f2);
		sexLabel.setBounds(63, 55, 100, 15);
		panel.add(sexLabel);

		ageTextField = new JTextField();
		ageTextField.setBounds(125, 83, 194, 21);
		panel.add(ageTextField);
		ageTextField.setColumns(10);

		sexTextField = new JTextField();
		sexTextField.setBounds(125, 52, 194, 21);
		panel.add(sexTextField);
		sexTextField.setColumns(10);

		JLabel ageLabel = new JLabel("��ס���");
		ageLabel.setFont(Utils.f2);
		ageLabel.setBounds(63, 86, 100, 15);
		panel.add(ageLabel);

		JLabel deptLabel = new JLabel("ÿ�����");
		deptLabel.setFont(Utils.f2);
		deptLabel.setBounds(63, 118, 100, 15);
		panel.add(deptLabel);

		deptTextField = new JTextField();
		deptTextField.setBounds(125, 115, 194, 21);
		panel.add(deptTextField);
		deptTextField.setColumns(10);

		JLabel phoneLabel = new JLabel("����ҵ��");
		phoneLabel.setFont(Utils.f2);
		phoneLabel.setBounds(63, 153, 100, 15);
		panel.add(phoneLabel);

		phoneTextField = new JTextField();
		phoneTextField.setBounds(125, 150, 194, 21);
		panel.add(phoneTextField);
		phoneTextField.setColumns(10);

		JLabel label = new JLabel("��ע");
		label.setFont(Utils.f2);
		label.setBounds(63, 187, 54, 15);
		panel.add(label);

		remakeTextArea.setBounds(118, 183, 194, 69);
		panel.add(remakeTextArea);

		JButton insertButton = new JButton("���");
		insertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_insertButton_actionPerformed(arg0);
			}
		});
		insertButton.setBounds(107, 275, 66, 23);
		panel.add(insertButton);

		JButton closeButton = new JButton("�ر�");
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				do_closeButton_actionPerformed(arg0);
			}
		});
		closeButton.setBounds(205, 275, 66, 23);
		panel.add(closeButton);

		JLabel messageLabel = new JLabel("*");
		messageLabel.setBounds(322, 24, 54, 15);
		panel.add(messageLabel);

		JLabel label_1 = new JLabel("*");
		label_1.setBounds(322, 118, 54, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("*");
		label_2.setBounds(322, 153, 54, 15);
		panel.add(label_2);
	}

	// �رհ�ť�ĵ����¼�
	protected void do_closeButton_actionPerformed(ActionEvent arg0) {
		int n = JOptionPane.showConfirmDialog(getContentPane(), "ȷ����ȷ��",
				"ȷ�϶Ի���", JOptionPane.YES_NO_CANCEL_OPTION);
		if (n == JOptionPane.YES_OPTION) { // ����û�ȷ����Ϣ
			System.exit(0);
		}
	}

	// ��Ӱ�ť�ĵ����¼�
	protected void do_insertButton_actionPerformed(ActionEvent arg0) {
		JdbcIn util = new JdbcIn();
		Emp emp = new Emp();

		emp.setId(Integer.parseInt(nameTextField.getText()));
		emp.setliveName(sexTextField.getText());
		emp.setarea(Integer.parseInt(ageTextField.getText()));
		emp.setmoney(Integer.parseInt(deptTextField.getText()));
		emp.setcost(Integer.parseInt(phoneTextField.getText()));
		emp.setareaT(remakeTextArea.getText());
		if (!(nameTextField.getText().equals(""))
				&& (!deptTextField.getText().equals(""))
				&& (!phoneTextField.getText().equals(""))) {
			util.insertEmp(emp);

			JOptionPane.showMessageDialog(getContentPane(), "������ӳɹ���", "��Ϣ��ʾ��",
					JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(getContentPane(), "�뽫��Ϣ���������",
					"��Ϣ��ʾ��", JOptionPane.WARNING_MESSAGE);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
