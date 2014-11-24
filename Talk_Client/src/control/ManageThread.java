package control;
import java.util.HashMap;

import FriendsLists.FLists;
import view.*;
public class ManageThread {
	public static HashMap<String,WinChat> hash = new HashMap<String,WinChat>();
	public static HashMap<String,FlistThread> hashs = new HashMap<String, FlistThread>();
	public static HashMap<String,FLists> hashss = new HashMap<String, FLists>();
	public static void AddChatToMap(String s ,WinChat wc)
	{
		hash.put(s, wc);
	}
	public static void AddThreadtoMap(String s,FlistThread ft)
	{
		hashs.put(s, ft);
	}
	public static void AddFlisttomap(String s,FLists f)
	{
		hashss.put(s, f);
	}
	public static FLists getlistfrommap(String s)
	{
		return (FLists) hashss.get(s);
	}
	public static WinChat GetchatFromMap(String s)
	{
		return (WinChat) hash.get(s);
	}
	public static FlistThread Getthreadfrommap(String s)
	{
		return (FlistThread) hashs.get(s);
	}
}
