package control;

import java.util.HashMap;
import java.io.ObjectOutputStream;
import java.net.*;

public class ManageConnectThread {
//	创建一个静态的hashmap
	public static HashMap<String, EachThread> hash = new HashMap<String , EachThread>();
	public static HashMap<Socket, String> hashs = new HashMap<Socket , String>();
	public static HashMap<String, ObjectOutputStream> hashss = new HashMap<String,ObjectOutputStream>();
	//加入线程到hashmap的方法
	public static void AddToMap(String s , EachThread et,ObjectOutputStream oos)
	{
		hash.put(s, et);
		hashs.put(et.s, s);
		hashss.put(s, oos);
	}
	//从hashmap提取线程的方法
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
		System.out.println("remove成功");
	}
	public static void ReMoveMap(Socket s)
	{
		hashs.remove(s);
		System.out.println("remove成功");
	}
}
