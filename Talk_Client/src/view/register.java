package view;
import javax.swing.*;

import java.net.*;
import java.awt.*;
import java.awt.event.*;

import SendType.*;
import common.*;
import control.ClientConnect;
public class register extends JFrame  implements ActionListener,MouseListener ,MouseMotionListener,KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6619369305741071492L;

	public static void main(String[] args) {
		new register(null);
	}
		
//			�������
//			���
			JPanel act;
//			��ǩ
			JLabel jlabel_account,jlabel_question,jlabel_answer,jlabel_userName,jlabel_password1,jlabel_password2,jlabel_sign,jlabel_sex,j_question;
//			�ı���
			JTextField question , answer,userName,sign,account;
			//����
			JPasswordField  password1,password2;
//			��Ť
			JButton confirm,cancel;
			//��ѡ��ť
			JRadioButton man,woman;
			//������ѡ��ť��
		    ButtonGroup bg = new ButtonGroup();
		    
		    demo d;
		    Socket s;
		    ClientConnect connect;
			 public register(Socket s)
			 {
				 
				 this.s=s;
//				 ʵ����������
				 act = new JPanel();
				 
//				 ʵ������ǩ���
				 jlabel_account = new JLabel("�ʺ�");
				 jlabel_question = new JLabel("����");
				 jlabel_answer = new JLabel("��");
				 jlabel_userName = new JLabel("����");
				 jlabel_password1 = new JLabel("����");
				 jlabel_password2 = new JLabel("����");
				 jlabel_sign = new JLabel("ǩ��");
				 jlabel_sex = new JLabel("�Ա�");
				 j_question = new JLabel(" Сѧ��ҵ�ڣ�");
				 
				 
//				 ʵ������Ť���
				 confirm = new JButton("ȷ��");
				 cancel = new JButton("ȡ��");
				 
				 //ʵ������ѡ
				 man = new JRadioButton(" ��");
				 woman = new JRadioButton(" Ů",true);
				 
//				 ʵ�����ı������
				 question = new JTextField(12);
				 answer = new JTextField(12);
				 userName = new JTextField(12);
				 password1 = new JPasswordField(12);
				 password2 = new JPasswordField(12);
				 account = new JTextField(12);
				 sign = new JTextField(12);
				 
				 
//				 ������岼��
			     act.setLayout(new FlowLayout(FlowLayout.CENTER,10,15));
			     
//				��������С	     
				 act.setPreferredSize(new Dimension(190, 550));
				 
//		            �������뷨
			     userName.enableInputMethods(false);
			     password1.enableInputMethods(false);
			     password2.enableInputMethods(false);
				 
//				 ���͸����
			     act.setOpaque(false);
			     
//			             �ı���͸����
			     account.setOpaque(false);
			     question.setOpaque(false);
			     answer.setOpaque(false);
			     userName.setOpaque(false);
			     password1.setOpaque(false);
			     password2.setOpaque(false);
			     sign.setOpaque(false);
			     man.setOpaque(false);
			     woman.setOpaque(false);
			     
//			     ��������
			     account.setFont(new Font("����",Font.BOLD,18));
			     question.setFont(new Font("����",Font.BOLD,18));
			     answer.setFont(new Font("����",Font.BOLD,18));
			     userName.setFont(new Font("����",Font.BOLD,18));
			     password1.setFont(new Font("����",Font.BOLD,18));
			     password2.setFont(new Font("����",Font.BOLD,18));
			     sign.setFont(new Font("����",Font.BOLD,18));
			     man.setFont(new Font("����",Font.BOLD,18));
			     woman.setFont(new Font("����",Font.BOLD,18));
			     
			     jlabel_account.setFont(new Font("����",Font.BOLD,18));
			     jlabel_question.setFont(new Font("����",Font.BOLD,18));
			     jlabel_answer.setFont(new Font("����",Font.BOLD,18));
			     jlabel_userName.setFont(new Font("����",Font.BOLD,18));
			     jlabel_password1.setFont(new Font("����",Font.BOLD,18));
			     jlabel_password2.setFont(new Font("����",Font.BOLD,18));
			     jlabel_sign.setFont(new Font("����",Font.BOLD,18));
			     jlabel_sex.setFont(new Font("����",Font.BOLD,18));
			     j_question.setFont(new Font("����",Font.BOLD,18));
			     
//			     ����������ɫ
			     jlabel_account.setForeground(Color.white);
			     jlabel_question.setForeground(Color.white);
			     jlabel_answer.setForeground(Color.white);
			     jlabel_userName.setForeground(Color.white);
			     jlabel_password1.setForeground(Color.white);
			     jlabel_password2.setForeground(Color.white);
			     jlabel_sign.setForeground(Color.white);
			     jlabel_sex.setForeground(Color.white);
			     j_question.setForeground(Color.white);
			     
			     account.setForeground(Color.white);
			     question.setForeground(Color.white);
			     answer.setForeground(Color.white);
			     userName.setForeground(Color.white);
			     password1.setForeground(Color.white);
			     password2.setForeground(Color.white);
			     sign.setForeground(Color.white);
			     man.setForeground(Color.white);
			     woman.setForeground(Color.white);
			     
			   //����ѡ��ť��ӵ���ť����
		         bg.add(man);
		         bg.add(woman);
		         
//			            ������
		         act.add(jlabel_account);
		         act.add(account);
			     act.add(jlabel_userName);
			     act.add(userName);
			     act.add(jlabel_password1);
			     act.add(password1);
			     act.add(jlabel_password2);
			     act.add(password2);
			     act.add(jlabel_question);
			     //act.add(question);
			     act.add(question);
			     act.add(jlabel_answer);
			     act.add(answer);
			     act.add(jlabel_sign);
			     act.add(sign);
			     act.add(jlabel_sex);
			     act.add(man);
			     act.add(woman);
			     act.add(confirm);
			     act.add(cancel);
				 
//				 ��Ӽ���

				 confirm.addActionListener(this);
				 cancel.addActionListener(this);
				 userName.addMouseListener(this);
				 

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
				if(e.getSource() == userName) 
				{
					userName.setText("");
				}
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
				else 
				{
					String sex;
					if(man.isSelected() == true) sex="��";
					else sex="Ů";
					Users u = new Users(account.getText(), new String(password2.getPassword()), userName.getText(),
										sex, 1, sign.getText(), question.getText(), answer.getText());
					try {
						registers rs = new registers(s, u);
						
						if(rs.bl == true)
						{
						
						JOptionPane.showMessageDialog(null, "ע��ɹ���ȷ�����ص�¼"); 
						this.dispose();
						d.dispose();
						new Login();
						}
						else {
							JOptionPane.showMessageDialog(null, "�ʺŴ���"); 
							connect = new ClientConnect();
							this.s = connect.getS();
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			public void keyPressed(KeyEvent arg0) {
				// TODO �Զ����ɵķ������
				
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO �Զ����ɵķ������
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO �Զ����ɵķ������
				
			}
			 
			 

	}

