package control;
import view.*;
import java.io.ObjectInputStream;
import java.net.*;

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
				System.out.println(U.Message.getFromwho()+"->"+U.Message.getTowho());
				wc.noedit.append(U.Message.getFromwho()+": "+U.Message.getMessage()+"\n");
				break;
			}
		}
	 catch (Exception e) {
		e.printStackTrace();
	}
		}
	}
	
}
