/*
 * �޸��������
 */
package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
public class MiMa extends JFrame  implements ActionListener,MouseListener ,MouseMotionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 879179576852195833L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiMa(null);
	}

//			�������
//			���
			JPanel act;
//			��ǩ
			JLabel jlabel_password1,jlabel_password;
//			�ı���
			JPasswordField  account , password;
//			��Ť
			JButton register,enter;
			Socket s;
			 public MiMa(Socket s)
			 {
				 this.s = s;
//				 ʵ����������
				 act = new JPanel();
				 
//				 ʵ������ǩ���
				 jlabel_password1 = new JLabel("������");
				 jlabel_password = new JLabel("������");
				 
//				 ʵ������Ť���
				 register = new JButton("ȷ��");
				 enter = new JButton("ȡ��");
				 
//				 ʵ�����ı������
				 account = new JPasswordField(12);
				 password = new JPasswordField(12);
				 
//				 ������岼��
			     act.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
			     
//				��������С	     
				 act.setPreferredSize(new Dimension(200, 300));
				 
//				 ���͸����
			     act.setOpaque(false);
			     
//			             �ı���͸����
			     account.setOpaque(false);
			     password.setOpaque(false);
			     
			     //���뷨����
			     account.enableInputMethods(false);
			     password.enableInputMethods(false);
			     
//			     ��������
			     account.setFont(new Font("����",Font.BOLD,18));
			     password.setFont(new Font("����",Font.BOLD,18));
			     jlabel_password1.setFont(new Font("����",Font.BOLD,18));
			     jlabel_password.setFont(new Font("����",Font.BOLD,18));
//			     ����������ɫ
			     jlabel_password1.setForeground(Color.white);
			     jlabel_password.setForeground(Color.white);
			     account.setForeground(Color.white);
			     password.setForeground(Color.white);
			     
//			            ������
			     act.add(new JLabel("���Ȳ�����12�ķǺ����ַ�"));
			     act.add(jlabel_password1);
			     act.add(account);
			     act.add(jlabel_password);
			     act.add(password);
			     act.add(register);
			     act.add(enter);
				 
//				 ��Ӽ���
				 register.addActionListener(this);
				 enter.addActionListener(this);
				 
				 new demo(act,s);
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
				
			}
			 
			 

	}

