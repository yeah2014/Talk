//package view;
//
//import javax.swing.*;
//import java.awt.*;
//import common.*;
//import java.awt.event.*;
//
//public class Friendslist  extends JFrame  implements ActionListener,MouseListener ,MouseMotionListener{
//	 /**
//	 * 
//	 */
//	
//	private static final long serialVersionUID = 1L;
////	定义模板需要的组件
////	面板
//	JPanel back,head,body,top;
////	标签
//	JLabel headjlabel,sign;
////	滚动条
//	JScrollPane jsp;
////	按扭
//	JButton button_min,button_exit;
//	JButton online , leaveline;
//	JButton onlines , leavelines;
//	//	点坐标
//	Point origin = new Point(); 
//	
//	Font font = new Font("雅黑",Font.BOLD,12);
//	CardLayout c;
//	 public Friendslist(MessageType U)
//	 {
//		 
//		 this.add(demo(U));
////		 去除边框
//	     this.setUndecorated(true);
//	     
////		 添加监听
//		 button_min.addActionListener(this);
//		 button_exit.addActionListener(this);
//		 back.addMouseListener(this);
//		 back.addMouseMotionListener(this);
//		 
////		 JFrame容器配色
//		 this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
////		 设置大小，位置
//		 this.setBounds(500, 300, 300, 600);
//		 
//		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////	             设置可见
//		 this.setVisible(true);
//	 }
//	 
//	 
//	 public JPanel demo(MessageType U)
//	 {
////		 组件要的图片
//		 ImageIcon headimage = U.Userdata.getHeadicon();
////		 ImageIcon headimage = new ImageIcon("D://Desktop/touxiang.jpg");
//		 ImageIcon min = new ImageIcon("D://Desktop/6.png");
//		 ImageIcon exit = new ImageIcon("D://Desktop/7.png");
////		 实例化面板组件
//		 back  = new JPanel();
//		 top = new JPanel();
//		 head = new JPanel();
//		 body = new JPanel();
////		 实例化标签组件
//		 headjlabel  = new JLabel(headimage);
//		 sign = new JLabel(U.Userdata.getSign());
////		 实例化按扭组件
//		 button_min  = new JButton(min);
//		 button_exit = new JButton(exit);
//		 
//		 jsp = new JScrollPane();	
//		 
////		 设置面板布局
//		 top.setLayout(new FlowLayout(FlowLayout.RIGHT,1,1));
//	     head.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
//	     
////		设置面板大小	     
//		 top.setPreferredSize(new Dimension(300, 30));
//		 head.setPreferredSize(new Dimension(300, 60));
//
////		 设置按扭大小
//		 button_min.setPreferredSize(new Dimension(min.getIconWidth(), min.getIconHeight()));
//		 button_exit.setPreferredSize(new Dimension(exit.getIconWidth(), exit.getIconHeight()));
//
////		 按扭透明化
//		 button_min.setContentAreaFilled(false);
//		 button_exit.setContentAreaFilled(false);
//	 
////		 个性签名设置
//	     sign.setFont(new Font("楷体",Font.BOLD,18));
//	     sign.setForeground(Color.white);
//		 
//	     back.setLayout(new FlowLayout(FlowLayout.CENTER));
//	     
//	     c = new CardLayout();
//	     
//	     body.setLayout(c);
//	     body.add(initonline(U),"online");
//	     body.add(initleaveline(U),"leaveline");
//	     
//	     top.add(button_min);
//	     top.add(button_exit);
//		 head.add(headjlabel);
//		 back.add(top);
//		 back.add(head);
//		 back.add(sign);
//		 back.add(body);
//		 
//		 
////		 面板透明化
//		 back.setOpaque(false);
//		 head.setOpaque(false);
//		 body.setOpaque(false);
//		 top.setOpaque(false);
//		 
//		 return back;
//	 }
//	 
//	 public JPanel initonline(MessageType U)
//	 {
//		 JPanel back , list ,list1;
//		 JScrollPane jScrollPane;
//		 JLabel []friends;
//		 
//		 back = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
//		 list = new JPanel();
//		 list1 = new JPanel(new BorderLayout());
//		 
//		 online = new JButton("在线好友");
//		 leaveline = new JButton("离线好友");
//		 
//		 list = new JPanel(new GridLayout(U.Userdata.getFriend().length, 1, 4, 4));
//		 
//		 friends = new JLabel[U.Userdata.getFriend().length];
//		 
//		 for(int i = 0 ; i < friends.length ; i++)
//		 {
//			 friends[i] = new JLabel(U.Userdata.getFriend()[i].getFriendsign()+"  ("+
//					 		U.Userdata.getFriend()[i].getName()+") "+U.Userdata.getFriend()[i].getFriendsign(),
//					 		U.Userdata.getFriend()[i].getHeadicon(),JLabel.LEFT);
//			 friends[i].setForeground(Color.white);
//			 friends[i].setFont(font);
//			 list.add(friends[i]);
////			 friends[i].setEnabled(true);
//		 }
//		 back.setPreferredSize(new Dimension(300,500));
//		 list1.setPreferredSize(new Dimension(300, 400));
//		 online.setPreferredSize(new Dimension(300, 30));
//		 leaveline.setPreferredSize(new Dimension(300, 30));
//		 
//		 jScrollPane = new JScrollPane(list);
//		 
//		 list1.add(jScrollPane);
//		 back.add(online);
//		 back.add(list1);
//		 back.add(leaveline);
//		 
//		 online.addActionListener(this);
//		 leaveline.addActionListener(this);
//		 
//		 jScrollPane.getVerticalScrollBar().setUnitIncrement(30);
//		 online.setForeground(Color.white);
//		 leaveline.setForeground(Color.white);
//	     online.setFont(font);
//	     leaveline.setFont(font);
//		 
//		 back.setOpaque(false);
//		 list.setOpaque(false);
//		 list1.setOpaque(false);
//		 jScrollPane.setOpaque(false);
//		 jScrollPane.getViewport().setOpaque(false);
//		 online.setContentAreaFilled(false);
//		 leaveline.setContentAreaFilled(false);
//		 
//		 return back;
//	 }
//	 
//	 public JPanel initleaveline(MessageType U)
//	 {
//		 JPanel back , list ,list1;
//		 JScrollPane jScrollPane;
//		 JLabel []friends;
//		 
//		 back = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
//		 list = new JPanel();
//		 list1 = new JPanel(new BorderLayout());
//		 
//		 onlines = new JButton("在线好友");
//		 leavelines = new JButton("离线好友");
//		 
//		 list = new JPanel(new GridLayout(U.Userdata.getFriend().length, 1, 4, 4));
//		 
//		 friends = new JLabel[U.Userdata.getFriend().length];
//		 
//		 for(int i = 0 ; i < friends.length ; i++)
//		 {
//			 friends[i] = new JLabel(U.Userdata.getFriend()[i].getFriendsign()+"  ("+
//					 		U.Userdata.getFriend()[i].getName()+") "+U.Userdata.getFriend()[i].getFriendsign(),
//					 		U.Userdata.getFriend()[i].getHeadicon(),JLabel.LEFT);
//			 friends[i].setForeground(Color.white);
//			 friends[i].setFont(font);
//			 list.add(friends[i]);
////			 friends[i].setEnabled(false);
//		 }
//		 back.setPreferredSize(new Dimension(300,500));
//		 list1.setPreferredSize(new Dimension(300, 400));
//		 onlines.setPreferredSize(new Dimension(300, 30));
//		 leavelines.setPreferredSize(new Dimension(300, 30));
//		 
//		 jScrollPane = new JScrollPane(list);
//		 
//		 list1.add(jScrollPane);
//		 back.add(onlines);
//		 back.add(leavelines);
//		 back.add(list1);
//		 
//		 onlines.addActionListener(this);
//		 leavelines.addActionListener(this);
//		 
//		 jScrollPane.getVerticalScrollBar().setUnitIncrement(30);
//		 onlines.setForeground(Color.white);
//		 leavelines.setForeground(Color.white);
//	     onlines.setFont(font);
//	     leavelines.setFont(font);
//
//		 
//		 back.setOpaque(false);
//		 list.setOpaque(false);
//		 list1.setOpaque(false);
//		 jScrollPane.setOpaque(false);
//		 jScrollPane.getViewport().setOpaque(false);
//		 onlines.setContentAreaFilled(false);
//		 leavelines.setContentAreaFilled(false);
//		 
//		 return back;
//	 } 
//	 
//	 
//	 
//	 
//	 
//	 public static void main(String []a)
//	 {
//		 new Friendslist(null);
//	 }
//	 
//	
//	public void mouseDragged(MouseEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getY()<=100)
//		{Point p = getLocation();  //当鼠标拖动时获取窗口当前位置
//        //设置窗口的位置
//        //窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
//        setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
//	
//		}
//	}
//	public void mouseMoved(MouseEvent e) {
//		// TODO Auto-generated method stub
//	}
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//	}
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		origin.x = e.getX();  //当鼠标按下的时候获得窗口当前的位置
//        origin.y = e.getY();
//
//	}
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//	}
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//	}
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource()==button_min) this.setExtendedState(Frame.ICONIFIED);
//		else if(e.getSource() == button_exit) 
//			System.exit(0);
//		else if(e.getSource() == onlines)
//			c.show(body, "online");
//		else if(e.getSource() == leaveline)
//			c.show(body, "leaveline");
//	}
//	 
//	 
//}
