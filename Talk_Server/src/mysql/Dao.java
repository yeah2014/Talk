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
	private static String driver = "com.mysql.jdbc.Driver"; // ��������
	private static String url = "jdbc:mysql://127.0.0.1:3306/chat"; // ����URL
	private static String name = "root"; // �����û���
	private static String password = "0000"; // ��������
	private static Connection conn = null; // ���ݿ�����

	// ������
	public Dao() {
		try {
			Class.forName(driver); // �������ݿ�
			conn = DriverManager.getConnection(url, name, password);// �������ݿ�
			ServerView.appendtoserver("�������ݿ�ɹ�!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "���ݿ������쳣�����߱�����Ѿ����С�");
			System.exit(0);
		}
	}

	// ����û����û����ݱ� ���Ҵ�����¼�˵ĺ����б� ���Գɹ�
	public boolean insertU_table(String u_name, String u_password,
			String u_answer, String u_question, String u_sign, String u_sex)
			throws SQLException {
		// ����֮ǰ���ж��Ƿ���ڸ��û�����
		if (queryU_table(u_name)) {
			System.out.println("�Ѿ����ڸ��û���");
			return false;
		} else {
			String sql = "insert into u_table(u_name,u_password,u_answer,u_question,u_sign,u_sex) values(?,?,?,?,?,?)"; // ����һ���������ݿ��SQL��䣬���еģ�������Ըı�ı���
			PreparedStatement a;
			a = conn.prepareStatement(sql);
			// ��coon������һ��PreparedStatement����
			a.setString(1, u_name); // ��u_name������ֵ������
			a.setString(2, u_password); // ��u_password������ֵ������
			a.setString(3, u_answer); // ��u_answer������ֵ������
			a.setString(4, u_question); // ��u_question������ֵ������
			a.setString(5, u_sign); // ��u_sign������ֵ������
			a.setString(6, u_sex); // ��u-sex������ֵ������
			if (a.executeUpdate() != 0) // ִ�в������ݿ��SQl���
			{
				createFriendsList(u_name);
				System.out.println("����ɹ�");
				return true;
			}
			a.close(); // �ر�a ����
			return false;
		}
	}

	// ��ѯ�û������Ƿ��Ѿ������˴��û��� ���Գɹ�
	public boolean queryU_table(String u_name) throws SQLException {
		u_name = "'" + u_name + "'";
		String sql = "select *from u_table where u_name=" + u_name; // ����ִ�в�ѯ��sql���
		Statement statement = conn.createStatement(); // ����һ�� Statement
		ResultSet b = statement.executeQuery(sql); // ִ�в�ѯ��sql��䣬���ҷ���һ��ResultSet��ѯ�����
		while (b.next()) // b.next()��ʾָ�벻������һ����ֻҪ��Ϊ�ռ���
		{
			return true;
		}
		b.close(); // �ر�ResultSet ����
		statement.close(); // �ر�Statement ����
		return false;
	}

	// ��½ ���Գɹ�
	public boolean login(String u_name, String u_password) throws SQLException {
		u_name = "'" + u_name + "'";
		u_password = "'" + u_password + "'";
		String sql = "select *from u_table where u_name=" + u_name
				+ "and u_password=" + u_password; // ����ִ�в�ѯ��sql���
		Statement statement = conn.createStatement(); // ����һ�� Statement
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

	// ���������б� ���Գɹ�
	public boolean createFriendsList(String u_name) {
		String sql = "create table " + u_name + "friendslist("
				+ "f_id int auto_increment primary key,"
				+ "f_name varchar(20) unique," + "zhuangtai varchar(5))";
		try {

			Statement stmt = conn.createStatement();
			if (!stmt.execute(sql)) {
				System.out.println("�����б����ɹ�");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	// ��Ӻ��� ���Գɹ�
	public boolean addfriends(String f_name, String fromwho)
			throws SQLException {
		// fromwho = "'" + fromwho + "'";
		String sql = "insert into " + fromwho
				+ "friendslist (f_name) values(?)"; // ����һ���������ݿ��SQL��䣬���еģ�������Ըı�ı���
		PreparedStatement a;
		a = conn.prepareStatement(sql);
		// ��coon������һ��PreparedStatement����
		a.setString(1, f_name); // ��u_name������ֵ������

		if (a.executeUpdate() != 0) // ִ�в������ݿ��SQl���
		{
			System.out.println("����ɹ�");
			return true;
		}
		a.close(); // �ر�a ����
		return false;

	}

	// ɾ������ ���Գɹ�
	public boolean dropfriends(String f_name, String fromwho)
			throws SQLException {
		// fromwho = "'" + fromwho + "'";
		f_name = "'" + f_name + "'";
		String sql = "delete from  " + fromwho + "friendslist where f_name="
				+ f_name; // ����һ���������ݿ��SQL��䣬���еģ�������Ըı�ı���
		Statement a;
		a = conn.createStatement();
		// ��coon������һ��PreparedStatement����

		a.execute(sql);
		System.out.println("ɾ�����ѳɹ�");
		a.close(); // �ر�a ����
		return true;

	}

	// ���彫���ݲ������ݿ�ķ��� ���Գɹ�
	public void ChaRu(String fromwho, String towho, String content, String time)
			throws Exception {

		String sql = "insert into wechat(fromwho,towho,content,time) values(?,?,?,?)"; // ����һ���������ݿ��SQL��䣬���еģ�������Ըı�ı���
		PreparedStatement a = conn.prepareStatement(sql); // ��coon������һ��PreparedStatement����
		a.setString(1, fromwho); // ��sender������ֵ������һ����
		a.setString(2, towho); // ��getter������ֵ�����ڶ�����
		a.setString(3, content); // ��connent������ֵ������������
		a.setString(4, time); // ��Time������ֵ�������ĸ���
		a.executeUpdate(); // ִ�в������ݿ��SQl���
		System.out.println("���ݿ����ɹ�");
		if (a != null) {
			a.close(); // �ر�a ����
		}

	}

	// ������Ҽ�¼ ���Գɹ�
	public void chazhao(String fromwho, String towho) throws Exception {
		fromwho = "'" + fromwho + "'";
		towho = "'" + towho + "'";

		String sql = "select *from wechat where (fromwho=" + fromwho
				+ "and towho=" + towho + ")or(fromwho=" + towho + "and towho="
				+ fromwho + ")"; // ����ִ�в�ѯ��sql���
		Statement statement = conn.createStatement(); // ����һ�� Statement
		ResultSet b = statement.executeQuery(sql); // ִ�в�ѯ��sql��䣬���ҷ���һ��ResultSet��ѯ�����
		while (b.next()) // b.next()��ʾָ�벻������һ����ֻҪ��Ϊ�ռ���
		{
			System.out.println(b.getString(2) + "\t" // b.getString(1)��ʾһ����ѯ����ĵ�1���ֶε�ֵ
					+ b.getString(3) + "\t" // b.getString(2)��ʾһ����ѯ����ĵ�2���ֶε�ֵ
					+ b.getString(4) + "\t" // b.getString(3)��ʾһ����ѯ����ĵ�3���ֶε�ֵ
					+ b.getString(5)); // b.getString(4)��ʾһ����ѯ����ĵ�4���ֶε�ֵ
		}

		if (b != null) {
			b.close(); // �ر�ResultSet ����
		}
		if (statement != null) {
			statement.close(); // �ر�Statement ����
		}

	}

	// ����������������� �ʹ� ���Գɹ�
	public boolean findAnswer(String u_name) throws SQLException {
		u_name = "'" + u_name + "'";
		String sql = "select *from u_table where u_name=" + u_name; // ����ִ�в�ѯ��sql���
		Statement statement = conn.createStatement(); // ����һ�� Statement
		ResultSet b = statement.executeQuery(sql); // ִ�в�ѯ��sql��䣬���ҷ���һ��ResultSet��ѯ�����
		while (b.next()) // b.next()��ʾָ�벻������һ����ֻҪ��Ϊ�ռ���
		{
			System.out.println(b.getString(6) + "\t" + //
					// b.getString(1)��ʾһ����ѯ����ĵ�1���ֶε�ֵ
					b.getString(7)); // b.getString(4)��ʾһ����ѯ����ĵ�4���ֶε�ֵ
			return true;
		}

		if (b != null) {
			b.close(); // �ر�ResultSet ����
		}
		if (statement != null) {
			statement.close(); // �ر�Statement ����
		}

		return false;

	}

	// ������������ ���Գɹ�
	public boolean setPassword(String u_password, String u_name) {
		u_password = "'" + u_password + "'";
		u_name = "'" + u_name + "'";
		String sql = "update u_table set u_password =" + u_password
				+ " where u_name=" + u_name;
		try {

			Statement stmt = conn.createStatement();
			if (!stmt.execute(sql)) {
				System.out.println("�������óɹ�");
				return true;
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return false;
	}

//	public static void main(String args[]) throws Exception {
//		Dao a = new Dao();
//		 System.out.println(a.insertU_table("�޼�ȫ", "luojiaquan", "��ë��",
//		 "�Ұֽ�ʲô",
//		 "fef", "��"));
//		 boolean t = a.queryU_table("hfie");
//		 System.out.println(t);
//		 a.createFriendsList("��1ju");
//		 try {
//		 a.ChaRu("ë��", "�ƾ���", "dfdf", "2013");
//		 } catch (Exception e) {
//		 // TODO �Զ����ɵ� catch ��
//		 e.printStackTrace();
//		 }
//		 a.addfriends("�ź��", "�ƾ���");
//		 a.login("�ƾ���", "tangjuzao");
//		 a.dropfriends("�ź��", "�ƾ���");
//		 a.findAnswer("�ƾ���");
//		 a.setPassword("tang", "�ƾ���");
//	}
}
