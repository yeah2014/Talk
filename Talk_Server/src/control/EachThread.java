package control;

import java.net.*;
import java.io.*;

import common.*;

public class EachThread extends Thread{
	public Socket s;
	MessageType m;
	boolean run=true;
	public EachThread(Socket s)
	{
		this.s = s;
	}
	public void run()
	{
		
			while(run)
			{
				try {
				s.sendUrgentData(0xFF);
				} catch (Exception e) {
					e.printStackTrace();
					this.run=false;
					ManageConnectThread.ReMoveMap(ManageConnectThread.GetFromMap(s));
					ManageConnectThread.ReMoveMap(s);
				}
					try {
						if(this.run==false)
							{
								s.close();
							   break;
							}
						Analysis.isAnalysis(s);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// TODO: handle exception
				
			}
			
		
	}

}
