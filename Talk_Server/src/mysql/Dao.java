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
	static String driver = "com.mysql.jdbc.Driver"; // 定义驱动
	static String url = "jdbc:mysql://127.0.0.1:3306/chat"; // 定义URL
	static String name = "root"; // 定义用户名
	static String password = "0000"; // 定义密码
	static Connection conn = null; // 数据库连接
	static String papa ;
    //String sql = "create table  user_info (u_id int auto_increment primary key,u_name varchar(20) ,u_pass varchar(20),u_ques varchar(40),u_anser varchar(40),u_sex varchar(4),u_sign varchar(60))";
	// 构造器

	public Dao(){
		papa=JOptionPane.showInputDialog("数据库密码？");
		Dao.password=papa;
	}
	public static  Connection    dao1() {
		try {
			Class.forName(driver); // 加载数据库
			conn = DriverManager.getConnection(url, name, password);// 连接数据库
			
			//return conn;
			//ServerView.appendtoserver("连接数据库成功!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据库连接异常，或者本软件已经运行。");
			System.exit(0);
		}
		return conn;
	}
	
	// 登陆 测试成功
	public static  boolean login(String account, String password) throws SQLException {
		account = "'" + account + "'";
		password = "'" +password + "'";
		String sql = "select *from user_info where u_name=" + account
				+ "and u_pass=" +password; // 定义执行查询的sql语句
		Statement statement = dao1().createStatement(); // 创建一个 Statement
		ResultSet b = statement.executeQuery(sql); // 执行查询的sql语句，并且返回一个ResultSet查询结果集
		while (b.next()) // b.next()表示指针不断往下一个，只要不为空即可
		{
			System.out.println("登陆成功");
			return true;
		}
		b.close(); // 关闭ResultSet 对象
		statement.close(); // 关闭Statement 对象
		System.out.println("登陆失败");
		return false;
	}
	
	//   注册    添加用户到用户数据表 并且创建登录人的好友列表 测试成功
				public static   boolean addUserInfo(Users u)throws SQLException {
						String account=u.getId();
						String password=u.getPassword();
						String u_answer=u.getForget().getAnswer();
						String u_question=u.getForget().getQuestion();
						String u_sign=u.getSign();
						String u_sex=u.getSex();
						String u_nicname=u.getName();
						int u_headicon=u.getHeadicon();
					    
						String sql = "insert into user_info(u_name,u_pass,u_ques,u_anser,u_sign,u_sex, u_nicname, u_headicon) values(?,?,?,?,?,?,?,?)"; // 定义一个插入数据库的SQL语句，其中的？代表可以改变的变量
						PreparedStatement a;
						a = dao1().prepareStatement(sql);
						// 用coon来创建一个PreparedStatement对象
						a.setString(1, account); // 将u_name变量的值传给？
						a.setString(2, password); // 将u_password变量的值传给？
						a.setString(3, u_question); // 将u_answer变量的值传给？
						a.setString(4, u_answer); // 将u_question变量的值传给？
						a.setString(5, u_sign); // 将u_sign变量的值传给？
						a.setString(6, u_sex); // 将u-sex变量的值传给？
						a.setString(7, u_nicname); // 将u-sex变量的值传给？
						a.setInt(8, u_headicon);
						if (a.executeUpdate() != 0) // 执行插入数据库的SQl语句
							
						{   
							Dao.createFriendsList(account);
							System.out.println("插入成功");
							return true;
						}
						a.close(); // 关闭a 对象
						return false;
					
				}
				
	
	
	// 查询用户表中是否已经存在了此账号  测试成功
			public static boolean queryAccount(String account) throws SQLException {
				 account = "'" +  account + "'";
				 String sql = "select *from user_info where u_name=" + account;
				Statement statement = dao1().createStatement(); // 创建一个 Statement
				ResultSet b = statement.executeQuery(sql); // 执行查询的sql语句，并且返回一个ResultSet查询结果集
				while (b.next()) // b.next()表示指针不断往下一个，只要不为空即可
				{
					return true;
				}
				b.close(); // 关闭ResultSet 对象
				statement.close(); // 关闭Statement 对象
				return false;
			}
			
			//找回密码        r如果找到，则返回密码。否则返回 空字符
			public static String findAnser(Forget forget)  throws SQLException{
				String account = forget.getAccount();
				 String password = "";
				account = "'" +  account + "'";
				 String anser = "'"+forget.getAnswer()+"'";
				 String question = "'"+forget.getQuestion()+"'";
				 String sql = "select *from user_info where u_name=" + account+" and u_anser=" +anser +" and u_ques=" +question;
				Statement statement = dao1().createStatement(); // 创建一个 Statement
				ResultSet b = statement.executeQuery(sql); // 执行查询的sql语句，并且返回一个ResultSet查询结果集
				while (b.next()) // b.next()表示指针不断往下一个，只要不为空即可
				{
					return b.getString(3);
				}
				b.close(); // 关闭ResultSet 对象
				statement.close(); // 关闭Statement 对象
				return password;
			}
			
			public static boolean isperson(String account)throws SQLException
			{
				String account1 = "'" +  account + "'";
				 String sql = "select *from user_info where u_name=" + account1;
				Statement statement = dao1().createStatement(); // 创建一个 Statement
				ResultSet b = statement.executeQuery(sql); // 执行查询的sql语句，并且返回一个ResultSet查询结果集
				if(b.next()==false) return false;
				else return true;
			}
			// 查询用户表中是否已经存在了此账号  测试成功
			
			public static MessageType personal(String account)throws SQLException
			{
				MessageType message = new MessageType();
				String account1 = "'" +  account + "'";
				 String sql = "select *from user_info where u_name=" + account1;
				Statement statement = dao1().createStatement(); // 创建一个 Statement
				ResultSet b = statement.executeQuery(sql); // 执行查询的sql语句，并且返回一个ResultSet查询结果集
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
				Statement statement2 = dao1().createStatement(); // 创建一个 Statement
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
				Statement statement = dao1().createStatement(); // 创建一个 Statement
				ResultSet b = statement.executeQuery(sql); // 执行查询的sql语句，并且返回一个ResultSet查询结果集
				while (b.next()) // b.next()表示指针不断往下一个，只要不为空即可
				{
					message.Userdata .setId(b.getString(2));
					message.Userdata.setName(b.getString(8));
					message.Userdata.setSex(b.getString(6));
					message.Userdata.setSign(b.getString(7));
					message.Userdata.setHeadicon(b.getInt(9));
				}
				String sql2 = "select *from "+ account +"friendslist";
				Statement statement2 = dao1().createStatement(); // 创建一个 Statement
				ResultSet b2 = statement2.executeQuery(sql2);
				String sql3;
				Statement statement3;// 创建一个 Statement
				ResultSet b3;// 执行查询的sql语句，并且返回一个ResultSet查询结果集
				ArrayList<Friends> friends=new ArrayList<Friends>();
				while(b2.next())
				{
					sql3= "select *from user_info where u_name="+b2.getString(1);
					statement3 = dao1().createStatement();
					b3 = statement3.executeQuery(sql3); 
					while (b3.next()) // b.next()表示指针不断往下一个，只要不为空即可
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
				b.close(); // 关闭ResultSet 对象
				statement.close(); // 关闭Statement 对象
				return message;
			}
						
		// 创建好友列表 测试成功
		public static boolean createFriendsList(String u_name) {
			String sql = "create table " + u_name + "friendslist("
						+ "f_id varchar(20) , f_group int )";
			try {

					Statement stmt = dao1().createStatement();
					if (!stmt.execute(sql)) {
						System.out.println("好友列表构建成功");
						return true;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return false;

		}
						
						
						// 定义将数据插入数据库的方法 测试成功
						public static void ChaRu(String fromwho, String towho, String content, String time,String img)
								throws Exception {

							String sql = "insert into W_content(f_who,t_who,chat_content,data,img) values(?,?,?,?,?)"; // 定义一个插入数据库的SQL语句，其中的？代表可以改变的变量
							PreparedStatement a = dao1().prepareStatement(sql); // 用coon来创建一个PreparedStatement对象
							a.setString(1, fromwho); // 将sender变量的值传给第一个？
							a.setString(2, towho); // 将getter变量的值传给第二个？
							a.setString(3, content); // 将connent变量的值传给第三个？
							a.setString(4, time); // 将Time变量的值传给第四个？
							a.setString(5,img);
							a.executeUpdate(); // 执行插入数据库的SQl语句
							System.out.println("数据库插入成功");
							if (a != null) {
								a.close(); // 关闭a 对象
							}

						}

						// 定义查找记录 测试成功
						public static RowSet chazhao(String fromwho, String towho) throws Exception {
							fromwho = "'" + fromwho + "'";
							towho = "'" + towho + "'";

							String sql = "select *from w_content where (f_who=" + fromwho
									+ "and t_who=" + towho + ")or(f_who=" + towho + "and t_who="
									+ fromwho + ")"; // 定义执行查询的sql语句
							Statement statement = dao1().createStatement(); // 创建一个 Statement
							ResultSet bb =  statement.executeQuery(sql); // 执行查询的sql语句，并且返回一个ResultSet查询结果集
							RowSet b=populate(bb);
//							while (b.next()) // b.next()表示指针不断往下一个，只要不为空即可
//								{
//							System.out.println(b.getString(2) + "\t" // b.getString(1)表示一条查询结果的第1个字段的值
//									+ b.getString(3) + "\t" // b.getString(2)表示一条查询结果的第2个字段的值
//									+ b.getString(4) + "\t" // b.getString(3)表示一条查询结果的第3个字段的值
//									+ b.getString(5)); // b.getString(4)表示一条查询结果的第4个字段的值
//						}
							
							return b;
						}
						public static RowSet populate(ResultSet rs) throws SQLException 
						{
						CachedRowSetImpl crs = new CachedRowSetImpl();
						crs.populate(rs);
						return crs;
						}
						
						// 添加好友 测试成功
						public static boolean addfriends( String fromwho,String f_name,int group)
								throws SQLException {
							// fromwho = "'" + fromwho + "'";
							if(!Dao.isperson(f_name))
								return false;
							String sql = "insert into " + fromwho
									+ "friendslist (f_id,f_group) values(?,?)"; // 定义一个插入数据库的SQL语句，其中的？代表可以改变的变量
							PreparedStatement a;
							a = dao1().prepareStatement(sql);
							// 用coon来创建一个PreparedStatement对象
							a.setString(1, f_name); // 将u_name变量的值传给？
							a.setInt(2, group);
							if (a.executeUpdate() != 0) // 执行插入数据库的SQl语句
							{
								System.out.println("插入成功");
								return true;
							}
							a.close();// 关闭a 对象
							return false;

						}
						// 删除好友 测试成功
						public static  boolean dropfriends(String fromwho,String f_name)
								throws SQLException {
							// fromwho = "'" + fromwho + "'";
							f_name = "'" + f_name + "'";
							String sql = "delete from  " + fromwho + "friendslist where f_id="
									+ f_name; // 定义一个插入数据库的SQL语句，其中的？代表可以改变的变量
							Statement a;
							a = dao1().createStatement();
							// 用coon来创建一个PreparedStatement对象

							a.execute(sql);
							System.out.println("删除好友成功");
							a.close(); // 关闭a 对象
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
