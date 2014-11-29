package control;

import javax.swing.JOptionPane;

import view.*;

public class MyClient {

	static String ip = JOptionPane.showInputDialog(null,"请输入连接的IP地址","connect",JOptionPane.OK_OPTION);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyClient();
	}
	
	public MyClient()
	{
		new Login();
		
	}

}
