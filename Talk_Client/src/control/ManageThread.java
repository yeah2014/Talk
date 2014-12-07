/*
 * 管理线程，
 * 3个哈希表：
 * hash 用于储存每个聊天窗口
 * hashs 用于得到后台接收器，主要为了得到其中的socket
 * hashss 仅仅用于得到当前这个好友列表，操作好友上下线，消息提醒等等功能
 */
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
	public static void removechat(String s)
	{
		hash.remove(s);
		
	}
}
