package SendType;

import java.net.Socket;

import common.Message;
import common.MessageType;

import java.io.*;

public class messages {
	

	public static void sendmessages(Socket s,String fromwho,String towho,String message) throws Exception
	{
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		MessageType m = new MessageType();
		m.Message.setMessage(message);
		m.Message.setFromwho(fromwho);
		m.Message.setTowho(towho);
		m.setId(towho);
		m.setFlag(2);
		System.out.println("2.."+towho);
		oos.writeObject(m);
	}
}
