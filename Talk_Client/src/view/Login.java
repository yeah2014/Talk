package view;

import javax.swing.*;

import control.*;

import java.awt.*;
import java.awt.event.*;

import common.*;

import java.net.*;
import java.io.*;


public class Login  extends JFrame  implements ActionListener,MouseListener ,MouseMotionListener,KeyListener{
	 /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	ClientConnect connect;
	MessageType Userdata;
//	定义组件
//	面板
	JPanel back,head,body,top,act;
//	标签
	JLabel headjlabel,jlabel_account,jlabel_password;
//	文本框
	JTextField  account , password;
//	按扭
	JButton button_min,button_exit,register,enter;
//	点坐标
	Point origin = new Point(); 
	 public Login()
	 {
//		 组件要的图片
		 ImageIcon headimage = new ImageIcon("D://Desktop/touxiang.jpg");
		 ImageIcon min = new ImageIcon("D://Desktop/6.png");
		 ImageIcon exit = new ImageIcon("D://Desktop/7.png");

		 
//		 实例化面板组件
		 back  = new JPanel();
		 top = new JPanel();
		 head = new JPanel();
		 body = new JPanel();
		 act = new JPanel();
		 
//		 实例化标签组件
		 headjlabel  = new JLabel(headimage);
		 jlabel_account = new JLabel("帐号");
		 jlabel_password = new JLabel("密码");
		 
//		 实例化按扭组件
		 button_min  = new JButton(min);
		 button_exit = new JButton(exit);
		 register = new JButton("注册");
		 enter = new JButton("登录");
		 
//		 实例化文本框组件
		 account = new JTextField(12);
		 password = new JTextField(12);
		 
//		 设置面板布局
		 top.setLayout(new FlowLayout(FlowLayout.RIGHT,1,5));
	     head.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
	     body.setLayout(new FlowLayout(FlowLayout.CENTER,0,100));
	     act.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
	     
//		设置面板大小	     
		 top.setPreferredSize(new Dimension(300, 30));
		 head.setPreferredSize(new Dimension(300, 60));
		 act.setPreferredSize(new Dimension(190, 300));
		 
//		 设置按扭大小
		 button_min.setPreferredSize(new Dimension(min.getIconWidth(), min.getIconHeight()));
		 button_exit.setPreferredSize(new Dimension(exit.getIconWidth(), exit.getIconHeight()));

//		 按扭透明化
		 button_min.setContentAreaFilled(false);
		 button_exit.setContentAreaFilled(false);
		 
//		 面板透明化
		 back.setOpaque(false);
		 head.setOpaque(false);
		 body.setOpaque(false);
		 top.setOpaque(false);
	     act.setOpaque(false);
	     
//	             文本框透明化
	     account.setOpaque(false);
	     password.setOpaque(false);
	     
//	            禁用输入法
	     account.enableInputMethods(false);
	     password.enableInputMethods(false);
	     
//		 去除边框
	     this.setUndecorated(true);
	     
//	     设置字体
	     account.setFont(new Font("宋体",Font.BOLD,18));
	     password.setFont(new Font("宋体",Font.BOLD,18));
	     jlabel_account.setFont(new Font("宋体",Font.BOLD,18));
	     jlabel_password.setFont(new Font("宋体",Font.BOLD,18));
//	     设置字体颜色
	     jlabel_account.setForeground(Color.white);
	     jlabel_password.setForeground(Color.white);
	     account.setForeground(Color.white);
	     password.setForeground(Color.white);
	     
//	            添加组件
	     act.add(jlabel_account);
	     act.add(account);
	     act.add(jlabel_password);
	     act.add(password);
	     act.add(register);
	     act.add(enter);
	     body.add(act);
	     top.add(button_min);
	     top.add(button_exit);
		 head.add(headjlabel);
		 back.add(top,BorderLayout.NORTH);
		 back.add(head,BorderLayout.CENTER);
		 back.add(body,BorderLayout.SOUTH);
		 this.add(back);
		 
//		 添加监听
		 button_min.addActionListener(this);
		 button_exit.addActionListener(this);
		 back.addMouseListener(this);
		 back.addMouseMotionListener(this);
		 register.addActionListener(this);
		 enter.addActionListener(this);
		 password.addKeyListener(this);
		 
//		 JFrame容器配色
		 this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
//		 设置大小，位置
		 this.setBounds(500, 300, 300, 600);
		 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	             设置可见
		 this.setVisible(true);
	 }
	 public static void main(String []a)
	 {
		 new Login();
	 }
	 
	
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getY()<=100)
		{Point p = getLocation();  //当鼠标拖动时获取窗口当前位置
        //设置窗口的位置
        //窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
        setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
	
		}
	}
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		origin.x = e.getX();  //当鼠标按下的时候获得窗口当前的位置
        origin.y = e.getY();

	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button_min) 
			this.setExtendedState(Frame.ICONIFIED);
		else if(e.getSource() == button_exit) 
			System.exit(0);
		else if(e.getSource() == enter)
		{
			connect = new ClientConnect();
			if(!connect.getFlag())  System.exit(0);
			else 
			{
				String account = new String(this.account.getText());
				String password = new String(this.password.getText());
				//发送验证码
				try {
					this.password.setText("");
					if(isconfirm(connect.getS(), account, password))
					{
						this.dispose();
						new Friendslist(Userdata);
						//Userdata = null;
					}
					else
					{
						
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
	 
	public boolean isconfirm(Socket s ,String account , String password) throws Exception
	{
		MessageType confirm = new MessageType();
		confirm.setFlag(1);
		confirm.Users.setId(account);
		confirm.Users.setPassword(password);
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(confirm);
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		Userdata = new MessageType();
		Userdata = (MessageType)ois.readObject();
		if(Userdata.getFlag() == 1)
			return true;
		else return false;	
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == Event.ENTER)
		{
			connect = new ClientConnect();
			if(!connect.getFlag())  System.exit(0);
			else 
			{
				String account = new String(this.account.getText());
				String password = new String(this.password.getText());
				//发送验证码
				try {
					this.password.setText("");
					if(isconfirm(connect.getS(), account, password))
					{
						this.dispose();
						new Friendslist(Userdata);
						//Userdata = null;
					}
					else
					{
						
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	 
}
