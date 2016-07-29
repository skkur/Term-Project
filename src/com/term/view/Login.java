package com.term.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.term.service.User;
import com.term.service.UserService;
import com.term.service.Utils;

public class Login extends JFrame implements ActionListener {

	/* 登录界面 */
	private static final long serialVersionUID = 1L; // 定义成一个常量，无法修改和继承

	private JLabel logoLabel, userNameLabel, passwordLabel;
	private JTextField userNameInput;
	private JPasswordField passwordInput;
	private JButton login, reset;

	public static void main(String[] args) {
		new Login();
	}

	public Login() {

		// 得到顶级容器
		Container container = this.getContentPane();
		this.setLayout(null);

		logoLabel = new JLabel("小区物业系统");
		logoLabel.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/logo.png")));
		logoLabel.setFont(Utils.f1);
		logoLabel.setBounds(150, 50, 200, 40);
		container.add(logoLabel);

		userNameLabel = new JLabel("用户名:");
		userNameLabel.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/user.png")));
		userNameLabel.setFont(Utils.f2);
		userNameLabel.setBounds(120, 140, 80, 40);
		container.add(userNameLabel);

		userNameInput = new JTextField();
		userNameInput.setBounds(220, 148, 150, 22);
		container.add(userNameInput);

		passwordLabel = new JLabel("密　码:");
		passwordLabel.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/password.png")));
		passwordLabel.setFont(Utils.f2);
		passwordLabel.setBounds(120, 180, 80, 40);
		container.add(passwordLabel);

		passwordInput = new JPasswordField();
		passwordInput.setBounds(220, 188, 150, 22);
		container.add(passwordInput);

		login = new JButton("登录");
		login.setFont(Utils.f2);
		login.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/login.png")));
		login.setBounds(100, 260, 90, 30);
		login.addActionListener(this);
		container.add(login);

		reset = new JButton("重置");
		reset.setFont(Utils.f2);
		reset.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/reset.png")));
		reset.setBounds(300, 260, 90, 30);
		reset.addActionListener(this);
		container.add(reset);

		this.setSize(500, 400);
		this.setTitle("保定市西苑小区物业管理系统V1.0");
		this.setIconImage(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/tittle.png")).getImage());
		this.setResizable(false); // false窗口大小不可改变
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出
		this.setLocationRelativeTo(null); // 设置窗口相对于指定组件的位置
		this.setVisible(true);
		try { // 把外观设置成你所使用的平台的外观
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

		// 得到用户输入的信息
		String userName = this.userNameInput.getText().trim();
		// 这里不能用toString方法
		String password = new String(this.passwordInput.getPassword());
		User user = new User();
		user.setUserName(userName);
		user.setPasswd(password);
		if (e.getSource() == login) {
			// 判断用户是否有输入
			if (Utils.isEmpty(user.getUserName())
					&& Utils.isEmpty(user.getPasswd())) {
				if (new UserService().checkUser(user)) {

					new MainFrame(user); // 新界面
					this.dispose(); // 关闭窗体，关释放资源
				} else {
					JOptionPane.showMessageDialog(this, "用户名或密码错误");
				}
			} else {
				JOptionPane.showMessageDialog(this, "用户名或密码不能为空");
			}

		} else if (e.getSource() == reset) {

			this.userNameInput.setText("admin");
			this.passwordInput.setText("123");
		}
	}
}
