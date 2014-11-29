package control;

import java.net.*;
import java.io.*;

import javax.swing.JOptionPane;

import mysql.Dao;
import view.ServerView;
import common.*;

public class EachThread extends Thread{
	public Socket s;
	MessageType m;
	String fw;
	boolean run=true;
	public EachThread(Socket s)
	{
		this.s = s;
	}
	public void run()
	{
		
			while(run)
			{
				try{
					ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
					MessageType m = (MessageType) ois.readObject();
					System.out.print("到达EachThread,成功接收客户端发来的包");
					switch(m.getFlag())
					{
						case 2:
							fw = m.Message.getFromwho();
							ServerView.appendtoserver("来自"+m.Message.getFromwho()+"的话："+m.Message.getMessage());
							EachThread et = ManageConnectThread.GetFromMap(m.Message.getTowho());
							ObjectOutputStream oos = new ObjectOutputStream(et.s.getOutputStream());
							oos.writeObject(m);
							break;
							
						case 7:
							if(!Dao.isperson(m.Users.getId()))
							{
								m.setFlag(9);
								oos = new ObjectOutputStream(s.getOutputStream());
								oos.writeObject(m);
								break;
							}
							et = ManageConnectThread.GetFromMap(m.Users.getId());
							oos = new ObjectOutputStream(et.s.getOutputStream());
							oos.writeObject(m);
							break;
						case 9:
							et = ManageConnectThread.GetFromMap(m.getId());
							oos = new ObjectOutputStream(et.s.getOutputStream());
							oos.writeObject(m);
							break;
						case 8:	
							et = ManageConnectThread.GetFromMap(m.getId());
							oos = new ObjectOutputStream(et.s.getOutputStream());
							if(Dao.addfriends(m.getId(), m.Users.getId(),Integer.parseInt(m.Users.getSex())))
							{
								MessageType mm = Dao.personal(m.Users.getId());
								mm.setFlag(8);
								mm.setId(m.getId());
								mm.Users.setPassword(m.Users.getSex());
								oos.writeObject(mm);
							}
							else 
							{
								m.setFlag(9);
								oos.writeObject(m);
							}
							EachThread et1 = ManageConnectThread.GetFromMap(m.Users.getId());
							ObjectOutputStream oos1 = new ObjectOutputStream(et1.s.getOutputStream());
							if(Dao.addfriends(m.Users.getId(), m.getId(),Integer.parseInt(m.Users.getSign())))
							{
								MessageType mm = Dao.personal(m.getId());
								mm.setFlag(8);
								mm.setId(m.Users.getId());
								mm.Users.setPassword(m.Users.getSign());
								oos1.writeObject(mm);
							}
							else 
							{
								m.setFlag(9);
								oos1.writeObject(m);
							}
							break;
					}
					} catch (Exception e1) {
						this.run = false;
						ManageConnectThread.ReMoveMap(fw);
						e1.printStackTrace();
					}
				
			}
			
		
	}

}
