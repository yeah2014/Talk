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
					m.Userdata.setHeadicon(new ImageIcon("img/touxiang.jpg"));
					Friend[] f = new Friend[50];
					for(int i = 0 ; i<f.length ; i++)
					{
						f[i] = new Friend();
						f[i].setdata("i+1", "i+100", "�����", new ImageIcon("img/xiaotouxiang.jpg"));
					}
					m.Userdata.setFriend(f);
					
					oos.writeObject(m);
				}
				//������Ϣ
				case 2 :
				//����ͼƬ
				case 3 :
				//ע��
				case 4 :
				//�һ�����
				case 5 :
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
