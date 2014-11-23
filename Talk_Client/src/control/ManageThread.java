package control;
import java.util.HashMap;

import view.*;
public class ManageThread {
	public static HashMap<String,WinChat> hash = new HashMap<String,WinChat>();
	
	public static void AddToMap(String s ,WinChat wc)
	{
		hash.put(s, wc);
	}
	
	public static WinChat GetFromMap(String s)
	{
		return (WinChat) hash.get(s);
		
	}
}
