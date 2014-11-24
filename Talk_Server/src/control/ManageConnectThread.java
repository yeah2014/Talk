package control;

import java.util.HashMap;
import java.io.ObjectOutputStream;
import java.net.*;

public class ManageConnectThread {
//	创建一个静态的hashmap
	public static HashMap<String, EachThread> hash = new HashMap<String , EachThread>();
	//加入线程到hashmap的方法
	public static void AddToMap(String s , EachThread et)
	{
		hash.put(s, et);
	}
	//从hashmap提取线程的方法
	public static EachThread GetFromMap(String s)
	{
		return (EachThread) hash.get(s);
	}
	public static void ReMoveMap(String s)
	{
		hash.remove(s);
		System.out.println("remove成功");
	}
}
