package mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import view.ServerView;
import javax.swing.JOptionPane;

public class Dao {
	private static String driver = "com.mysql.jdbc.Driver"; // 定义驱动
	private static String url = "jdbc:mysql://127.0.0.1:3306/chat"; // 定义URL
	private static String name = "root"; // 定义用户名
	private static String password = "0000"; // 定义密码
	private static Connection conn = null; // 数据库连接

	// 构造器
	public Dao() {
		try {
			Class.forName(driver); // 加载数据库
			conn = DriverManager.getConnection(url, name, password);// 连接数据库
			ServerView.appendtoserver("连接数据库成功!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据库连接异常，或者本软件已经运行。");
			System.exit(0);
		}
	}

	// 添加用户到用户数据表 并且创建登录人的好友列表 测试成功
	public boolean insertU_table(String u_name, String u_password,
			String u_answer, String u_question, String u_sign, String u_sex)
			throws SQLException {
		// 插入之前先判断是否存在该用户名了
		if (queryU_table(u_name)) {
			System.out.println("已经存在该用户名");
			return false;
		} else {
			String sql = "insert into u_table(u_name,u_password,u_answer,u_question,u_sign,u_sex) values(?,?,?,?,?,?)"; // 定义一个插入数据库的SQL语句，其中的？代表可以改变的变量
			PreparedStatement a;
			a = conn.prepareStatement(sql);
			// 用coon来创建一个PreparedStatement对象
			a.setString(1, u_name); // 将u_name变量的值传给？
			a.setString(2, u_password); // 将u_password变量的值传给？
			a.setString(3, u_answer); // 将u_answer变量的值传给？
			a.setString(4, u_question); // 将u_question变量的值传给？
			a.setString(5, u_sign); // 将u_sign变量的值传给？
			a.setString(6, u_sex); // 将u-sex变量的值传给？
			if (a.executeUpdate() != 0) // 执行插入数据库的SQl语句
			{
				createFriendsList(u_name);
				System.out.println("插入成功");
				return true;
			}
			a.close(); // 关闭a 对象
			return false;
		}
	}

	// 查询用户表中是否已经存在了此用户名 测试成功
	public boolean queryU_table(String u_name) throws SQLException {
		u_name = "'" + u_name + "'";
		String sql = "select *from u_table where u_name=" + u_name; // 定义执行查询的sql语句
		Statement statement = conn.createStatement(); // 创建一个 Statement
		ResultSet b = statement.executeQuery(sql); // 执行查询的sql语句，并且返回一个ResultSet查询结果集
		while (b.next()) // b.next()表示指针不断往下一个，只要不为空即可
		{
			return true;
		}
		b.close(); // 关闭ResultSet 对象
		statement.close(); // 关闭Statement 对象
		return false;
	}

