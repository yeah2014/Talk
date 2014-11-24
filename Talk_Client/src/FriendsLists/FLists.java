package FriendsLists;
import java.awt.BorderLayout;  
import java.io.IOException;
import java.net.*;
import java.awt.*;

import common.*;

import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*; 
import javax.swing.tree.DefaultTreeCellRenderer; 
import javax.swing.tree.TreePath;  

import control.ManageThread;
import view.WinChat;
public class FLists extends JFrame  implements ActionListener,MouseListener ,MouseMotionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3271267402980802084L;
//	面板
	JPanel back,head,body,top;
//	标签
	JLabel headjlabel;
//	按扭
	JButton button_min,button_exit;
//	点坐标
	Point origin = new Point();
	JTree tree;
	Socket s;
	MessageType U;
    JPopupMenu popMenu,popMenu1;
    JMenuItem addItem;
    JMenuItem delItem;
    JMenuItem editItem;
    IconNode node;
    IconNode root1,root2,root3,root4,root5;
   public FLists( MessageType U)
   {
	   this.U=U;
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
		 
//		 实例化按扭组件
		 button_min  = new JButton(min);
		 button_exit = new JButton(exit);
		 
		 
//		 设置面板布局
		 top.setLayout(new FlowLayout(FlowLayout.RIGHT,1,5));
	     head.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
	     body.setLayout(new FlowLayout(FlowLayout.CENTER,0,50));
	     
//		设置面板大小	     
		 top.setPreferredSize(new Dimension(300, 30));
		 head.setPreferredSize(new Dimension(300, 60));
		 
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
	     
//		 去除边框
	     this.setUndecorated(true);
	     
//	            添加组件
	     
	     top.add(button_min);
	     top.add(button_exit);
		 head.add(headjlabel);
		 back.add(top,BorderLayout.NORTH);
		 back.add(head,BorderLayout.CENTER);
		 back.add(body,BorderLayout.SOUTH);
		 this.add(back);
		 
//		 添加监听
		 button_min.addActionListener(this);
		 button_exit.addActionListener(this);
		 back.addMouseListener(this);
		 back.addMouseMotionListener(this);
		 
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
	       addItem.addActionListener(this);
	       delItem = new JMenuItem("删除");
	       delItem.addActionListener(this);
	       editItem = new JMenuItem("修改密码");
	       editItem.addActionListener(this);
	       //popMenu.add(addItem);
	       popMenu.add(delItem);
	       popMenu.add(editItem);
	       popMenu1.add(addItem);
	   JPanel jj = new JPanel();
	   jj.setOpaque(false);
	   jj.setLayout(new BorderLayout());
	   root1=new IconNode(new ImageIcon("src/image/qq1.png"),"我的好友"); 
	   root2=new IconNode(new ImageIcon("src/image/qq1.png"),"我的同学"); 
	   root3=new IconNode(new ImageIcon("src/image/qq1.png"),"我的家人");
	   root4=new IconNode(new ImageIcon("src/image/qq1.png"),"我的老师");
	   root5=new IconNode(new ImageIcon("src/image/qq1.png"),"特别的");
	   //把我的好友放进哈希表里去
	   HashMap<String, Friends> map1=new HashMap<String,Friends>();
	   HashMap<String, Friends> map2=new HashMap<String,Friends>();
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
  		      {root1.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId()));U.Userdata.getFriend().get(i).setFlag1(1);}
  		      break;
  	   case 2:
  		      if(U.Userdata.getFriend().get(i)!=null)
  	          {root2.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId()));U.Userdata.getFriend().get(i).setFlag1(1);}
  		      break;
  	   case 3:
  		      if(U.Userdata.getFriend().get(i)!=null)
  	          {root3.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId()));U.Userdata.getFriend().get(i).setFlag1(1);}
  		      break;
  	   case 4:
  		     if(U.Userdata.getFriend().get(i)!=null)
  	          {root4.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId()));U.Userdata.getFriend().get(i).setFlag1(1);}
  		     break;
  	   case 5:
  		    if(U.Userdata.getFriend().get(i)!=null)
  	          {root5.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId()));U.Userdata.getFriend().get(i).setFlag1(1);}
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
  		      {root1.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId()));U.Userdata.getFriend().get(i).setFlag1(1);}
  		      break;
  	   case 2:
  		      if(U.Userdata.getFriend().get(i)!=null)
  	          {root2.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId()));U.Userdata.getFriend().get(i).setFlag1(1);}
  		      break;
  	   case 3:
  		      if(U.Userdata.getFriend().get(i)!=null)
  	          {root3.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId()));U.Userdata.getFriend().get(i).setFlag1(1);}
  		      break;
  	   case 4:
  		     if(U.Userdata.getFriend().get(i)!=null)
  	          {root4.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId()));U.Userdata.getFriend().get(i).setFlag1(1);}
  		     break;
  	   case 5:
  		    if(U.Userdata.getFriend().get(i)!=null)
  	          {root5.add(new IconNode(U.Userdata.getFriend().get(i).getHeadicon(),U.Userdata.getFriend().get(i).getId()));U.Userdata.getFriend().get(i).setFlag1(1);}
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
	   tree.addMouseListener(new MouseAdapter() 
	   {  
		   public void mouseClicked(MouseEvent e) 
		   { 
			   if(e.getClickCount()==2)//双击节点
		     {  
			   TreePath path=tree.getSelectionPath();//获取选中节点路径  
		       IconNode node=(IconNode)path.getLastPathComponent();//通过路径将指针指向该节点  
		       if(node.isLeaf())//如果该节点是叶子节点 
			   { 
			       tree.repaint();//重绘更新树  
			   }
			}
		  }
	   });
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
public void mouseClicked(MouseEvent arg0) {
	// TODO 自动生成的方法存根
	if(arg0.getClickCount() == 2){
		   TreePath path = tree.getPathForLocation(arg0.getX(), arg0.getY());
		   IconNode node = (IconNode) path.getLastPathComponent();
		   System.out.println(node.getText());
		   System.out.println("1"+U.Userdata.getId()+" "+node.getText()+"/n");
		   String ss = U.Userdata.getId()+"->"+node.getText();
		   WinChat wc =new WinChat(U.Userdata.getId(),node.getText());
		   ManageThread.AddChatToMap(ss, wc);
	}
	else 
	{
		TreePath path = tree.getPathForLocation(arg0.getX(), arg0.getY());
		   node = (IconNode) path.getLastPathComponent();
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
    if(e.getButton()==3) 
    	{
    		if(node == root1 ||node == root2 ||node == root3||node == root4||node == root5)		
    		{popMenu1.show(tree, e.getX(), e.getY());node = null;}
    		else if(node!=null)
    			{
    			popMenu.show(tree, e.getX(), e.getY());
    			node = null;
    			}
    		else{node = null;}
    	}
}
public void mouseReleased(MouseEvent arg0) {
	// TODO 自动生成的方法存根
	
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
}

}