package control;

import java.io.*;
import java.net.*;

import javax.swing.ImageIcon;

import view.ServerView;
import mysql.Dao;
import common.*;;


public class Analysis {


	public Analysis()
	{

	}
	static int x=864;
	public static void isAnalysis (Socket s)
	{
		MessageType m;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			ois = new ObjectInputStream(s.getInputStream());
			oos= new ObjectOutputStream(s.getOutputStream());
			m = (MessageType)ois.readObject();
			
			
			switch(m.getFlag())
			{
				//验证登陆
				case 1 : 
				
					
					m.setFlag(1);
					m.setId("20");
					m.Userdata.setName("张宏业");
					m.Userdata.setSex("男");
					m.Userdata.setSign("我来买单!");
//					m.Userdata.setHeadicon(new ImageIcon("D://Desktop/test.png"));
					Friends[] g = new Friends[50];
					int i = 0;
					for(i=0; i<10 ;i++)
					{
						g[i] = new Friends();
						g[i].setdata(Integer.toString(i+1), "k+100", "你好吗", new ImageIcon("D://Desktop/test.png"));
					    if(i%2==0)
						  g[i].setTemp(1);
					    else
							g[i].setTemp(0);
					    g[i].setFlag(1);
					}
					for(; i<20 ;i++)
					{
						g[i] = new Friends();
						g[i].setdata(Integer.toString(i+1), "k+100", "你好吗", new ImageIcon("D://Desktop/test.png"));
						if(i%2==0)
						   g[i].setTemp(1);
						else
							g[i].setTemp(0);
					    g[i].setFlag(2);
					}
					for(; i<30 ;i++)
					{
						g[i] = new Friends();
						g[i].setdata(Integer.toString(i+1), "k+100", "你好吗", new ImageIcon("D://Desktop/test.png"));
						if(i%2==0)
							g[i].setTemp(1);
						else
							g[i].setTemp(0);
					    g[i].setFlag(3);
					}
					for(; i<40 ;i++)
					{
						g[i] = new Friends();
						g[i].setdata(Integer.toString(i+1), "k+100", "你好吗", new ImageIcon("D://Desktop/test.png"));
						if(i%2==0)
							g[i].setTemp(1);
						else
							g[i].setTemp(0);
					    g[i].setFlag(4);
					}
					for(; i<50 ;i++)
					{
						g[i] = new Friends();
						g[i].setdata(Integer.toString(i+1), "k+100", "你好吗", new ImageIcon("D://Desktop/test.png"));
						if(i%2==0)
							g[i].setTemp(1);
						else
							g[i].setTemp(0);
					    g[i].setFlag(5);
					}
					m.setId(m.Users.getId());
					m.Userdata.setFriend(g);
					
					oos.writeObject(m);
					EachThread et = new EachThread(s);
					ManageConnectThread.AddToMap(m.Users.getId(), et,oos);
					ServerView.appendtoserver(m.Users.getId()+"成功登陆");
					et.start();
					break;
				
				//

				//发送消息
				case 2 :
					System.out.println(m.Message.getFromwho()+"说： "+m.Message.getMessage());
					new sendmessage(ManageConnectThread.GetFromMap(m.Message.getFromwho()).s, m);
					break;
				//发送图片
				case 3 :
				//注册
				case 4 :
					if(Dao.queryAccount(m.Users.getId()) == false)
					{
						m.setFlag(1); 
						Dao.addUserInfo(m.Users);
					}
					else
					{
						m.setFlag(0);
					}
					oos.writeObject(m);
					break;
				//找回密码
				case 5 :
					String password = Dao.findAnser(m.Forget);
					if(password != "") 
					{
						m.setFlag(1);
						m.Users.setPassword(password);
					}
					else 
					{
						m.setFlag(0);
					}
					oos.writeObject(m);
					break;
				//修改密码
				case 6 :
				//垃圾处理操作
				default :
						
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
