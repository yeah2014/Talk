package control;

import java.net.*;

import javax.swing.JOptionPane;

public class ClientConnect {
	
	private Socket s;
	private boolean flag;
	public ClientConnect(Socket ss)
	{
		if(ss!=null) 
		{
			this.s=ss;
			this.flag = true;
		}
		else{
		try {
			s = new Socket(MyClient.ip, 8888);
			if (s == null) 	
				{
					flag = false ;
					JOptionPane.showMessageDialog(null, "���ӳ���,�������硣");
				}
			else flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
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
