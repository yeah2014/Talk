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
//	�������
//	���
	JPanel back,head,body,top,act;
//	��ǩ
	JLabel headjlabel,jlabel_account,jlabel_password;
//	�ı���
	JTextField  account , password;
//	��Ť
	JButton button_min,button_exit,register,enter;
//	������
	Point origin = new Point(); 
	 public Login()
	 {
//		 ���Ҫ��ͼƬ
		 ImageIcon headimage = new ImageIcon("D://Desktop/touxiang.jpg");
		 ImageIcon min = new ImageIcon("D://Desktop/6.png");
		 ImageIcon exit = new ImageIcon("D://Desktop/7.png");

		 
//		 ʵ����������
		 back  = new JPanel();
		 top = new JPanel();
		 head = new JPanel();
		 body = new JPanel();
		 act = new JPanel();
		 
//		 ʵ������ǩ���
		 headjlabel  = new JLabel(headimage);
		 jlabel_account = new JLabel("�ʺ�");
		 jlabel_password = new JLabel("����");
		 
//		 ʵ������Ť���
		 button_min  = new JButton(min);
		 button_exit = new JButton(exit);
		 register = new JButton("ע��");
		 enter = new JButton("��¼");
		 
//		 ʵ�����ı������
		 account = new JTextField(12);
		 password = new JTextField(12);
		 
//		 ������岼��
		 top.setLayout(new FlowLayout(FlowLayout.RIGHT,1,5));
	     head.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
	     body.setLayout(new FlowLayout(FlowLayout.CENTER,0,100));
	     act.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
	     
//		��������С	     
		 top.setPreferredSize(new Dimension(300, 30));
		 head.setPreferredSize(new Dimension(300, 60));
		 act.setPreferredSize(new Dimension(190, 300));
		 
//		 ���ð�Ť��С
		 button_min.setPreferredSize(new Dimension(min.getIconWidth(), min.getIconHeight()));
		 button_exit.setPreferredSize(new Dimension(exit.getIconWidth(), exit.getIconHeight()));

//		 ��Ť͸����
		 button_min.setContentAreaFilled(false);
		 button_exit.setContentAreaFilled(false);
		 
//		 ���͸����
		 back.setOpaque(false);
		 head.setOpaque(false);
		 body.setOpaque(false);
		 top.setOpaque(false);
	     act.setOpaque(false);
	     
//	             �ı���͸����
	     account.setOpaque(false);
	     password.setOpaque(false);
	     
//	            �������뷨
	     account.enableInputMethods(false);
	     password.enableInputMethods(false);
	     
//		 ȥ���߿�
	     this.setUndecorated(true);
	     
//	     ��������
	     account.setFont(new Font("����",Font.BOLD,18));
	     password.setFont(new Font("����",Font.BOLD,18));
	     jlabel_account.setFont(new Font("����",Font.BOLD,18));
	     jlabel_password.setFont(new Font("����",Font.BOLD,18));
//	     ����������ɫ
	     jlabel_account.setForeground(Color.white);
	     jlabel_password.setForeground(Color.white);
	     account.setForeground(Color.white);
	     password.setForeground(Color.white);
	     
//	            ������
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
		 
//		 ��Ӽ���
		 button_min.addActionListener(this);
		 button_exit.addActionListener(this);
		 back.addMouseListener(this);
		 back.addMouseMotionListener(this);
		 register.addActionListener(this);
		 enter.addActionListener(this);
		 password.addKeyListener(this);
		 
//		 JFrame������ɫ
		 this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
//		 ���ô�С��λ��
		 this.setBounds(500, 300, 300, 600);
		 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	             ���ÿɼ�
		 this.setVisible(true);
	 }
	 public static void main(String []a)
	 {
		 new Login();
	 }
	 
	
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getY()<=100)
		{Point p = getLocation();  //������϶�ʱ��ȡ���ڵ�ǰλ��
        //���ô��ڵ�λ��
        //���ڵ�ǰ��λ�� + ��굱ǰ�ڴ��ڵ�λ�� - ��갴�µ�ʱ���ڴ��ڵ�λ��
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
		origin.x = e.getX();  //����갴�µ�ʱ���ô��ڵ�ǰ��λ��
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
				//������֤��
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
				//������֤��
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
