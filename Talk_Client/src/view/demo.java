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
			
//			定义组件
//			面板
			JPanel back,head,body,top;
//			标签
			JLabel headjlabel;
//			按扭
			JButton button_min,button_exit;
//			点坐标
			Point origin = new Point();
			Socket s;

			 public demo(JPanel act,Socket s)
			 {
				 this.s = s;
//				 组件要的图片
				 ImageIcon headimage = new ImageIcon(demo.class.getResource("/image/touxiang.jpg"));
				 ImageIcon min = new ImageIcon(demo.class.getResource("/image/min.png"));
				 ImageIcon exit = new ImageIcon(demo.class.getResource("/image/exit.png"));
			 
//				 实例化面板组件
				 back  = new JPanel();
				 top = new JPanel();
				 head = new JPanel();
				 body = new JPanel();
				 
//				 实例化标签组件
				 headjlabel  = new JLabel(headimage);
				 
//				 实例化按扭组件
				 button_min  = new JButton(min);
				 button_exit = new JButton(exit);
				 
				 
//				 设置面板布局
				 top.setLayout(new FlowLayout(FlowLayout.RIGHT,1,5));
			     head.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
			     body.setLayout(new FlowLayout(FlowLayout.CENTER,0,50));
			     
//				设置面板大小	     
				 top.setPreferredSize(new Dimension(300, 30));
				 head.setPreferredSize(new Dimension(300, 60));
				 
//				 设置按扭大小
				 button_min.setPreferredSize(new Dimension(min.getIconWidth(), min.getIconHeight()));
				 button_exit.setPreferredSize(new Dimension(exit.getIconWidth(), exit.getIconHeight()));

//				 按扭透明化
				 button_min.setContentAreaFilled(false);
				 button_exit.setContentAreaFilled(false);
				 
//				 面板透明化
				 back.setOpaque(false);
				 head.setOpaque(false);
				 body.setOpaque(false);
				 top.setOpaque(false);
			     
//				 去除边框
			     this.setUndecorated(true);
			     
//			            添加组件
			     if(act!=null)
			     body.add(act);
			     top.add(button_min);
			     top.add(button_exit);
				 head.add(headjlabel);
				 back.add(top,BorderLayout.NORTH);
				 back.add(head,BorderLayout.CENTER);
				 back.add(body,BorderLayout.SOUTH);
				 this.add(back);
				 
//				 添加监听
				 button_min.addActionListener(this);
				 button_exit.addActionListener(this);
				 back.addMouseListener(this);
				 back.addMouseMotionListener(this);
				 
//				 JFrame容器配色
				 this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
//				 设置大小，位置
				 this.setBounds(500, 300, 300, 600);
				 
				 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			             设置可见
				 this.setVisible(true);
				 setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
						{s.close();System.out.println("已关闭连接");}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
				}
				
			}
			 
			 

	}

