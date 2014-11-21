package mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import common.*;

public class Dao {
	private static String driver = "com.mysql.jdbc.Driver"; // ��������
	private static String url = "jdbc:mysql://127.0.0.1:3306/chat"; // ����URL
	private static String name = "root"; // �����û���
	private static String password = "0000"; // ��������
	private static Connection conn = null; // ���ݿ�����
	
    //String sql = "create table  user_info (u_id int auto_increment primary key,u_name varchar(20) ,u_pass varchar(20),u_ques varchar(40),u_anser varchar(40),u_sex varchar(4),u_sign varchar(60))";
	// ������
	public static  Connection    dao1() {
		try {
			Class.forName(driver); // �������ݿ�
			conn = DriverManager.getConnection(url, name, password);// �������ݿ�
			
			//return conn;
			//ServerView.appendtoserver("�������ݿ�ɹ�!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "���ݿ������쳣�����߱�����Ѿ����С�");
			System.exit(0);
		}
		return conn;
	}
	
	// ��½ ���Գɹ�
	public static  boolean login(String account, String password) throws SQLException {
		account = "'" + account + "'";
		password = "'" +password + "'";
		String sql = "select *from user_info where u_name=" + account
				+ "and u_pass=" +password; // ����ִ�в�ѯ��sql���
		Statement statement = dao1().createStatement(); // ����һ�� Statement
		ResultSet b = statement.executeQuery(sql); // ִ�в�ѯ��sql��䣬���ҷ���һ��ResultSet��ѯ�����
		while (b.next()) // b.next()��ʾָ�벻������һ����ֻҪ��Ϊ�ռ���
		{
			System.out.println("��½�ɹ�");
			return true;
		}
		b.close(); // �ر�ResultSet ����
		statement.close(); // �ر�Statement ����
		System.out.println("��½ʧ��");
		return false;
	}
	
	//   ע��    ����û����û����ݱ� ���Ҵ�����¼�˵ĺ����б� ���Գɹ�
				public static   boolean addUserInfo(Users u)throws SQLException {
						String account=u.getId();
						String password=u.getPassword();
						String u_answer=u.getForget().getAnswer();
						String u_question=u.getForget().getQuestion();
						String u_sign=u.getSign();
						String u_sex=u.getSex();
						String u_nicname=u.getName();
						
					    
						String sql = "insert into user_info(u_name,u_pass,u_ques,u_anser,u_sign,u_sex, u_nicname) values(?,?,?,?,?,?,?)"; // ����һ���������ݿ��SQL��䣬���еģ�������Ըı�ı���
						PreparedStatement a;
						a = dao1().prepareStatement(sql);
						// ��coon������һ��PreparedStatement����
						a.setString(1, account); // ��u_name������ֵ������
						a.setString(2, password); // ��u_password������ֵ������
						a.setString(3, u_question); // ��u_answer������ֵ������
						a.setString(4, u_answer); // ��u_question������ֵ������
						a.setString(5, u_sign); // ��u_sign������ֵ������
						a.setString(6, u_sex); // ��u-sex������ֵ������
						a.setString(7, u_nicname); // ��u-sex������ֵ������
						if (a.executeUpdate() != 0) // ִ�в������ݿ��SQl���
						{   
							System.out.println("����ɹ�");
							return true;
						}
						a.close(); // �ر�a ����
						return false;
					
				}
				
	
	
	// ��ѯ�û������Ƿ��Ѿ������˴��˺�  ���Գɹ�
			public static boolean queryAccount(String account) throws SQLException {
				 account = "'" +  account + "'";
				 String sql = "select *from user_info where u_name=" + account;
				Statement statement = dao1().createStatement(); // ����һ�� Statement
				ResultSet b = statement.executeQuery(sql); // ִ�в�ѯ��sql��䣬���ҷ���һ��ResultSet��ѯ�����
				while (b.next()) // b.next()��ʾָ�벻������һ����ֻҪ��Ϊ�ռ���
				{
					return true;
				}
				b.close(); // �ر�ResultSet ����
				statement.close(); // �ر�Statement ����
				return false;
			}
			
			//�һ�����        r����ҵ����򷵻����롣���򷵻� ���ַ�
			public static String findAnser(Forget forget)  throws SQLException{
				String account = forget.getAccount();
				 String password = "";
				account = "'" +  account + "'";
				 String anser = "'"+forget.getAnswer()+"'";
				 String question = "'"+forget.getQuestion()+"'";
				 String sql = "select *from user_info where u_name=" + account+" and u_anser=" +anser +" and u_ques=" +question;
				Statement statement = dao1().createStatement(); // ����һ�� Statement
				ResultSet b = statement.executeQuery(sql); // ִ�в�ѯ��sql��䣬���ҷ���һ��ResultSet��ѯ�����
				while (b.next()) // b.next()��ʾָ�벻������һ����ֻҪ��Ϊ�ռ���
				{
					return b.getString(3);
				}
				b.close(); // �ر�ResultSet ����
				statement.close(); // �ر�Statement ����
				return password;
			}
			

			public static void main(String args[]) throws SQLException{
				
				Forget a = new Forget();
				a.setAnswer("answer");
//				System.out.println(findAnser( a, "fef"));
//				if( login("fef", "few") )
//					System.out.println("0");
				
//			if(Dao.addUserInfo("1111", "1", "u_answer", "u_question", "u_sign"," x","y"))
					System.out.println("fjoe");
//				//Dao.login("u_name", "u_password");
//				//Dao.queryU_table("1", "1");
//				createFriendsList(1);
			}

}
