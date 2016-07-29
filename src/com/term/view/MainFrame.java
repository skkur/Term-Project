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
	/* ������ */
	private static final long serialVersionUID = 1L;

	private JMenuBar menubar;
	private JMenu system, Manage, tool, about;
	private JMenuItem change, exit, addinfo, query, updata, del, cal, note,
			bgchange, aboutUs, help, re;

	int width = Toolkit.getDefaultToolkit().getScreenSize().width;// ��Ļ���
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;// ��Ļ�ĸ߶�

	public static void main(String[] args) {
		System.out.println((int) (Math.random() * 2) + 1);
		new MainFrame(new User());
	}

	public MainFrame(User user) {

		menubar = new JMenuBar();

		system = new JMenu("--ϵͳ--");
		system.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/sys.png")));
		system.setFont(Utils.f2);

		change = new JMenuItem("�����޸�");
		change.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/xgmm.png")));
		change.setFont(Utils.f2);
		change.addActionListener(this);
		system.add(change);
		
		re = new JMenuItem("���µ�¼");
		re.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/xgmm.png")));
		re.setFont(Utils.f2);
		re.addActionListener(this);
		system.add(re);

		exit = new JMenuItem("�˳�ϵͳ");
		exit.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/tuichu.png")));
		exit.setFont(Utils.f2);
		exit.addActionListener(this);
		system.add(exit);

		// 2
		Manage = new JMenu("--����--");
		Manage.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/gl.png")));
		Manage.setFont(Utils.f2);

		addinfo = new JMenuItem("¼��");
		addinfo.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/z.png")));
		addinfo.setFont(Utils.f2);
		addinfo.addActionListener(this);
		Manage.add(addinfo);

		query = new JMenuItem("��ѯ");
		query.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/c.png")));
		query.setFont(Utils.f2);
		query.addActionListener(this);
		Manage.add(query);

		updata = new JMenuItem("����");
		updata.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/g.png")));
		updata.setFont(Utils.f2);
		updata.addActionListener(this);
		Manage.add(updata);

		del = new JMenuItem("ɾ��");
		del.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/s.png")));
		del.setFont(Utils.f2);
		del.addActionListener(this);
		Manage.add(del);

		// 3
		tool = new JMenu("--����--");
		tool.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/tool.png")));
		tool.setFont(Utils.f2);

		cal = new JMenuItem("������");
		cal.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/jsq.png")));
		cal.setFont(Utils.f2);
		cal.addActionListener(this);
		tool.add(cal);

		note = new JMenuItem("���±�");
		note.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/jsb.png")));
		note.setFont(Utils.f2);
		note.addActionListener(this);
		tool.add(note);

		bgchange = new JMenuItem("��������");
		bgchange.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/qh.png")));
		bgchange.setFont(Utils.f2);
		bgchange.addActionListener(this);
		tool.add(bgchange);

		// 4
		about = new JMenu("����");
		about.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/about.png")));
		about.setFont(Utils.f2);

		help = new JMenuItem("����");
		help.setIcon(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/help.png")));
		help.setFont(Utils.f2);
		help.addActionListener(this);
		about.add(help);

		aboutUs = new JMenuItem("��������");
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
		this.setTitle("��������ԷС����ҵ����ϵͳ   ��ǰ�û�:" + "����Ա");
		this.setIconImage(new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/term/images/tittle.png")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height - 50);
		this.setVisible(true);
		try {
			// ʹ��ϵͳ�ָ���ʾ
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

	// ����ͼ�ڲ���
	class BgImage extends JPanel {
		int rom = (int) (Math.random() * 4 + 1);
		private static final long serialVersionUID = 1L;

		Image im = null;

		public BgImage() {
			im = new ImageIcon(this.getClass().getClassLoader()
					.getResource("com/term/images/" + rom + ".jpg")).getImage();

		}

		// ��ͼƬ����
		@Override
		public void paintComponent(Graphics g) {

			g.drawImage(im, 0, 0, width, height, this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// �˵�����¼�
		if (e.getSource() == aboutUs) {

			JOptionPane.showMessageDialog(this, "���ߣ��Ƴ��ԡ���ҳ��http://wasis.cn");

		} else if (e.getSource() == addinfo) {

			new Insert();

		} else if (e.getSource() == exit) {

			System.exit(0);

		} else if (e.getSource() == note) {

			new Note();
		} else if (e.getSource() == bgchange) {

			new MainFrame(new User());
			this.dispose(); // �رմ��壬���ͷ���Դ

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
