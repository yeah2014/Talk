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
	private static String driver = "com.mysql.jdbc.Driver"; // 定义驱动
	private static String url = "jdbc:mysql://127.0.0.1:3306/chat"; // 定义URL
	private static String name = "root"; // 定义用户名
	private static String password = "0000"; // 定义密码
	private static Connection conn = null; // 数据库连接
	
    //String sql = "create table  user_info (u_id int auto_increment primary key,u_name varchar(20) ,u_pass varchar(20),u_ques varchar(40),u_anser varchar(40),u_sex varchar(4),u_sign varchar(60))";
	// 构造器
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
						
					    
						String sql = "insert into user_info(u_name,u_pass,u_ques,u_anser,u_sign,u_sex, u_nicname) values(?,?,?,?,?,?,?)"; // 定义一个插入数据库的SQL语句，其中的？代表可以改变的变量
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
						if (a.executeUpdate() != 0) // 执行插入数据库的SQl语句
						{   
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
