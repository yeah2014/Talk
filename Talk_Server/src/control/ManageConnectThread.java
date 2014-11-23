package control;

import java.util.HashMap;
import java.io.ObjectOutputStream;
import java.net.*;

public class ManageConnectThread {
//	����һ����̬��hashmap
	public static HashMap<String, EachThread> hash = new HashMap<String , EachThread>();
	public static HashMap<Socket, String> hashs = new HashMap<Socket , String>();
	public static HashMap<String, ObjectOutputStream> hashss = new HashMap<String,ObjectOutputStream>();
	//�����̵߳�hashmap�ķ���
	public static void AddToMap(String s , EachThread et,ObjectOutputStream oos)
	{
		hash.put(s, et);
		hashs.put(et.s, s);
		hashss.put(s, oos);
	}
	//��hashmap��ȡ�̵߳ķ���
	public static EachThread GetFromMap(String s)
	{
		return (EachThread) hash.get(s);
	}
	public static String GetFromMap(Socket s)
	{
		return (String) hashs.get(s);
	}
	public static ObjectOutputStream GetOosFromMap(String s)
	{
		return (ObjectOutputStream) hashss.get(s);
	}
	public static void ReMoveMap(String s)
	{
		hash.remove(s);
		System.out.println("remove�ɹ�");
	}
	public static void ReMoveMap(Socket s)
	{
		hashs.remove(s);
		System.out.println("remove�ɹ�");
	}
}
