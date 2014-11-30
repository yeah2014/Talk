package mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.RowSet;
import javax.swing.JOptionPane;

import com.sun.rowset.CachedRowSetImpl;

import common.*;

public class Dao {
	static String driver = "com.mysql.jdbc.Driver"; // ��������
	static String url = "jdbc:mysql://127.0.0.1:3306/chat"; // ����URL
	static String name = "root"; // �����û���
	static String password = "0000"; // ��������
	static Connection conn = null; // ���ݿ�����
	static String papa ;
    //String sql = "create table  user_info (u_id int auto_increment primary key,u_name varchar(20) ,u_pass varchar(20),u_ques varchar(40),u_anser varchar(40),u_sex varchar(4),u_sign varchar(60))";
	// ������

	public Dao(){
		papa=JOptionPane.showInputDialog("���ݿ����룿");
		Dao.password=papa;
	}
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
						int u_headicon=u.getHeadicon();
					    
						String sql = "insert into user_info(u_name,u_pass,u_ques,u_anser,u_sign,u_sex, u_nicname, u_headicon) values(?,?,?,?,?,?,?,?)"; // ����һ���������ݿ��SQL��䣬���еģ�������Ըı�ı���
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
						a.setInt(8, u_headicon);
						if (a.executeUpdate() != 0) // ִ�в������ݿ��SQl���
							
