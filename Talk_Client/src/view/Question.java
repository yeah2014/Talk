package view;
import javax.swing.*;

import java.awt.*;
import java.net.*;
import java.awt.event.*;
import control.*;
import common.*;
import control.ClientConnect;
import SendType.*;

public class Question extends JFrame  implements ActionListener,MouseListener ,MouseMotionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2964486594368306911L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Question(null);
	}

			
//			�������
//			���
			JPanel act;
//			��ǩ
			JLabel jlabel_question,jlabel_answer,jlable_userName,j_question;
//			�ı���
			JTextField question,answer,userName;
//			��Ť
			JButton confirm,cancel;
			demo d;
			Socket s;
			ClientConnect connect;
			 public Question(Socket s)
			 {
				 this.s = s;
//				 ʵ����������
				 act = new JPanel();
				 
//				 ʵ������ǩ���
				 jlabel_question = new JLabel("-����-");
				 jlabel_answer = new JLabel("-��-");
				 jlable_userName =new JLabel("-�ʺ�-");
				 j_question = new JLabel(" Сѧ��ҵ�ڣ�");
				 
//				 ʵ������Ť���
				 confirm = new JButton("ȷ��");
				 cancel = new JButton("ȡ��");
				 
//				 ʵ�����ı������
				 question = new JTextField(12);
				 answer = new JTextField(12);
				 userName = new JTextField(12);
				 
//				 ������岼��
			     act.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
			     
//				��������С	     
				 act.setPreferredSize(new Dimension(190, 350));
				 
				 //���뷨����
				 userName.enableInputMethods(false);
				 
//				 ���͸����
			     act.setOpaque(false);
			     
//			             �ı���͸����
			     question.setOpaque(false);
			     answer.setOpaque(false);
			     userName.setOpaque(false);
			     
//			     ��������
			     question.setFont(new Font("����",Font.BOLD,18));
			     answer.setFont(new Font("����",Font.BOLD,18));
			     userName.setFont(new Font("����",Font.BOLD,18));
			     jlabel_question.setFont(new Font("����",Font.BOLD,18));
			     jlabel_answer.setFont(new Font("����",Font.BOLD,18));
			     jlable_userName.setFont(new Font("����",Font.BOLD,18));
			     j_question.setFont(new Font("����",Font.BOLD,18));
//			     ����������ɫ
			     jlabel_question.setForeground(Color.white);
			     jlabel_answer.setForeground(Color.white);
			     jlable_userName.setForeground(Color.white);
			     j_question.setForeground(Color.white);
			     userName.setForeground(Color.white);
			     
			     question.setForeground(Color.white);
			     answer.setForeground(Color.white);
			     
//			            ������
			     act.add(jlable_userName);
			     act.add(userName);
			     act.add(jlabel_question);
//			     act.add(j_question);
			     act.add(question);
			     act.add(jlabel_answer);
			     act.add(answer);
			     act.add(confirm);
			     act.add(cancel);
				 
//				 ��Ӽ���
				 confirm.addActionListener(this);
				 cancel.addActionListener(this);
				 
				 d = new demo(act);
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
				if(e.getSource() == cancel)
				{
					this.dispose();
					d.dispose();
					new Login();
				}
				else if(e.getSource() == confirm)
				{
					Forget fg = new Forget(userName.getText(), question.getText(), answer.getText());
					Found f = new Found(s, fg);
					if(f.bl == false) 
					{
						JOptionPane.showMessageDialog(null, "������д����"); 
						connect = new ClientConnect();
						this.s = connect.getS();
					}
					else{
					this.dispose();
					d.dispose();
					new Login();
					}
				}
			}
			 
			 

	}

