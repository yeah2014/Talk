package control;
import FriendsLists.FLists;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

import common.*;
public class FlistThread extends Thread{
	Socket s;
	ObjectInputStream ois;
	public FlistThread(Socket s,ObjectInputStream ois)
	{
		this.s=s;
		this.ois = ois;
		
	}
	public void run()
	{
		while(true)
		{
		try {
			MessageType U = (MessageType)ois.readObject();
			Analysis.isAnalysis(U);
		}
	 catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
		}
	}
	
}
