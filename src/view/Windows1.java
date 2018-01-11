/*
 * �����棬ϵͳ����Ա����������
 */

package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;
import tools.*; //�Լ�����İ�
import view.UserLogin.BackImage;

public class Windows1 extends JFrame implements ActionListener, MouseListener {
	Image titleIcon, timebj;
	JToolBar jtb;
	JMenuBar jmb;
	JMenu jm1, jm2, jm3, jm4, jm5, jm6;
	JMenuItem jmi1, jmi2, jmi3, jmi4, jmi5; // �����˵�
	ImageIcon jmi1_icon, jmi2_icon, jmi3_icon, jmi4_icon, jmi5_icon; // ͼ��
	JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10;
	JPanel p1, p2, p3, p4, p5;
	JLabel p1_lab[];
	JLabel p2_lab1, p2_lab2;
	ImagePanel p1_imgePanel;
	JLabel timeNow;
	javax.swing.Timer t; // �Ѱ�д���Ǳ���������������Timer�����ã���ʱ����Action�¼�
	JSplitPane jsp;
	CardLayout cardp3,cardp2;
	
	public static void main(String[] args) {
		Windows1 w1 = new Windows1();

	}

	// ��ʼ��������
	public void initMenu() {
		// ����һ���˵�
		jm1 = new JMenu("ϵͳ����");
		jm1.setFont(Mytools.f1);
		// �������Ķ����˵�
		jmi1_icon = new ImageIcon("image/qhyh.jpg");
		jmi1 = new JMenuItem("�л��û�", jmi1_icon); // ����Ϊͼ��
		jmi1.setFont(Mytools.f2);
		jmi2_icon = new ImageIcon("image/qhsy.jpg");
		jmi2 = new JMenuItem("�л����տ����", jmi2_icon);
		jmi2.setFont(Mytools.f2);
		jmi3_icon = new ImageIcon("image/login.jpg");
		jmi3 = new JMenuItem("��½����", jmi3_icon);
		jmi3.setFont(Mytools.f2);
		jmi4_icon = new ImageIcon("image/wnl.jpg");
		jmi4 = new JMenuItem("������", jmi4_icon);
		jmi4.setFont(Mytools.f2);
		jmi5_icon = new ImageIcon("image/exit.jpg");
		jmi5 = new JMenuItem("�˳�", jmi5_icon);
		jmi5.setFont(Mytools.f2);
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		jm1.add(jmi5);

		jm2 = new JMenu("���¹���");
		jm2.setFont(Mytools.f1);
		jm3 = new JMenu("�˵�����");
		jm3.setFont(Mytools.f1);
		jm4 = new JMenu("����ͳ��");
		jm4.setFont(Mytools.f1);
		jm5 = new JMenu("�ɱ����ⷿ");
		jm5.setFont(Mytools.f1);
		jm6 = new JMenu("����");
		jm6.setFont(Mytools.f1);
		// һ���˵����뵽JMenuBar
		jmb = new JMenuBar();
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		// ��JMenuBar��ӵ�JFrame
		this.setJMenuBar(jmb);
	}

	// ��ʼ���˵�
	public void initToolBar() {
		// ������
		jtb = new JToolBar();
		jtb.setFloatable(false); // ���ò����ƶ�
		jb1 = new JButton(new ImageIcon("image/jt1.jpg"));
		jb2 = new JButton(new ImageIcon("image/jt2.jpg"));
		jb3 = new JButton(new ImageIcon("image/jt3.jpg"));
		jb4 = new JButton(new ImageIcon("image/jt4.jpg"));
		jb5 = new JButton(new ImageIcon("image/jt5.jpg"));
		jb6 = new JButton(new ImageIcon("image/jt6.jpg"));
		jb7 = new JButton(new ImageIcon("image/jt7.jpg"));
		jb8 = new JButton(new ImageIcon("image/jt8.jpg"));
		jb9 = new JButton(new ImageIcon("image/jt9.jpg"));
		jb10 = new JButton(new ImageIcon("image/jt10.jpg"));
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
		jtb.add(jb6);
		jtb.add(jb7);
		jtb.add(jb8);
		jtb.add(jb9);
		jtb.add(jb10);
	}

