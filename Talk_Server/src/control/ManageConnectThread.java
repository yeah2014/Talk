package control;

import java.util.HashMap;
import java.io.ObjectOutputStream;
import java.net.*;

public class ManageConnectThread {
//	����һ����̬��hashmap
	public static HashMap<String, EachThread> hash = new HashMap<String , EachThread>();
	//�����̵߳�hashmap�ķ���
	public static void AddToMap(String s , EachThread et)
	{
		hash.put(s, et);
	}
	//��hashmap��ȡ�̵߳ķ���
	public static EachThread GetFromMap(String s)
	{
		return (EachThread) hash.get(s);
	}
	public static void ReMoveMap(String s)
	{
		hash.remove(s);
		System.out.println("remove�ɹ�");
	}
}
