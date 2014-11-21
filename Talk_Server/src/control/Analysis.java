package control;

import java.io.*;
import java.net.*;

import javax.swing.ImageIcon;

import mysql.Dao;
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
				//��֤��½
				case 1 : 
				{
					m=null;
					m = new MessageType();
					m.setFlag(1);
					m.setId("20");
					m.Userdata.setName("�ź�ҵ");
					m.Userdata.setSex("��");
					m.Userdata.setSign("������!");
					m.Userdata.setHeadicon(new ImageIcon("D://Desktop/touxiang.jpg"));
					Myclassmates[] f = new Myclassmates[20];
					MygoodFriends[] g = new MygoodFriends[20];
					Myfamily[] ff = new Myfamily[20];
					MyOwns[] o = new MyOwns[20];
					Myteachers[] t = new Myteachers[20];
					int k = 0,i = 0;
					for(i=0; i<f.length ; i++)
					{
						System.out.println(i+k+1);
						f[i] = new Myclassmates();
						f[i].setdata(Integer.toString(i+k+1), "k+100", "�����", new ImageIcon("D://Desktop/xiaotouxiang.jpg"));
					}
					k+=i+1;
					for(i=0; i<g.length ;i++)
					{System.out.println(i+k+1);
						g[i] = new MygoodFriends();
						g[i].setdata(Integer.toString(i+k+1), "k+100", "�����", new ImageIcon("D://Desktop/xiaotouxiang.jpg"));
					}
					k+=i+1;
					for(i=0; i<ff.length ;i++)
					{System.out.println(i+k+1);
						ff[i] = new Myfamily();
						ff[i].setdata(Integer.toString(i+k+1), "k+100", "�����", new ImageIcon("D://Desktop/xiaotouxiang.jpg"));
					}
					k+=i+1;
					for(i=0; i<o.length ;i++)
					{System.out.println(i+k+1);
						o[i] = new MyOwns();
						o[i].setdata(Integer.toString(i+k+1), "k+100", "�����", new ImageIcon("D://Desktop/xiaotouxiang.jpg"));
					}
					k+=i+1;
					for(i=0; i<t.length ;i++)
					{
						System.out.println(i+k+1);
						t[i] = new Myteachers();
						t[i].setdata(Integer.toString(i+k+1), "k+100", "�����", new ImageIcon("D://Desktop/xiaotouxiang.jpg"));
					}
					m.Userdata.setMyclassmates(f);
					m.Userdata.setMyfamily(ff);
					m.Userdata.setMygoodFriend(g);
					m.Userdata.setMyteachers(t);
					m.Userdata.setMyowns(o);
					Onlinepeople[] olp = new Onlinepeople[20];
					for(i = 0 ; i<olp.length ; i++)
					{
						olp[i] = new Onlinepeople();
						olp[i].setFlag(i%5+1);
						olp[i].setId(Integer.toString(i+1));
					}
					m.Addonline.setOnlinepeople(olp);
					oos.writeObject(m);
				}
				break;
				//������Ϣ
				case 2 :
				//����ͼƬ
				case 3 :
				//ע��
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
				//�һ�����
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
				//�޸�����
				case 6 :
				//�����������
				default :
						
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
