package view;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

public class demo extends JFrame  implements ActionListener,MouseListener ,MouseMotionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4064124909812386914L;
	public static void main(String a[])
	{
		new demo(null,null);
	}
			
//			�������
//			���
			JPanel back,head,body,top;
//			��ǩ
			JLabel headjlabel;
//			��Ť
			JButton button_min,button_exit;
//			������
			Point origin = new Point();
			Socket s;

			 public demo(JPanel act,Socket s)
			 {
				 this.s = s;
//				 ���Ҫ��ͼƬ
				 ImageIcon headimage = new ImageIcon(demo.class.getResource("/image/touxiang.jpg"));
				 ImageIcon min = new ImageIcon(demo.class.getResource("/image/min.png"));
				 ImageIcon exit = new ImageIcon(demo.class.getResource("/image/exit.png"));
			 
//				 ʵ����������
				 back  = new JPanel();
				 top = new JPanel();
				 head = new JPanel();
				 body = new JPanel();
				 
//				 ʵ������ǩ���
				 headjlabel  = new JLabel(headimage);
				 
//				 ʵ������Ť���
				 button_min  = new JButton(min);
				 button_exit = new JButton(exit);
				 
				 
//				 ������岼��
				 top.setLayout(new FlowLayout(FlowLayout.RIGHT,1,5));
			     head.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
			     body.setLayout(new FlowLayout(FlowLayout.CENTER,0,50));
			     
//				��������С	     
				 top.setPreferredSize(new Dimension(300, 30));
				 head.setPreferredSize(new Dimension(300, 60));
				 
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
			     
//				 ȥ���߿�
			     this.setUndecorated(true);
			     
//			            ������
			     if(act!=null)
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
				 
//				 JFrame������ɫ
				 this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
//				 ���ô�С��λ��
				 this.setBounds(500, 300, 300, 600);
				 
				 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			             ���ÿɼ�
				 this.setVisible(true);
				 setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
		        if(e.getButton()==3) System.out.println("123");

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
				{
					try {
						if(s !=null)
						{s.close();System.out.println("�ѹر�����");}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
				}
				
			}
			 
			 

	}

