package control;
import view.*;

import java.awt.Font;
import java.io.ObjectInputStream;
import java.net.*;

import javax.swing.JOptionPane;

import FriendsLists.FLists;
import common.*;
public class FlistThread extends Thread{
	public Socket s;
	FLists f;
	public boolean run = true;
	public FlistThread(Socket s)
	{
		this.s=s;
	}
	public void run()
	{
		
		while(run)
		{
		try {
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			MessageType U = (MessageType)ois.readObject();
			switch(U.getFlag())
			{
				case 2:
					WinChat wc = ManageThread.GetchatFromMap(U.Message.getTowho()+"->"+U.Message.getFromwho());
					if(wc!=null) 
					{
						wc.noedit.setFont(new Font("雅黑",Font.BOLD,10));
						wc.noedit.append(U.Message.getFromwho()+"  "+U.Message.getSendtime()+"\n");
						wc.noedit.setFont(new Font("雅黑",Font.BOLD,20));
						wc.noedit.append(U.Message.getMessage()+"\n");
					}
					else {
						FLists f=ManageThread.getlistfrommap(U.Message.getTowho());
						f.remindtofl(U);
					}
					break;
				case 4:
					f=ManageThread.getlistfrommap(U.Users.getId());
					f.onlinefriend(U);
					break;
				case 5:
					f=ManageThread.getlistfrommap(U.Users.getId());
					f.leavelinefriend(U);
					break;
				case 7: 
					f=ManageThread.getlistfrommap(U.Users.getId());
					f.remindtofl(U);
					break;
				case 8:
					ManageThread.getlistfrommap(U.getId()).addperson(U);
					break;
				case 9: 
					JOptionPane.showMessageDialog(null, "该好友不存在或好友不接受你的添加"); 
					break;
				case 10:
					new ClientchatRecord(U.Message.getRecord());
					break;
				
			}
		}
	 catch (Exception e) {
		e.printStackTrace();
	}
		}
	}
	
}
