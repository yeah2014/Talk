/*
 * 此类包找回密码资料的打包发送和接收确认信息
 */
package SendType;

import java.net.*;
import java.io.*;

import javax.swing.JOptionPane;

import common.*;


public class Found {
	
	MessageType m = new MessageType();
	public boolean bl;
	
	public Found(Socket s,Forget u)
	{
		try {
			

		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		m.Forget = u;
		m.setFlag(5);
		oos.writeObject(m);
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		m = (MessageType)ois.readObject();
		if(m.getFlag()==1) 
		{
			bl = true;
			JOptionPane.showMessageDialog(null, "密码找回成功"+"， 密码为"+m.Users.getPassword()); 
		}
		else bl = false;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	
}
