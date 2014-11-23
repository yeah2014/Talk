package control;

import java.net.Socket;
import java.io.*;

import common.MessageType;
public class sendmessage {

	public sendmessage(Socket s,MessageType m) throws IOException
	{
		
		ObjectOutputStream oos = ManageConnectThread.GetOosFromMap(m.Message.getTowho());
		oos.writeObject(m);
	}
}
