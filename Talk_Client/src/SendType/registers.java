/*
 * 此类用于把注册内容打包发送及接收确认信息
 */
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
		m.Users = u;
		m.setFlag(4);
		m.Users.setHeadicon(1);
		oos.writeObject(m);
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		m = (MessageType)ois.readObject();
		if(m.getFlag()==1) bl=true;
		else bl = false;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	
}