						{   
							Dao.createFriendsList(account);
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
			
			public static boolean isperson(String account)throws SQLException
			{
				String account1 = "'" +  account + "'";
				 String sql = "select *from user_info where u_name=" + account1;
				Statement statement = dao1().createStatement(); // ����һ�� Statement
				ResultSet b = statement.executeQuery(sql); // ִ�в�ѯ��sql��䣬���ҷ���һ��ResultSet��ѯ�����
				if(b.next()==false) return false;
				else return true;
			}
			// ��ѯ�û������Ƿ��Ѿ������˴��˺�  ���Գɹ�
			
			public static MessageType personal(String account)throws SQLException
			{
				MessageType message = new MessageType();
				String account1 = "'" +  account + "'";
				 String sql = "select *from user_info where u_name=" + account1;
				Statement statement = dao1().createStatement(); // ����һ�� Statement
				ResultSet b = statement.executeQuery(sql); // ִ�в�ѯ��sql��䣬���ҷ���һ��ResultSet��ѯ�����
				while(b.next())
				{
					message.Users.setId(b.getString(2));
					message.Users.setSex(b.getString(6));
					message.Users.setName(b.getString(8));
					message.Users.setSign(b.getString(7));
					message.Users.setHeadicon(b.getInt(9));
				}
				b.close();
				statement.close();
				return message;
			}
			public static ArrayList<String> whoesfriends(String account)throws SQLException
			{
				ArrayList<String> al = new ArrayList<String>();
				String sql2 = "select *from "+ account +"friendslist";
				Statement statement2 = dao1().createStatement(); // ����һ�� Statement
				ResultSet b2 = statement2.executeQuery(sql2);
				while(b2.next())
				{
					al.add(b2.getString(1));
				}
				b2.close();
				statement2.close();
				return al;
			}
			
			public static MessageType personInformation(String account) throws SQLException {			
				MessageType message = new MessageType();
				String account1 = "'" +  account + "'";
				String sql = "select *from user_info where u_name=" + account1;
				Statement statement = dao1().createStatement(); // ����һ�� Statement
				ResultSet b = statement.executeQuery(sql); // ִ�в�ѯ��sql��䣬���ҷ���һ��ResultSet��ѯ�����
				while (b.next()) // b.next()��ʾָ�벻������һ����ֻҪ��Ϊ�ռ���
				{
					message.Userdata .setId(b.getString(2));
					message.Userdata.setName(b.getString(8));
					message.Userdata.setSex(b.getString(6));
					message.Userdata.setSign(b.getString(7));
					message.Userdata.setHeadicon(b.getInt(9));
				}
				String sql2 = "select *from "+ account +"friendslist";
				Statement statement2 = dao1().createStatement(); // ����һ�� Statement
				ResultSet b2 = statement2.executeQuery(sql2);
				String sql3;
				Statement statement3;// ����һ�� Statement
				ResultSet b3;// ִ�в�ѯ��sql��䣬���ҷ���һ��ResultSet��ѯ�����
				ArrayList<Friends> friends=new ArrayList<Friends>();
				while(b2.next())
				{
					sql3= "select *from user_info where u_name="+b2.getString(1);
					statement3 = dao1().createStatement();
					b3 = statement3.executeQuery(sql3); 
					while (b3.next()) // b.next()��ʾָ�벻������һ����ֻҪ��Ϊ�ռ���
					{
						Friends f = new Friends();
						f.setFlag(b2.getInt(2));
						f.setId(b3.getString(2));
						f.setName(b3.getString(8));
						f.setFriendsign(b3.getString(7));
						f.setHeadicon(b3.getInt(9));
						friends.add(f);
					}
					message.Userdata.setFriend(friends);
				}
				b.close(); // �ر�ResultSet ����
				statement.close(); // �ر�Statement ����
				return message;
			}
						
		// ���������б� ���Գɹ�
		public static boolean createFriendsList(String u_name) {
			String sql = "create table " + u_name + "friendslist("
						+ "f_id varchar(20) , f_group int )";
			try {

					Statement stmt = dao1().createStatement();
					if (!stmt.execute(sql)) {
						System.out.println("�����б����ɹ�");
						return true;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return false;

		}
						
						
						// ���彫���ݲ������ݿ�ķ��� ���Գɹ�
						public static void ChaRu(String fromwho, String towho, String content, String time,String img)
								throws Exception {

							String sql = "insert into W_content(f_who,t_who,chat_content,data,img) values(?,?,?,?,?)"; // ����һ���������ݿ��SQL��䣬���еģ�������Ըı�ı���
							PreparedStatement a = dao1().prepareStatement(sql); // ��coon������һ��PreparedStatement����
							a.setString(1, fromwho); // ��sender������ֵ������һ����
							a.setString(2, towho); // ��getter������ֵ�����ڶ�����
							a.setString(3, content); // ��connent������ֵ������������
							a.setString(4, time); // ��Time������ֵ�������ĸ���
							a.setString(5,img);
							a.executeUpdate(); // ִ�в������ݿ��SQl���
							System.out.println("���ݿ����ɹ�");
							if (a != null) {
								a.close(); // �ر�a ����
							}

						}

						// ������Ҽ�¼ ���Գɹ�
						public static RowSet chazhao(String fromwho, String towho) throws Exception {
							fromwho = "'" + fromwho + "'";
							towho = "'" + towho + "'";

							String sql = "select *from w_content where (f_who=" + fromwho
									+ "and t_who=" + towho + ")or(f_who=" + towho + "and t_who="
									+ fromwho + ")"; // ����ִ�в�ѯ��sql���
							Statement statement = dao1().createStatement(); // ����һ�� Statement
							ResultSet bb =  statement.executeQuery(sql); // ִ�в�ѯ��sql��䣬���ҷ���һ��ResultSet��ѯ�����
							RowSet b=populate(bb);
//							while (b.next()) // b.next()��ʾָ�벻������һ����ֻҪ��Ϊ�ռ���
//								{
//							System.out.println(b.getString(2) + "\t" // b.getString(1)��ʾһ����ѯ����ĵ�1���ֶε�ֵ
//									+ b.getString(3) + "\t" // b.getString(2)��ʾһ����ѯ����ĵ�2���ֶε�ֵ
//									+ b.getString(4) + "\t" // b.getString(3)��ʾһ����ѯ����ĵ�3���ֶε�ֵ
//									+ b.getString(5)); // b.getString(4)��ʾһ����ѯ����ĵ�4���ֶε�ֵ
//						}
							
							return b;
						}
						public static RowSet populate(ResultSet rs) throws SQLException 
						{
						CachedRowSetImpl crs = new CachedRowSetImpl();
						crs.populate(rs);
						return crs;
						}
						
						// ��Ӻ��� ���Գɹ�
						public static boolean addfriends( String fromwho,String f_name,int group)
								throws SQLException {
							// fromwho = "'" + fromwho + "'";
							if(!Dao.isperson(f_name))
								return false;
							String sql = "insert into " + fromwho
									+ "friendslist (f_id,f_group) values(?,?)"; // ����һ���������ݿ��SQL��䣬���еģ�������Ըı�ı���
							PreparedStatement a;
							a = dao1().prepareStatement(sql);
							// ��coon������һ��PreparedStatement����
							a.setString(1, f_name); // ��u_name������ֵ������
							a.setInt(2, group);
							if (a.executeUpdate() != 0) // ִ�в������ݿ��SQl���
							{
								System.out.println("����ɹ�");
								return true;
							}
							a.close();// �ر�a ����
							return false;

						}
						// ɾ������ ���Գɹ�
						public static  boolean dropfriends(String fromwho,String f_name)
								throws SQLException {
							// fromwho = "'" + fromwho + "'";
							f_name = "'" + f_name + "'";
							String sql = "delete from  " + fromwho + "friendslist where f_id="
									+ f_name; // ����һ���������ݿ��SQL��䣬���еģ�������Ըı�ı���
							Statement a;
							a = dao1().createStatement();
							// ��coon������һ��PreparedStatement����

							a.execute(sql);
							System.out.println("ɾ�����ѳɹ�");
							a.close(); // �ر�a ����
							return true;

						}
						
						
						
			public static void main(String args[]) throws SQLException{
				
//				Forget a = new Forget();
//				a.setAnswer("answer");
				try {
//					Dao.chazhao("1111", "1");
					Dao.addfriends("123", "12",1);
//					Dao.dropfriends("kjfkejkfek", "456123");
//					Dao.personInformation("1");
//					System.out.println(Dao.isperson("1"));
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
//				System.out.println(findAnser( a, "fef"));
//				if( login("fef", "few") )
//					System.out.println("0");
//				try {
//					Dao.ChaRu("1111", "1", "u_answer", "u_question", "u_sign");
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				Dao.createFriendsList("123");
//			if(Dao.addUserInfo("1111", "1", "u_answer", "u_question", "u_sign"," x","y"))
//					System.out.println("fjoe");
//				//Dao.login("u_name", "u_password");
//				//Dao.queryU_table("1", "1");
//				createFriendsList(1);
			}

}
