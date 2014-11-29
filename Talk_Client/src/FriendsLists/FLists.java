package FriendsLists;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

import view.WinChat;
import common.Friends;
import common.MessageType;
import control.ManageThread;
public class FLists extends JFrame  implements ActionListener,MouseListener ,MouseMotionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3271267402980802084L;
//	面板
	JPanel back,head,body,top;
//	标签
	JLabel headjlabel,signjlabel,remind;
//	按扭
	JButton button_min,button_exit;
//	点坐标
	Point origin = new Point();
	JTree tree;
	Socket s;
	MessageType U;
	String myaccount;
    JPopupMenu popMenu,popMenu1;
    JMenuItem addItem;
    JMenuItem delItem;
    JMenuItem editItem;
    IconNode node;
    IconNode root1,root2,root3,root4,root5;
    HashMap<IconNode, Integer > hash = new HashMap<IconNode, Integer >();
    HashMap<String, IconNode > hash1 = new HashMap<String, IconNode >();
	HashMap<String, Friends> map1=new HashMap<String,Friends>();
	HashMap<String, Friends> map2=new HashMap<String,Friends>();
	public Vector<MessageType> vt = new Vector<MessageType>();
    int group;
   public FLists( MessageType U)
   {
	   this.U=U;
	   this.myaccount = U.Userdata.getId();
//		 组件要的图片
		 ImageIcon headimage = new ImageIcon("src/image/touxiang.jpg");
		 ImageIcon min = new ImageIcon("src/image/min.png");
		 ImageIcon exit = new ImageIcon("src/image/exit.png");
	 
//		 实例化面板组件
		 back  = new JPanel();
		 top = new JPanel();
		 head = new JPanel();
		 body = new JPanel();
		 
//		 实例化标签组件
		 headjlabel  = new JLabel(headimage);
		 signjlabel = new JLabel(U.Userdata.getSign());
		 remind = new JLabel("提醒");
		 
//		 实例化按扭组件
		 button_min  = new JButton(min);
		 button_exit = new JButton(exit);
		 
		 
//		 设置面板布局
		 top.setLayout(new FlowLayout(FlowLayout.RIGHT,1,5));
	     head.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 1));
	     body.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
	     
//		设置面板大小	     
		 top.setPreferredSize(new Dimension(300, 30));
		 head.setPreferredSize(new Dimension(300, 120));
		 
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
		 
		 signjlabel.setFont(new Font("雅黑",Font.BOLD,20));
		 signjlabel.setForeground(Color.WHITE);
		 remind.setFont(new Font("雅黑",Font.BOLD,20));
		 remind.setForeground(Color.YELLOW);
		 
//		 去除边框
	     this.setUndecorated(true);
	     
//	            添加组件
	     
	     top.add(button_min);
	     top.add(button_exit);
		 head.add(headjlabel);
		 head.add(signjlabel);
		 head.add(remind);
		 back.add(top,BorderLayout.NORTH);
		 back.add(head,BorderLayout.CENTER);
		 back.add(body,BorderLayout.SOUTH);
		 this.add(back);
		 
//		 添加监听
		 button_min.addActionListener(this);
		 button_exit.addActionListener(this);
		 back.addMouseListener(this);
		 back.addMouseMotionListener(this);
		 remind.addMouseListener(this);
		 
//		 JFrame容器配色
		 this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
