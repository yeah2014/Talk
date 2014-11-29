package control;
import view.*;

import java.io.ObjectInputStream;
import java.net.*;

import javax.swing.JOptionPane;

import FriendsLists.FLists;
import common.*;
public class FlistThread extends Thread{
	public Socket s;

	public FlistThread(Socket s)
	{
		this.s=s;
	}
	public void run()
	{
		
		while(true)
		{
		try {
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			MessageType U = (MessageType)ois.readObject();
			//Analysis.isAnalysis(U);
			switch(U.getFlag())
			{
				case 2:
					WinChat wc = ManageThread.GetchatFromMap(U.Message.getTowho()+"->"+U.Message.getFromwho());
					if(wc!=null) 
					{
						System.out.println(U.Message.getFromwho()+"->"+U.Message.getTowho());
						wc.noedit.append(U.Message.getFromwho()+": "+U.Message.getMessage()+"\n");
					}
					else {
						FLists f=ManageThread.getlistfrommap(U.Message.getTowho());
						f.remindtofl(U);
					}
					break;
			
				case 7: 
					FLists f=ManageThread.getlistfrommap(U.Users.getId());
					f.remindtofl(U);
					break;
				case 8:
					
					ManageThread.getlistfrommap(U.getId()).addperson(U);
					break;
				case 9: 
					JOptionPane.showMessageDialog(null, "该好友不存在或好友不接受你的添加"); 
					break;
				
			}
		}
	 catch (Exception e) {
		e.printStackTrace();
	}
		}
	}
	
}
