package control;

import java.util.HashMap;

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
	public static EachThread ReMoveMap(String s)
	{
		System.out.println("remove�ɹ�");
		return hash.remove(s);
		
	}
}
