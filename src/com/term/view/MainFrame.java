package com.term.view;

import java.awt.*;
import java.lang.Math;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.insert.Delete;
import com.insert.Insert;
import com.query.QueryMain;
import com.term.service.User;
import com.term.service.Utils;
import com.update.Update;

public class MainFrame extends JFrame implements ActionListener {
	/* 主界面 */
	private static final long serialVersionUID = 1L;

	private JMenuBar menubar;
	private JMenu system, Manage, tool, about;
	private JMenuItem change, exit, addinfo, query, updata, del, cal, note,
			bgchange, aboutUs, help, re;

	int width = Toolkit.getDefaultToolkit().getScreenSize().width;// 屏幕宽度
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;// 屏幕的高度

	public static void main(String[] args) {
		System.out.println((int) (Math.random() * 2) + 1);
		new MainFrame(new User());
	}

	public MainFrame(User user) {

		menubar = new JMenuBar();

		system = new JMenu("--系统--");
		system.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/sys.png")));
		system.setFont(Utils.f2);

		change = new JMenuItem("密码修改");
		change.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/xgmm.png")));
		change.setFont(Utils.f2);
		change.addActionListener(this);
		system.add(change);
		
		re = new JMenuItem("重新登录");
		re.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/xgmm.png")));
		re.setFont(Utils.f2);
		re.addActionListener(this);
		system.add(re);

		exit = new JMenuItem("退出系统");
		exit.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/tuichu.png")));
		exit.setFont(Utils.f2);
		exit.addActionListener(this);
		system.add(exit);

		// 2
		Manage = new JMenu("--管理--");
		Manage.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/gl.png")));
		Manage.setFont(Utils.f2);

		addinfo = new JMenuItem("录入");
		addinfo.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/z.png")));
		addinfo.setFont(Utils.f2);
		addinfo.addActionListener(this);
		Manage.add(addinfo);

		query = new JMenuItem("查询");
		query.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/c.png")));
		query.setFont(Utils.f2);
		query.addActionListener(this);
		Manage.add(query);

		updata = new JMenuItem("更改");
		updata.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/g.png")));
		updata.setFont(Utils.f2);
		updata.addActionListener(this);
		Manage.add(updata);

		del = new JMenuItem("删除");
		del.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/s.png")));
		del.setFont(Utils.f2);
		del.addActionListener(this);
		Manage.add(del);

		// 3
		tool = new JMenu("--工具--");
		tool.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/tool.png")));
		tool.setFont(Utils.f2);

		cal = new JMenuItem("计算器");
		cal.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/jsq.png")));
		cal.setFont(Utils.f2);
		cal.addActionListener(this);
		tool.add(cal);

		note = new JMenuItem("记事本");
		note.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/jsb.png")));
		note.setFont(Utils.f2);
		note.addActionListener(this);
		tool.add(note);

		bgchange = new JMenuItem("背景更改");
		bgchange.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/qh.png")));
		bgchange.setFont(Utils.f2);
		bgchange.addActionListener(this);
		tool.add(bgchange);

		// 4
		about = new JMenu("关于");
		about.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/about.png")));
		about.setFont(Utils.f2);

		help = new JMenuItem("帮助");
		help.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/help.png")));
		help.setFont(Utils.f2);
		help.addActionListener(this);
		about.add(help);

		aboutUs = new JMenuItem("关于我们");
		aboutUs.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/aboutUs.png")));
		aboutUs.setFont(Utils.f2);
		aboutUs.addActionListener(this);
		about.add(aboutUs);

		menubar.add(system);
		menubar.add(Manage);
		menubar.add(tool);
		menubar.add(about);

		BgImage bg = new BgImage();

		bg.setBounds(0, 0, width, height - 30);
		this.add(bg);
		this.setJMenuBar(menubar);
		this.setTitle("保定市西苑小区物业管理系统   当前用户:" + "管理员");
		this.setIconImage(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/tittle.png")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height - 50);
		this.setVisible(true);
		try {
			// 使用系统分格显示
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
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
	}

	// 背景图内部类
	class BgImage extends JPanel {
		int rom = (int) (Math.random() * 4 + 1);
		private static final long serialVersionUID = 1L;

		Image im = null;

		public BgImage() {
			im = new ImageIcon(this.getClass().getClassLoader()
					.getResource("com/term/images/" + rom + ".jpg")).getImage();

		}

		// 画图片函数
		@Override
		public void paintComponent(Graphics g) {

			g.drawImage(im, 0, 0, width, height, this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 菜单点击事件
		if (e.getSource() == aboutUs) {

			JOptionPane.showMessageDialog(this, "作者：闫超辉。主页：http://wasis.cn");

		} else if (e.getSource() == addinfo) {

			new Insert();

		} else if (e.getSource() == exit) {

			System.exit(0);

		} else if (e.getSource() == note) {

			new Note();
		} else if (e.getSource() == bgchange) {

			new MainFrame(new User());
			this.dispose(); // 关闭窗体，关释放资源

		} else if (e.getSource() == query) {

			new QueryMain();
		} else if (e.getSource() == cal) {

			new com.term.view.Cal();
		} else if (e.getSource() == del) {

			new Delete();
		} else if (e.getSource() == change) {

			new com.term.m.PassWd();
		} else if (e.getSource() == updata) {

			new Update();
		} else if (e.getSource() == re) {

			new Login();
			this.dispose();
		}
	}

}