	// ��ʼ���м��ĸ�JPanel
	public void initAllPanels() {
		// �м����
		p1 = new JPanel(new BorderLayout());
		Image p1_bg = null;
		try {
			p1_bg = ImageIO.read(new File("image/jp1_bg.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Cursor myCursor=new Cursor(Cursor.HAND_CURSOR);//���ù��
		p1_lab=new JLabel[8];
		this.p1_imgePanel = new ImagePanel(p1_bg);
		this.p1_imgePanel.setLayout(new GridLayout(8, 1));
		p1_lab[0] = new JLabel(new ImageIcon("image/p1_mhl.jpg"));
//		p1_lab[0].setFont(Mytools.f3);
//		p1_imgePanel.add(p1_lab[0]);
		p1_lab[1] = new JLabel("�� �� �� ��", new ImageIcon("image/rs.jpg"), 0);
		p1_lab[2] = new JLabel("�� ¼ �� ��", new ImageIcon("image/login.jpg"), 0);
		p1_lab[3] = new JLabel("�� �� �� ��", new ImageIcon("image/cp.jpg"), 0);
		p1_lab[4] = new JLabel("�� �� ͳ ��", new ImageIcon("image/bbtj.jpg"), 0);
		p1_lab[5] = new JLabel("�ɱ����ⷿ", new ImageIcon("image/cb.jpg"), 0);
		p1_lab[6] = new JLabel("ϵ ͳ �� ��", new ImageIcon("image/xtsz.jpg"), 0);
		p1_lab[7] = new JLabel("�� �� �� ��", new ImageIcon("image/dhbz.jpg"), 0);
		for(int i=0;i<p1_lab.length;i++)
		{
			p1_lab[i].setFont(Mytools.f3);
			p1_lab[i].setCursor(myCursor);//��������
			p1_lab[i].setEnabled(false); // �ø�Label������
			p1_lab[i].addMouseListener(this);//ע�����
			p1_imgePanel.add(p1_lab[i]);
		}
		p1_lab[0].setEnabled(true);
		p1.add(p1_imgePanel);

		// ����p2,p3,p4
		p4 = new JPanel(new BorderLayout());
		cardp2=new CardLayout();
		p2 = new JPanel(this.cardp2); // ��Ƭ����
		p2_lab1 = new JLabel(new ImageIcon("image/p2_zuo.jpg"));
		p2_lab1.setCursor(myCursor);
		p2_lab1.addMouseListener(this);
		p2_lab2 = new JLabel(new ImageIcon("image/p2_you.jpg"));
		p2_lab2.setCursor(myCursor);
		p2_lab2.addMouseListener(this);
		p2.add(p2_lab1, "left");
		p2.add(p2_lab2, "right");
		cardp3=new CardLayout();
		p3 = new JPanel(this.cardp3);
		Image zhu_image = null; // p3�����汳��ͼ
		try {
			zhu_image = ImageIO.read(new File("image/p3_bj.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImagePanel ip = new ImagePanel(zhu_image);
		p3.add(ip, "0");//ip��Ƭ����Ϊ��0��
		EmpInfo eInfo=new EmpInfo();
		p3.add(eInfo,"1");//eInfo��Ƭ����Ϊ��1��
		Chart mychart=new Chart();
		p3.add(mychart,"4");
		
		p4.add(p2, "West");
		p4.add(p3, "Center");
		// ��ִ��ڷֱ���p1,p4
		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, p1, p4);
		jsp.setDividerLocation(120); // ָ��������ռ���
		jsp.setDividerSize(0); // �ѱ߽�����Ϊ0

	}

	// ��ʼ��״̬��
	public void initzt() {
		// ״̬��
		p5 = new JPanel(new BorderLayout()); // JPanelĬ�ϵĲ��ֹ�����ΪFlowLayout
		t = new Timer(1000, this); // ÿ��1000���봥��ActionEvent
		t.start();
		timeNow = new JLabel("��ǰʱ�䣺" + Calendar.getInstance().getTime().toLocaleString());// �õ�ʱ��
		timeNow.setFont(Mytools.f1);
		try {
			timebj = ImageIO.read(new File("image/bj.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImagePanel ip1 = new ImagePanel(timebj);
		ip1.setLayout(new BorderLayout());
		ip1.add(timeNow, "East");
		p5.add(ip1);
	}

	public Windows1() {
		// �������
		try {
			titleIcon = ImageIO.read(new File("image/jb.jpg"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ���ó�ʼ���˵�
		this.initMenu();
		// ���ó�ʼ��������
		this.initToolBar();
		// ���ó�ʼ���м����
		this.initAllPanels();
		// ���ó�ʼ��״̬��
		this.initzt();

		Container ct = this.getContentPane(); // �ڶ�����ӵ�JFrame��ʽ
		ct.add(jtb, "North");
		ct.add(jsp);
		ct.add(p5, "South");

		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(w, h - 30);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(titleIcon); // ����ͼ��
		this.setTitle("����¥����ϵͳ"); // ���ñ���
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.timeNow.setText("��ǰʱ�䣺" + Calendar.getInstance().getTime().toLocaleString());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.p1_lab[0])
		{
			this.cardp3.show(p3, "0");
		}else if(e.getSource()==this.p1_lab[1])
		{
			this.cardp3.show(p3, "1");
		}else if(e.getSource()==this.p1_lab[4])
		{
			this.cardp3.show(p3, "4");
		}else if(e.getSource()==this.p2_lab1)
		{
			this.cardp2.show(p2, "right");
			this.jsp.setDividerLocation(0);
		}else if(e.getSource()==this.p2_lab2)
		{
			this.cardp2.show(p2, "left");
			this.jsp.setDividerLocation(120);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=1;i<p1_lab.length;i++)
		{
			if(e.getSource()==this.p1_lab[i])
			{
				this.p1_lab[i].setEnabled(true);
			}
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=1;i<p1_lab.length;i++)
		{
			if(e.getSource()==this.p1_lab[i])
			{
				this.p1_lab[i].setEnabled(false);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
