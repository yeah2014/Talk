package view;
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

import java.net.*;
import java.io.*;


public class demo extends JFrame  implements ActionListener,MouseListener ,MouseMotionListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new demo();
	}

			
//			�������
//			���
			JPanel back,head,body,top,act;
//			��ǩ
			JLabel headjlabel,jlabel_account,jlabel_password;
//			�ı���
			JTextField  account , password;
//			��Ť
			JButton button_min,button_exit,register,enter;
//			������
			Point origin = new Point(); 
			 public demo()
			 {
//				 ���Ҫ��ͼƬ
				 ImageIcon headimage = new ImageIcon("D://Desktop/touxiang.jpg");
				 ImageIcon min = new ImageIcon("D://Desktop/6.png");
				 ImageIcon exit = new ImageIcon("D://Desktop/7.png");

				 
//				 ʵ����������
				 back  = new JPanel();
				 top = new JPanel();
				 head = new JPanel();
				 body = new JPanel();
				 act = new JPanel();
				 
//				 ʵ������ǩ���
				 headjlabel  = new JLabel(headimage);
				 jlabel_account = new JLabel("�ʺ�");
				 jlabel_password = new JLabel("����");
				 
//				 ʵ������Ť���
				 button_min  = new JButton(min);
				 button_exit = new JButton(exit);
				 register = new JButton("ע��");
				 enter = new JButton("��¼");
				 
//				 ʵ�����ı������
				 account = new JTextField(12);
				 password = new JTextField(12);
				 
//				 ������岼��
				 top.setLayout(new FlowLayout(FlowLayout.RIGHT,1,5));
			     head.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
			     body.setLayout(new FlowLayout(FlowLayout.CENTER,0,100));
			     act.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
			     
//				��������С	     
				 top.setPreferredSize(new Dimension(300, 30));
				 head.setPreferredSize(new Dimension(300, 60));
				 act.setPreferredSize(new Dimension(190, 300));
				 
//				 ���ð�Ť��С
				 button_min.setPreferredSize(new Dimension(min.getIconWidth(), min.getIconHeight()));
				 button_exit.setPreferredSize(new Dimension(exit.getIconWidth(), exit.getIconHeight()));

//				 ��Ť͸����
				 button_min.setContentAreaFilled(false);
				 button_exit.setContentAreaFilled(false);
				 
//				 ���͸����
				 back.setOpaque(false);
				 head.setOpaque(false);
				 body.setOpaque(false);
				 top.setOpaque(false);
			     act.setOpaque(false);
			     
//			             �ı���͸����
			     account.setOpaque(false);
			     password.setOpaque(false);
			     
//				 ȥ���߿�
			     this.setUndecorated(true);
			     
//			     ��������
			     account.setFont(new Font("����",Font.BOLD,18));
			     password.setFont(new Font("����",Font.BOLD,18));
			     jlabel_account.setFont(new Font("����",Font.BOLD,18));
			     jlabel_password.setFont(new Font("����",Font.BOLD,18));
//			     ����������ɫ
			     jlabel_account.setForeground(Color.white);
			     jlabel_password.setForeground(Color.white);
			     account.setForeground(Color.white);
			     password.setForeground(Color.white);
			     
//			            ������
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
				 
//				 ��Ӽ���
				 button_min.addActionListener(this);
				 button_exit.addActionListener(this);
				 back.addMouseListener(this);
				 back.addMouseMotionListener(this);
				 register.addActionListener(this);
				 enter.addActionListener(this);
				 
//				 JFrame������ɫ
				 this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
//				 ���ô�С��λ��
				 this.setBounds(500, 300, 300, 600);
				 
				 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			             ���ÿɼ�
				 this.setVisible(true);
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
				
			}
			 
			 

	}

