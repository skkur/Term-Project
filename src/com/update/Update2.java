package com.update;

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

public class Update2 extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField nameTextField;
	JTextField ageTextField;
	JTextField deptTextField;
	JTextField phoneTextField;
	JTextField sexTextField;
	JTextArea remakeTextArea = new JTextArea();

	public Update2() {
		this.setSize(500, 400);
		this.setVisible(true);
		this.setLocation(810, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);// javaĬ��ΪflowLayout���ֵģ�����Ϊnull��Ϊ��ղ��ֹ�����
		setTitle("�޸���Ϣ");
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 390, 322);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel nameLabel = new JLabel("ԭ���ݱ��:");
		nameLabel.setBounds(63, 24, 100, 21);
		panel.add(nameLabel);

		nameTextField = new JTextField();
		nameTextField.setBounds(150, 21, 194, 21);
		panel.add(nameTextField);
		nameTextField.setColumns(10);

		JLabel sexLabel = new JLabel("��ҵ������:");
		sexLabel.setBounds(63, 55, 100, 21);
		panel.add(sexLabel);

		ageTextField = new JTextField();
		ageTextField.setBounds(150, 83, 194, 21);
		panel.add(ageTextField);
		ageTextField.setColumns(10);

		sexTextField = new JTextField();
		sexTextField.setBounds(150, 52, 194, 21);
		panel.add(sexTextField);
		sexTextField.setColumns(10);

		JLabel ageLabel = new JLabel("�¾�ס���:");
		ageLabel.setBounds(63, 86, 100, 21);
		panel.add(ageLabel);

		JLabel deptLabel = new JLabel("��ÿ�����:");
		deptLabel.setBounds(63, 118, 100, 21);
		panel.add(deptLabel);

		deptTextField = new JTextField();
		deptTextField.setBounds(150, 115, 194, 21);
		panel.add(deptTextField);
		deptTextField.setColumns(10);

		JLabel phoneLabel = new JLabel("�½���ҵ��:");
		phoneLabel.setBounds(63, 153, 100, 21);
		panel.add(phoneLabel);

		phoneTextField = new JTextField();
		phoneTextField.setBounds(150, 150, 194, 21);
		panel.add(phoneTextField);
		phoneTextField.setColumns(10);

		JLabel label = new JLabel("��ע��");
		label.setBounds(107, 187, 54, 21);
		panel.add(label);

		remakeTextArea.setBounds(150, 183, 194, 69);
		panel.add(remakeTextArea);

		JButton insertButton = new JButton("�޸�");
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

		JLabel messageLabel = new JLabel("����");
		messageLabel.setBounds(350, 24, 46, 21);
		panel.add(messageLabel);

		JLabel label_1 = new JLabel("*");
		label_1.setBounds(350, 118, 54, 15);
		panel.add(label_1);
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
		JdbcUtil2 util = new JdbcUtil2();
		Emp2 emp = new Emp2();

		emp.setName(Integer.parseInt(nameTextField.getText()));
		emp.setSex(sexTextField.getText());
		emp.setAge(Integer.parseInt(ageTextField.getText()));
		emp.setDept(Integer.parseInt(deptTextField.getText()));
		emp.setPhone(Integer.parseInt(phoneTextField.getText()));
		emp.setRemark(remakeTextArea.getText());
		if (!(nameTextField.getText().equals(""))
				&& (!deptTextField.getText().equals(""))
				&& (!phoneTextField.getText().equals(""))) {
			util.insertEmp(emp);

			JOptionPane.showMessageDialog(getContentPane(), "�����޸ĳɹ���", "��Ϣ��ʾ��",
					JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(getContentPane(), "�뽫��Ϣ�޸�������",
					"��Ϣ��ʾ��", JOptionPane.WARNING_MESSAGE);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