//		 设置大小，位置
		 this.setBounds(500, 300, 300, 600);
		 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	             设置可见
		 this.setVisible(true);
	       popMenu = new JPopupMenu();
	       popMenu1 = new JPopupMenu();
	       addItem = new JMenuItem("添加");
	       delItem = new JMenuItem("删除");
	       editItem = new JMenuItem("修改密码");
	       popMenu.add(delItem);
	       popMenu.add(editItem);
	       popMenu1.add(addItem);
	       addItem.addActionListener(this);
	       delItem.addActionListener(this);
	       editItem.addActionListener(this);
	   JPanel jj = new JPanel();
	   jj.setOpaque(false);
	   jj.setLayout(new BorderLayout());
	   root1=new IconNode(new ImageIcon("src/image/qq1.png"),"我的好友"); 
	   root2=new IconNode(new ImageIcon("src/image/qq1.png"),"我的同学"); 
	   root3=new IconNode(new ImageIcon("src/image/qq1.png"),"我的家人");
	   root4=new IconNode(new ImageIcon("src/image/qq1.png"),"我的老师");
	   root5=new IconNode(new ImageIcon("src/image/qq1.png"),"特别的");
	   hash.put(root1, 1); hash1.put("1", root1);
	   hash.put(root2, 2); hash1.put("2", root2);
	   hash.put(root3, 3); hash1.put("3", root3);
	   hash.put(root4, 4); hash1.put("4", root4);
	   hash.put(root5, 5); hash1.put("5", root5);
	   //把我的好友放进哈希表里去

	   if(U.Userdata.getFriend()!=null)
	   {
		   for(int i=0;i<U.Userdata.getFriend().size();i++)
	   {
		   if(U.Userdata.getFriend().get(i).getTemp()==1)
		      map1.put(U.Userdata.getFriend().get(i).getId(), U.Userdata.getFriend().get(i));
		   else
			   map2.put(U.Userdata.getFriend().get(i).getId(), U.Userdata.getFriend().get(i));
	   }
	   
       for(int i = 0;i<U.Userdata.getFriend().size();i++)
       {
  	   //当flag是1的时候就放在"我的好友"列表里；当flag是2的时候就放在我的同学列表里面；当flag是3的时候就放在我的家人里面；
  	   //当flag是4的时候就放在我的老师列表里面；当flag是5的时候就放在特别的列表里面
  	   //同时，为了方便，这里我们直接用文字标识是在线还是离线，在线的在后面加上在线，离线的在后面加上离线
    	   if(U.Userdata.getFriend().get(i).getTemp()==1){
  	   switch(U.Userdata.getFriend().get(i).getFlag())
  	   {
  	   case 1:
  		      if(U.Userdata.getFriend().get(i)!=null)
  		      {root1.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId()));}
  		      break;
  	   case 2:
  		      if(U.Userdata.getFriend().get(i)!=null)
  	          {root2.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId())); }
  		      break;
  	   case 3:
  		      if(U.Userdata.getFriend().get(i)!=null)
  	          {root3.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId())); }
  		      break;
  	   case 4:
  		     if(U.Userdata.getFriend().get(i)!=null)
  	          {root4.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId())); }
  		     break;
  	   case 5:
  		    if(U.Userdata.getFriend().get(i)!=null)
  	          {root5.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId())); }
  		     break;
  		     default:
  		    	    break;
  	   }
     }}
     for(int i = 0;i<U.Userdata.getFriend().size();i++)
     {
    	 if(U.Userdata.getFriend().get(i).getTemp()==0){
  	   //当flag是1的时候就放在"我的好友"列表里；当flag是2的时候就放在我的同学列表里面；当flag是3的时候就放在我的家人里面；
  	   //当flag是4的时候就放在我的老师列表里面；当flag是5的时候就放在特别的列表里面
  	   //同时，为了方便，这里我们直接用文字标识是在线还是离线，在线的在后面加上在线，离线的在后面加上离线
  	   switch(U.Userdata.getFriend().get(i).getFlag())
  	   {
  	   case 1:
  		      if(U.Userdata.getFriend().get(i)!=null)
  		      {root1.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId())); }
  		      break;
  	   case 2:
  		      if(U.Userdata.getFriend().get(i)!=null)
  	          {root2.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId())); }
  		      break;
  	   case 3:
  		      if(U.Userdata.getFriend().get(i)!=null)
  	          {root3.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId())); }
  		      break;
  	   case 4:
  		     if(U.Userdata.getFriend().get(i)!=null)
  	          {root4.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId())); }
  		     break;
  	   case 5:
  		    if(U.Userdata.getFriend().get(i)!=null)
  	          {root5.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId())); }
  		     break;
  		     default:
  		    	    break;
  	   }
     }
     }
	   }
//     U.setPpppp(1);
//	 }
//	 //当U.getppppp()==1的时候，表示不是刚刚才登陆的，这时只需传上线的朋友过来
//	 else
//	 {
//		Iterator it=map2.keySet().iterator();
//		Iterator is=map1.keySet().iterator();
//		while(it.hasNext())
//		{
//			if(it.next().equals(1))
//			{
//				map1.put(1, map2.get(it.next()));
//				map2.remove(it.next());
//			}
//		}
//		while(is.hasNext())
//		{
//			if(is.next().equals(0))
//			{
//				map2.put(0, map1.get(is.next()));
//				map1.remove(it.next());
//			}
//		}
//	 }

