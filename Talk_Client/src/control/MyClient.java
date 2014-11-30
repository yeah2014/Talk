package control;

import java.net.Socket;
import view.*;

public class MyClient {

	static String ip = "192.168.0.101";//JOptionPane.showInputDialog(null,"请输入连接的IP地址","connect",JOptionPane.OK_OPTION);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyClient();
	}
	Socket s=null;
	public MyClient()
	{
		new Login(s);
		
	}

}
