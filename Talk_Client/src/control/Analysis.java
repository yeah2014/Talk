package control;
import FriendsLists.FLists;
import common.*;
import view.*;
public class Analysis {
	public Analysis()
	{
		
	}
	
	public static void isAnalysis(MessageType U)
	{
		WinChat wc;
		switch(U.getFlag())
		{
			case 2: 
				
				wc =ManageThread.GetFromMap(U.Message.getFromwho());
				if(wc != null)
					wc.addtext(U.Message.getMessage());
				else 
				{
					//��ʾ��Ϣ
					
				}
				break;
			case 3://ͼƬ
			case 4://���º���
				
		}
	}
}
