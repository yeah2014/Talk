/*
 * �ͻ���������
 */
package control;

import java.net.Socket;
import view.*;

public class MyClient {
	static String ip ="120.24.225.226";
//	static String ip =JOptionPane.showInputDialog(null,"���������ӵ�IP��ַ","connect",JOptionPane.OK_OPTION);
	public static void main(String[] args) {
		new MyClient();
	}
	Socket s=null;
	public MyClient()
	{
		new Login(s);
		
	}

}
