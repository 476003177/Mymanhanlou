package db;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

public class UpDialog extends JDialog implements ActionListener{

	JLabel jl[];
	JButton jb1,jb2;
	JTextField jtf[];
	JPanel jp1,jp2,jp3;
	AbstractTableModel atm1;
	int size=0;

	
	//owner--���ĸ�����;title--������;model--ָ����ģʽ���ڣ����Ƿ�ģʽ��ģʽ���ڱ�����Ӧ
	public UpDialog(Window owner,String title,Dialog.ModalityType modalityType,AbstractTableModel atm,int rowNum){
//		super(owner,title,modal);                                                             //���ø��๹�췽�����ﵽģʽ�Ի���Ч��
		super(owner,title,modalityType);
		SqlHelper sh=new SqlHelper();
		String sql="select * from people where 1=?";
		String []paras={"1"};
		ResultSet rs=sh.query(sql, paras);
		
		try {
			ResultSetMetaData rsmt=rs.getMetaData();//rsmt���Եõ�����ж����У��ҿ��Եõ�ÿ�е�����
			this.size=rsmt.getColumnCount();
			this.jl=new JLabel[size];
			this.jtf=new JTextField[size];
			System.out.println(this.size);
			for(int i=0;i<this.size;i++)
			{
				jl[i]=new JLabel(rsmt.getColumnLabel(i+1));//�õ�i�е����֣���1��ʼ
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			sh.close();
		}
		for(int i=0;i<this.size;i++)
		{
			jtf[i]=new JTextField();
		}
		if(atm!=null)
		{
			atm1=atm;
			for(int i=0;i<this.size;i++)
			{
				jtf[i].setText((String)atm.getValueAt(rowNum, i));;
			}
			jtf[0].setEditable(false);  //����jtf[0]���ݲ����޸�
			jb1=new JButton("�޸�");
		}else{
			jb1=new JButton("���");
		}
		
		jb2=new JButton("ȡ��");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		//���ò���
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));
		
		//������
		for(int i=0;i<this.size;i++)
		{
			jp1.add(jl[i]);
		}
		for(int i=0;i<this.size;i++)
		{
			jp2.add(jtf[i]);
		}
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		//չ��
		this.setSize(300, 250);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//�û������Ӱ�ť�����Ӧ����
		String sql;
		String []paras;
		if(e.getSource()==jb1){
			//�������ݿ�
			if(atm1!=null)
			{
				String sql1="";
				for(int i=0;i+1<this.size-1;i++)
				{
					sql1=sql1+jl[i+1].getText()+"=?,";
				}
				sql1=sql1+jl[this.size-1].getText()+"=? ";
				sql="update people set "+sql1+"where "+jl[0].getText()+"=?";
				paras=new String[this.size];
				for(int i=0;i+1<this.size;i++)
				{
					paras[i]=jtf[i+1].getText();
				}
				paras[this.size-1]=jtf[0].getText();
//				if(!temp.stuuprun(sql, paras))
//				{
//					JOptionPane.showMessageDialog(this, "�޸�ʧ��");
//				}
				SqlHelper sqlh=new SqlHelper();
				sqlh.updExectue(sql, paras);
			}else{
				sql="insert into people values(";
				for(int i=0;i<this.size-1;i++)
				{
					sql=sql+"?,";
				}
				sql=sql+"?)";
				paras=new String[this.size];
				for(int i=0;i<this.size;i++)
				{
					paras[i]=jtf[i].getText();
				}
//				if(!temp.stuuprun(sql, paras))
//				{
//					JOptionPane.showMessageDialog(this, "���ʧ��");
//				}
				SqlHelper sqlh=new SqlHelper();
				sqlh.updExectue(sql, paras);
			}
			this.dispose();	
//			System.out.println(sql);
//			for(int i=0;i<paras.length;i++)System.out.println(paras[i]);
		}
		else if(e.getSource()==jb2){
			this.dispose();
		}
		
	}
}