//	   ImageIcon image=new ImageIcon("img/qq1.png");
//	   for(int i=0;i<U.Userdata.getMygoodFriend().length;i++)
//	   {
//		   root1.add(new IconNode(U.Userdata.getMygoodFriend()[i].getHeadicon(),U.Userdata.getMygoodFriend()[i].getName()));
//	   }
//	   for(int i=0;i<U.Userdata.getMyclassmates().length;i++)
//	   {
//		   root2.add(new IconNode(U.Userdata.getMyclassmates()[i].getHeadicon(),U.Userdata.getMyclassmates()[i].getName()));
//	   }
//	   for(int i=0;i<U.Userdata.getMyfamily().length;i++)
//	   {
//		   root3.add(new IconNode(U.Userdata.getMyfamily()[i].getHeadicon(),U.Userdata.getMyfamily()[i].getName()));
//	   }
//	   for(int i=0;i<U.Userdata.getMyteachers().length;i++)
//	   {
//		   root4.add(new IconNode(U.Userdata.getMyteachers()[i].getHeadicon(),U.Userdata.getMyteachers()[i].getName()));
//	   }
//	   for(int i=0;i<U.Userdata.getMyowns().length;i++)
//	   {
//		   root5.add(new IconNode(U.Userdata.getMyowns()[i].getHeadicon(),U.Userdata.getMyowns()[i].getName()));
//	   }
//	   for(int i=0;i<U.Addonline.getOnlinepeople().length;i++)
//	   {
//		   switch(U.Addonline.getOnlinepeople()[i].getFlag())
//		   {
//		   case 1:root1.add(new IconNode(U.Addonline.getOnlinepeople()[i].getHeadicon(),U.Addonline.getOnlinepeople()[i].getName()));
//		          break;
//		   case 2:root2.add(new IconNode(U.Addonline.getOnlinepeople()[i].getHeadicon(),U.Addonline.getOnlinepeople()[i].getName()));
//		          break;
//		   case 3:root3.add(new IconNode(U.Addonline.getOnlinepeople()[i].getHeadicon(),U.Addonline.getOnlinepeople()[i].getName()));
//		          break;
//		   case 4:root4.add(new IconNode(U.Addonline.getOnlinepeople()[i].getHeadicon(),U.Addonline.getOnlinepeople()[i].getName()));
//		          break;
//		   case 5:root5.add(new IconNode(U.Addonline.getOnlinepeople()[i].getHeadicon(),U.Addonline.getOnlinepeople()[i].getName()));
//		          break;
//			   default:break;
//		   }
//	   }
	   IconNode Root=new IconNode(null,null);//定义根节点 
	   Root.add(root1);//定义二级节点
	   Root.add(root2);//定义二级节点   
	   Root.add(root3);
	   Root.add(root4);
	   Root.add(root5);
	   tree = new JTree(Root);//定义树   
	   tree.setCellRenderer(new IconNodeRenderer()); //设置单元格描述  
	   tree.setEditable(false); //设置树是否可编辑  
	   tree.setRootVisible(false);//设置树的根节点是否可视
	   tree.setToggleClickCount(1);//设置单击几次展开数节点 
	   tree.putClientProperty("JTree.lineStyle" , "Angeled");
	   tree.setShowsRootHandles(true);
	   tree.setRootVisible(true);
	  // DefaultTreeCellRenderer cellRenderer = new DefaultTreeCellRenderer();
	   DefaultTreeCellRenderer  cellRenderer=(DefaultTreeCellRenderer)tree.getCellRenderer();//获取该树的Renderer  
	   cellRenderer.setClosedIcon(new ImageIcon("img/xiaotouxiang.jpg"));//关闭打开图标 
	   cellRenderer.setOpenIcon(new ImageIcon("img/xiaotouxiang.jpg"));//设置展开图标
	   cellRenderer.setBackgroundNonSelectionColor(new Color(0, 0, 0, 0));
	   cellRenderer.setBackgroundSelectionColor(new Color(0, 0, 0, 0));
	   tree.addMouseListener(this);
	   JScrollPane sp = new JScrollPane(tree);
	   jj.add(sp);
	   jj.setPreferredSize(new Dimension(300, 400));
	   tree.setOpaque(false);
	   sp.setOpaque(false);
	   sp.getViewport().setOpaque(false);
       body.add(jj);
       
     }
   
   public static void main(String args[])
   {
	   new FLists(null);
   }
