package view;

import javax.swing.*;

import FriendsLists.FLists;
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
	JPanel act,act1;
//	��ǩ
	JLabel jlabel_account,jlabel_password;
//	�ı���
	JTextField  account;
	//����
	JPasswordField password;
//	��Ť
	JButton register,enter,answer;
	demo d;
	Socket s;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	 public Login(Socket s)
	 {
		 this.s=s;
//		 ʵ����������
		 act = new JPanel();
		 act1 = new JPanel();
		 
//		 ʵ������ǩ���
		 jlabel_account = new JLabel("�ʺ�");
		 jlabel_password = new JLabel("����");
		 
//		 ʵ������Ť���
		 register = new JButton("---ע��---");
		 enter = new JButton("---��¼---");
		 answer = new JButton("��������");
		 
//		 ʵ�����ı������
		 account = new JTextField(12);
		 password = new JPasswordField(12);
		 
//		 ������岼��
	     act.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
	     act1.setLayout(new FlowLayout(FlowLayout.CENTER,10,60));
	     
//		��������С	     
		 act.setPreferredSize(new Dimension(190, 300));
		
//		 ���͸����
	     act.setOpaque(false);
	     act1.setOpaque(false);
//	             �ı���͸����
	     account.setOpaque(false);
	     password.setOpaque(false);
	     
//	            �������뷨
	     account.enableInputMethods(false);
	     password.enableInputMethods(false);
	     
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
	     act.add(answer);
		 act1.add(act);
//		 ��Ӽ���
		 register.addActionListener(this);
		 enter.addActionListener(this);
		 answer.addActionListener(this);
		 password.addKeyListener(this);
		 
		 d = new demo(act1,null);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	 }
	 public static void main(String []a)
	 {
		 new Login(null);
	 }
	 
	
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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
		if(e.getSource() == enter)
		{
			connect = new ClientConnect(s);
			if(!connect.getFlag())  System.exit(0);
			else 
			{
				String account = new String(this.account.getText());
				String password = new String(this.password.getPassword());
				System.out.println(account+" "+password);
				//������֤��
				try {
					this.password.setText("");
					if(isconfirm(connect.getS(), account, password))
					{
						this.dispose();
						d.dispose();
						FLists f = new FLists(Userdata);
						ManageThread.AddFlisttomap(account, f);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "���벻��ȷ��");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else if(e.getSource() == register)
		{
			this.dispose();
			d.dispose();
			connect = new ClientConnect(s);
			if(!connect.getFlag())  System.exit(0);
			else
			{
				new register(connect.getS());
			}
		}
		else if(e.getSource() == answer)
		{
			this.dispose();
			d.dispose();
			connect = new ClientConnect(s);
			new Question(connect.getS());
		}
		
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
			connect = new ClientConnect(s);
			if(!connect.getFlag())  System.exit(0);
			else 
			{
				String account = new String(this.account.getText());
				String password = new String(this.password.getPassword());
				//������֤��
				try {
					this.password.setText("");
					if(isconfirm(connect.getS(), account, password))
					{
						this.dispose();
						d.dispose();
						FLists f = new FLists(Userdata);
						ManageThread.AddFlisttomap(account, f);
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
		oos = new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(confirm);
		ois = new ObjectInputStream(s.getInputStream());
		Userdata = new MessageType();
		Userdata =(MessageType)ois.readObject();
		if(Userdata.getFlag() == 1)
		{
			
			FlistThread ft = new FlistThread(s);
			ft.start();
			ManageThread.AddThreadtoMap(account, ft);
			return true;
		}
		
		else return false;	
	}
}
