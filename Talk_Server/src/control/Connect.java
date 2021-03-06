/*
 * 服务端后台接收端
 * 处理登录，注册，忘记密码
 */
package control;
import java.net.*;
import java.util.ArrayList;
import common.*;
import java.io.*;
import mysql.*;
import view.*;
public class Connect extends Thread{

	 ServerSocket ss;
	 Socket s;
	 
	public void run()
	{
		try {
		new Dao();
		Dao.dao1();
		ss = new ServerSocket(8888);	
		ServerView.appendtoserver("服务器在8888端口监听中......");
		ServerView.appendtoserver("连接数据库成功!");
		while(true)
		{
			s = ss.accept();
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			MessageType m = (MessageType) ois.readObject();
			switch(m.getFlag())
			{
				//处理登录
				case 1 : 
					//从数据库中提取资料判断帐号密码是否正确
					if(Dao.login(m.Users.getId(), m.Users.getPassword()))
					{
						MessageType U = Dao.personInformation(m.Users.getId());
						U.setFlag(1);
						U.setId(m.Users.getId());
						//获取该用户所有好友基本信息
						ArrayList<String> al = Dao.whoesfriends(m.Users.getId());
						for(int i=0;i<al.size();i++)
						{
							EachThread eett =ManageConnectThread.GetFromMap(al.get(i));
							if(eett!=null)
							{
								MessageType mt = new MessageType();
								mt.setFlag(4);
								mt.setId(m.Users.getId());
								mt.Users.setId(al.get(i));
								ObjectOutputStream oos = new ObjectOutputStream(eett.s.getOutputStream());
								oos.writeObject(mt);
								for(int j=0;j<U.Userdata.getFriend().size();j++)
								{
									if(al.get(i).equals(U.Userdata.getFriend().get(j).getId())) 
									{
										U.Userdata.getFriend().get(j).setTemp(1);
										break;
									}
								}
							}
						}
						ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
						oos.writeObject(U);
						//创建并开启线程
						EachThread et = new EachThread(s,m.Users.getId());
						et.start();
						ManageConnectThread.AddToMap(m.Users.getId(), et);
						

						
					}
					else {
						m.setFlag(0);
						ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
						oos.writeObject(m);
					}
					break;
					
				case 2 :
					
				case 3 :
					//处理注册
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
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(m);
					break;
					//处理找回密码
				case 5 :
					String password = Dao.findAnser(m.Forget);
					
					if(password!="")
					{
						m.Users.setPassword(password);
						m.setFlag(1);
					}
					else 
					{
						m.setFlag(0);
					}
					ObjectOutputStream oos1 = new ObjectOutputStream(s.getOutputStream());
					oos1.writeObject(m);
					break;
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
