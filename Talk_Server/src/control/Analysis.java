package control;

import java.io.*;
import java.net.*;

import javax.swing.ImageIcon;

import common.*;;


public class Analysis {


	public Analysis()
	{

	}

	public static void isAnalysis (Socket s)
	{
		MessageType m;
		try {
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			m = (MessageType)ois.readObject();
			switch(m.getFlag())
			{
				//验证登陆
				case 1 : 
				{
					m=null;
					m = new MessageType();
					m.setFlag(1);
					m.setId("20");
					m.Userdata.setName("张宏业");
					m.Userdata.setSex("男");
					m.Userdata.setSign("我来买单!");
					m.Userdata.setHeadicon(new ImageIcon("img/touxiang.jpg"));
					Friend[] f = new Friend[50];
					for(int i = 0 ; i<f.length ; i++)
					{
						f[i] = new Friend();
						f[i].setdata("i+1", "i+100", "你好吗", new ImageIcon("img/xiaotouxiang.jpg"));
					}
					m.Userdata.setFriend(f);
					
					oos.writeObject(m);
				}
				//发送消息
				case 2 :
				//发送图片
				case 3 :
				//注册
				case 4 :
				//找回密码
				case 5 :
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
