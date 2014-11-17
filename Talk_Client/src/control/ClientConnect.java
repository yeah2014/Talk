package control;

import java.net.*;
import java.io.*;

import javax.swing.JOptionPane;

public class ClientConnect {
	
	private Socket s;
	private boolean flag;
	public ClientConnect()
	{
		
		try {
			s = new Socket("127.0.0.1", 8888);
			if (s == null) 	
				{
					flag = false ;
					JOptionPane.showMessageDialog(null, "连接出错,请检查网络。");
				}
			else flag = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
	}
	public boolean getFlag() {
		return flag;
	}
	
	public Socket getS()
	{
		return s;
	}
	
}