public void mouseDragged(MouseEvent e) {
	// TODO 自动生成的方法存根
	if(e.getY()<=100)
	{Point p = getLocation();  //当鼠标拖动时获取窗口当前位置
    //设置窗口的位置
    //窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
    setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);

	}
}
public void mouseMoved(MouseEvent arg0) {
	// TODO 自动生成的方法存根
	
}
public void mouseClicked(MouseEvent e) {
	// TODO 自动生成的方法存根
	TreePath path = tree.getPathForLocation(e.getX(), e.getY());
	node = (IconNode) path.getLastPathComponent();
	int mods = e.getModifiers();
	if(e.getSource() == remind &&vt!=null)
	{
		switch(vt.lastElement().getFlag())
		{
		case 2: 
			String sss = myaccount+"->"+vt.lastElement().Message.getFromwho();
			WinChat wc = ManageThread.GetchatFromMap(sss);
			if(wc!=null) 
			{
				System.out.println(U.Message.getFromwho()+"->"+U.Message.getTowho());
				wc.noedit.append(vt.lastElement().Message.getFromwho()+": "+vt.lastElement().Message.getMessage()+"\n");
			}
			else{
			WinChat wcc =new WinChat(myaccount,vt.lastElement().Message.getFromwho());
			wcc.noedit.append(vt.lastElement().Message.getFromwho()+": "+vt.lastElement().Message.getMessage()+"\n");
			   ManageThread.AddChatToMap(sss, wcc);
			}
			vt.remove(vt.size()-1);
			break;
		case 7:
			String group1;
			int res = JOptionPane.showConfirmDialog(null, vt.lastElement().getId()+"想加你为好友，是否同意？");
			if(res == JOptionPane.NO_OPTION||res ==JOptionPane.CANCEL_OPTION)  vt.lastElement().setFlag(9);
			else {
				group1=JOptionPane.showInputDialog(null,"请输1，2，3，4，5：","选择分组",JOptionPane.QUESTION_MESSAGE);
				vt.lastElement().setFlag(8);
				vt.lastElement().Users.setSign(group1);
			}
			try {
				ObjectOutputStream oos = new ObjectOutputStream(ManageThread.Getthreadfrommap(myaccount).s.getOutputStream());
				oos.writeObject(vt.lastElement());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			vt.remove(vt.size()-1);
			break;
		}
		if(!vt.isEmpty())
		{
			switch(vt.lastElement().getFlag())
			{
				case 2: remind.setText("你有新的消息！");break;
				case 7: remind.setText("你有新的提醒！");break;
			}
		}
		else remind.setText("提醒");
		
	}
	else if(e.getClickCount() == 2){
		   if(node.isLeaf())
		   {System.out.println(node.getText());
		   System.out.println("1"+myaccount+" "+node.getText()+"/n");
		   String ss = myaccount+"->"+node.getText();
		   WinChat wc =new WinChat(myaccount,node.getText());
		   ManageThread.AddChatToMap(ss, wc);}
	}
	else if ((mods & InputEvent.BUTTON3_MASK) != 0)
	{
		if(node == root1 ||node == root2 ||node == root3||node == root4||node == root5)		
		{	
			group =(Integer)hash.get(node);
			popMenu1.show(tree, e.getX(), e.getY());node = null;
		}
		else if(node!=null)
			{
			popMenu.show(tree, e.getX(), e.getY());
			node = null;
			}
		else{node = null;}
	}
	else
	{
		   System.out.println(node.getText());
	}
}
public void mouseEntered(MouseEvent arg0) {
	// TODO 自动生成的方法存根
	
}
public void mouseExited(MouseEvent arg0) {
	// TODO 自动生成的方法存根
	
}
public void mousePressed(MouseEvent e) {
	// TODO 自动生成的方法存根
	origin.x = e.getX();  //当鼠标按下的时候获得窗口当前的位置
    origin.y = e.getY();
}
public void mouseReleased(MouseEvent arg0) {
	
}
public void actionPerformed(ActionEvent e) {
	// TODO 自动生成的方法存根
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
	else if(e.getSource() == addItem)
	{
		try {
			String input = JOptionPane.showInputDialog(null,"好友帐号","添加好友",JOptionPane.OK_CANCEL_OPTION);
			ObjectOutputStream oos = new ObjectOutputStream(ManageThread.Getthreadfrommap(myaccount).s.getOutputStream()); 
			MessageType m = new MessageType();
			m.setFlag(7);
			m.setId(myaccount);
			m.Users.setId(input);
			m.Users.setSex(String.valueOf(group));
			oos.writeObject(m);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
}
//添加好友
public void addperson(MessageType U)
{
	IconNode in = (IconNode)hash1.get(U.Users.getPassword());
	Friends f = new Friends();
	f.setdata(U.Users.getId(), U.Users.getName(), U.Users.getSign(), U.Users.getHeadicon());
	in.add(new IconNode(f.getHeadicon(),f.getId()));
	this.map1.put(f.getId(), f);
	tree.updateUI();
}

public void remindtofl(MessageType U)
{
	vt.add(U);
	switch(U.getFlag())
	{
		case 2: remind.setText("你有新的消息！");break;
		case 7: remind.setText("你有新的提醒！");break;
	}
}

//public void add_remind()

}