	// 登陆 测试成功
	public boolean login(String u_name, String u_password) throws SQLException {
		u_name = "'" + u_name + "'";
		u_password = "'" + u_password + "'";
		String sql = "select *from u_table where u_name=" + u_name
				+ "and u_password=" + u_password; // 定义执行查询的sql语句
		Statement statement = conn.createStatement(); // 创建一个 Statement
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

	// 创建好友列表 测试成功
	public boolean createFriendsList(String u_name) {
		String sql = "create table " + u_name + "friendslist("
				+ "f_id int auto_increment primary key,"
				+ "f_name varchar(20) unique," + "zhuangtai varchar(5))";
		try {

			Statement stmt = conn.createStatement();
			if (!stmt.execute(sql)) {
				System.out.println("好友列表构建成功");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	// 添加好友 测试成功
	public boolean addfriends(String f_name, String fromwho)
			throws SQLException {
		// fromwho = "'" + fromwho + "'";
		String sql = "insert into " + fromwho
				+ "friendslist (f_name) values(?)"; // 定义一个插入数据库的SQL语句，其中的？代表可以改变的变量
		PreparedStatement a;
		a = conn.prepareStatement(sql);
		// 用coon来创建一个PreparedStatement对象
		a.setString(1, f_name); // 将u_name变量的值传给？

		if (a.executeUpdate() != 0) // 执行插入数据库的SQl语句
		{
			System.out.println("插入成功");
			return true;
		}
		a.close(); // 关闭a 对象
		return false;

	}

	// 删除好友 测试成功
	public boolean dropfriends(String f_name, String fromwho)
			throws SQLException {
		// fromwho = "'" + fromwho + "'";
		f_name = "'" + f_name + "'";
		String sql = "delete from  " + fromwho + "friendslist where f_name="
				+ f_name; // 定义一个插入数据库的SQL语句，其中的？代表可以改变的变量
		Statement a;
		a = conn.createStatement();
		// 用coon来创建一个PreparedStatement对象

		a.execute(sql);
		System.out.println("删除好友成功");
		a.close(); // 关闭a 对象
		return true;

	}

	// 定义将数据插入数据库的方法 测试成功
	public void ChaRu(String fromwho, String towho, String content, String time)
			throws Exception {

		String sql = "insert into wechat(fromwho,towho,content,time) values(?,?,?,?)"; // 定义一个插入数据库的SQL语句，其中的？代表可以改变的变量
		PreparedStatement a = conn.prepareStatement(sql); // 用coon来创建一个PreparedStatement对象
		a.setString(1, fromwho); // 将sender变量的值传给第一个？
		a.setString(2, towho); // 将getter变量的值传给第二个？
		a.setString(3, content); // 将connent变量的值传给第三个？
		a.setString(4, time); // 将Time变量的值传给第四个？
		a.executeUpdate(); // 执行插入数据库的SQl语句
		System.out.println("数据库插入成功");
		if (a != null) {
			a.close(); // 关闭a 对象
		}

	}

	// 定义查找记录 测试成功
	public void chazhao(String fromwho, String towho) throws Exception {
		fromwho = "'" + fromwho + "'";
		towho = "'" + towho + "'";

		String sql = "select *from wechat where (fromwho=" + fromwho
				+ "and towho=" + towho + ")or(fromwho=" + towho + "and towho="
				+ fromwho + ")"; // 定义执行查询的sql语句
		Statement statement = conn.createStatement(); // 创建一个 Statement
		ResultSet b = statement.executeQuery(sql); // 执行查询的sql语句，并且返回一个ResultSet查询结果集
		while (b.next()) // b.next()表示指针不断往下一个，只要不为空即可
		{
			System.out.println(b.getString(2) + "\t" // b.getString(1)表示一条查询结果的第1个字段的值
					+ b.getString(3) + "\t" // b.getString(2)表示一条查询结果的第2个字段的值
					+ b.getString(4) + "\t" // b.getString(3)表示一条查询结果的第3个字段的值
					+ b.getString(5)); // b.getString(4)表示一条查询结果的第4个字段的值
		}

		if (b != null) {
			b.close(); // 关闭ResultSet 对象
		}
		if (statement != null) {
			statement.close(); // 关闭Statement 对象
		}

	}

	// 返回设置密码的问题 和答案 测试成功
	public boolean findAnswer(String u_name) throws SQLException {
		u_name = "'" + u_name + "'";
		String sql = "select *from u_table where u_name=" + u_name; // 定义执行查询的sql语句
		Statement statement = conn.createStatement(); // 创建一个 Statement
		ResultSet b = statement.executeQuery(sql); // 执行查询的sql语句，并且返回一个ResultSet查询结果集
		while (b.next()) // b.next()表示指针不断往下一个，只要不为空即可
		{
			System.out.println(b.getString(6) + "\t" + //
					// b.getString(1)表示一条查询结果的第1个字段的值
					b.getString(7)); // b.getString(4)表示一条查询结果的第4个字段的值
			return true;
		}

		if (b != null) {
			b.close(); // 关闭ResultSet 对象
		}
		if (statement != null) {
			statement.close(); // 关闭Statement 对象
		}

		return false;

	}

	// 重新设置密码 测试成功
	public boolean setPassword(String u_password, String u_name) {
		u_password = "'" + u_password + "'";
		u_name = "'" + u_name + "'";
		String sql = "update u_table set u_password =" + u_password
				+ " where u_name=" + u_name;
		try {

			Statement stmt = conn.createStatement();
			if (!stmt.execute(sql)) {
				System.out.println("密码重置成功");
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return false;
	}

//	public static void main(String args[]) throws Exception {
//		Dao a = new Dao();
//		 System.out.println(a.insertU_table("罗家全", "luojiaquan", "罗毛线",
//		 "我爸叫什么",
//		 "fef", "男"));
//		 boolean t = a.queryU_table("hfie");
//		 System.out.println(t);
//		 a.createFriendsList("唐1ju");
//		 try {
//		 a.ChaRu("毛线", "唐句早", "dfdf", "2013");
//		 } catch (Exception e) {
//		 // TODO 自动生成的 catch 块
//		 e.printStackTrace();
//		 }
//		 a.addfriends("张哄哄", "唐居造");
//		 a.login("唐居造", "tangjuzao");
//		 a.dropfriends("张哄哄", "唐居造");
//		 a.findAnswer("唐居造");
//		 a.setPassword("tang", "唐居造");
//	}
}
