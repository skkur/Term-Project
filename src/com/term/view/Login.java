package com.term.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.term.service.User;
import com.term.service.UserService;
import com.term.service.Utils;

public class Login extends JFrame implements ActionListener {

	/* ��¼���� */
	private static final long serialVersionUID = 1L; // �����һ���������޷��޸ĺͼ̳�

	private JLabel logoLabel, userNameLabel, passwordLabel;
	private JTextField userNameInput;
	private JPasswordField passwordInput;
	private JButton login, reset;

	public static void main(String[] args) {
		new Login();
	}

	public Login() {

		// �õ���������
		Container container = this.getContentPane();
		this.setLayout(null);

		logoLabel = new JLabel("С����ҵϵͳ");
		logoLabel.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/logo.png")));
		logoLabel.setFont(Utils.f1);
		logoLabel.setBounds(150, 50, 200, 40);
		container.add(logoLabel);

		userNameLabel = new JLabel("�û���:");
		userNameLabel.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/user.png")));
		userNameLabel.setFont(Utils.f2);
		userNameLabel.setBounds(120, 140, 80, 40);
		container.add(userNameLabel);

		userNameInput = new JTextField();
		userNameInput.setBounds(220, 148, 150, 22);
		container.add(userNameInput);

		passwordLabel = new JLabel("�ܡ���:");
		passwordLabel.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/password.png")));
		passwordLabel.setFont(Utils.f2);
		passwordLabel.setBounds(120, 180, 80, 40);
		container.add(passwordLabel);

		passwordInput = new JPasswordField();
		passwordInput.setBounds(220, 188, 150, 22);
		container.add(passwordInput);

		login = new JButton("��¼");
		login.setFont(Utils.f2);
		login.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/login.png")));
		login.setBounds(100, 260, 90, 30);
		login.addActionListener(this);
		container.add(login);

		reset = new JButton("����");
		reset.setFont(Utils.f2);
		reset.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/reset.png")));
		reset.setBounds(300, 260, 90, 30);
		reset.addActionListener(this);
		container.add(reset);

		this.setSize(500, 400);
		this.setTitle("��������ԷС����ҵ����ϵͳV1.0");
		this.setIconImage(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/tittle.png")).getImage());
		this.setResizable(false); // false���ڴ�С���ɸı�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �˳�
		this.setLocationRelativeTo(null); // ���ô��������ָ�������λ��
		this.setVisible(true);
		try { // ��������ó�����ʹ�õ�ƽ̨�����
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// �õ��û��������Ϣ
		String userName = this.userNameInput.getText().trim();
		// ���ﲻ����toString����
		String password = new String(this.passwordInput.getPassword());
		User user = new User();
		user.setUserName(userName);
		user.setPasswd(password);
		if (e.getSource() == login) {
			// �ж��û��Ƿ�������
			if (Utils.isEmpty(user.getUserName())
					&& Utils.isEmpty(user.getPasswd())) {
				if (new UserService().checkUser(user)) {

					new MainFrame(user); // �½���
					this.dispose(); // �رմ��壬���ͷ���Դ
				} else {
					JOptionPane.showMessageDialog(this, "�û������������");
				}
			} else {
				JOptionPane.showMessageDialog(this, "�û��������벻��Ϊ��");
			}

		} else if (e.getSource() == reset) {

			this.userNameInput.setText("admin");
			this.passwordInput.setText("123");
		}
	}
}
