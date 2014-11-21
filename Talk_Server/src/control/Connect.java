package control;
import java.net.*;
import java.io.*;
import mysql.*;
import view.*;
public class Connect extends Thread{

	
	 ServerSocket ss;
	 Socket s;
	 
	public void run()
	{
		try {
		Dao.dao1();
		ss = new ServerSocket(8888);	
		ServerView.appendtoserver("服务器在8888端口监听中......");
		ServerView.appendtoserver("连接数据库成功!");
		while(true)
		{
			s = ss.accept();
			Analysis.isAnalysis(s);
			
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}

}
