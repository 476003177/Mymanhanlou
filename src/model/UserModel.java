/*
 * �û�������ģ�ͣ���ɶ��û���ĸ��ֲ���
 */
package model;

import java.sql.ResultSet;
import java.sql.*;
import db.*;
public class UserModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 
	 * @param uid �û����
	 * @param p   �û�����
	 * @return    ���û���ְλ�����������򷵻�""
	 */
	public String checkUser(String uid,String p)
	{
		String zhiwei="";
		SqlHelper sp=null;
		try {
			//��֯sql�Ͳ����б�
			String sql="select people.work from login,people where login.id=people.id and login.id=? and login.pass=?";
			String paras[]={uid,p};
			sp=new SqlHelper();
			ResultSet rs=sp.query(sql, paras);
			if(rs.next())
			{
				zhiwei=rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			sp.close();
		}
		return zhiwei;
	}
}
