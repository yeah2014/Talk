package control;

import java.net.*;
import java.io.*;

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
					}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						this.run = false;
						ManageConnectThread.ReMoveMap(fw);
						e1.printStackTrace();
					}
					// TODO: handle exception
				
			}
			
		
	}

}
