package control;

import javax.swing.JOptionPane;

import view.*;

public class MyClient {

	static String ip = JOptionPane.showInputDialog(null,"���������ӵ�IP��ַ","connect",JOptionPane.OK_OPTION);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyClient();
	}
	
	public MyClient()
	{
		new Login();
		
	}

}
