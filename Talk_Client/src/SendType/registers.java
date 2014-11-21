package SendType;

import java.net.*;
import java.io.*;

import common.*;


public class registers {
	
	MessageType m = new MessageType();
	public boolean bl;
	
	public registers(Socket s,Users u)
	{
		try {
			

		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		m.Users = u;
		m.setFlag(4);
		oos.writeObject(m);
		m = (MessageType)ois.readObject();
		if(m.getFlag()==1) bl=true;
		else bl = false;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	
}
