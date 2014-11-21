package FriendsLists;
import java.awt.BorderLayout;  



import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import java.awt.*;

import common.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;

import javax.swing.ImageIcon; 
import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree; 
import javax.swing.SwingUtilities; 
import javax.swing.UIManager;  
import javax.swing.tree.DefaultTreeCellRenderer; 
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;  

//import org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel;
//import org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel;
//import org.jvnet.substance.skin.SubstanceGreenMagicLookAndFeel;


import view.demo;
public class FLists extends JFrame  implements ActionListener,MouseListener ,MouseMotionListener
{
   public FLists( MessageType U)
   {
	   JPanel jj = new JPanel();
	   jj.setOpaque(false);
	   jj.setLayout(new BorderLayout());
	   try 
	   { 
		  // UIManager.setLookAndFeel( new SubstanceBusinessBlackSteelLookAndFeel());
		  // UIManager.setLookAndFeel(new SubstanceGreenMagicLookAndFeel());
		   //UIManager.setLookAndFeel( new SubstanceBusinessBlueSteelLookAndFeel());
		   SwingUtilities.updateComponentTreeUI(this);  
		   
	   }
	   catch(Exception e){} 
	   this.setTitle("好友列表");
	   this.setSize(250, 530);
	   this.setLayout(null);
	   this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   this.setUndecorated(true);
	   IconNode root1=new IconNode(new ImageIcon("src/image/qq1.png"),"我的好友"); 
	   IconNode root2=new IconNode(new ImageIcon("src/image/qq1.png"),"我的同学"); 
	   IconNode root3=new IconNode(new ImageIcon("src/image/qq1.png"),"我的家人");
	   IconNode root4=new IconNode(new ImageIcon("src/image/qq1.png"),"我的老师");
	   IconNode root5=new IconNode(new ImageIcon("src/image/qq1.png"),"特别的");
	   //把我的好友放进哈希表里去
//	   HashMap map1=new HashMap<String,MygoodFriends>();
//	   for(int i=0;i<U.Userdata.getMygoodFriend().length;i++)
//	   {
//		   map1.put(U.Userdata.getMygoodFriend()[i].getId(), U.Userdata.getMygoodFriend()[i]);
//	   }
//	   //把我的同学放到哈希表里去
//	   HashMap map2=new HashMap<String,Myclassmates>();
//	   for(int i=0;i<U.Userdata.getMyclassmates().length;i++)
//	   {
//		   map2.put(U.Userdata.getMyclassmates()[i].getId(),U.Userdata.getMyclassmates()[i]);
//	   }
//	   //把我的家人放到哈希表里去
//	   HashMap map3=new HashMap<String,Myfamily>();
//	   for(int i=0;i<U.Userdata.getMyfamily().length;i++)
//	   {
//		   map3.put(U.Userdata.getMyfamily()[i].getId(),U.Userdata.getMyfamily()[i]);
//	   }
//	   //把我的老师放到哈希表里去
//	   HashMap map4=new HashMap<String,Myteachers>();
//	   for(int i=0;i<U.Userdata.getMyteachers().length;i++)
//	   {
//		   map4.put(U.Userdata.getMyteachers()[i].getId(), U.Userdata.getMyteachers()[i]);
//	   }
//	   //把特别的放到哈希表里去
//	   HashMap map5=new HashMap<String,MyOwns>();
//	   for(int i=0;i<U.Userdata.getMyowns().length;i++)
//	   {
//		   map5.put(U.Userdata.getMyowns()[i].getId(), U.Userdata.getMyowns()[i]);
//	   }
//	   MygoodFriends f1;
//	   Myclassmates f2;
//	   Myfamily f3;
//	   Myteachers f4;
//	   MyOwns f5;
//	   //把在线的好友先加进去，首先显示
//       for(int i=0;i<U.Addonline.getOnlinepeople().length;i++)
//       {
//    	   //当flag是1的时候就放在我的好友列表里；当flag是2的时候就放在我的同学列表里面；当flag是3的时候就放在我的家人里面；
//    	   //当flag是4的时候就放在我的老师列表里面；当flag是5的时候就放在特别的列表里面
//    	   //同时，为了方便，这里我们直接用文字标识是在线还是离线，在线的在后面加上在线，离线的在后面加上离线
//    	   switch(U.Addonline.getOnlinepeople()[i].getFlag())
//    	   {
//    	   case 1:f1=(MygoodFriends)map1.get(U.Addonline.getOnlinepeople()[i].getId());
//    		      if(f1!=null)
//    		      {root1.add(new IconNode(f1.getHeadicon(),f1.getId()+"   在线"));map1.remove(f1.getId());}
//    		      break;
//    	   case 2:f2=(Myclassmates)map2.get(U.Addonline.getOnlinepeople()[i].getId());
//    	          if(f2!=null)
//    	          {root2.add(new IconNode(f2.getHeadicon(),f2.getId()+"   在线"));map2.remove(f2.getId());}
//    		      break;
//    	   case 3:f3=(Myfamily)map3.get(U.Addonline.getOnlinepeople()[i].getId());
//    	          if(f3!=null)
//    	          {root3.add(new IconNode(f3.getHeadicon(),f3.getId()+"   在线"));map3.remove(f3.getId());}
//    		      break;
//    	   case 4:f4=(Myteachers)map4.get(U.Addonline.getOnlinepeople()[i].getId());
//    	          if(f4!=null)
//    	          {root4.add(new IconNode(f4.getHeadicon(),f4.getId()+"   在线"));map4.remove(f4.getId());}
//    		     break;
//    	   case 5:f5=(MyOwns)map5.get(U.Addonline.getOnlinepeople()[i].getId());
//    	          if(f5!=null)
//    	          {root5.add(new IconNode(f5.getHeadicon(),f5.getId()+"在线"));map5.remove(f5.getId());}
//    		     break;
//    		     default:
//    		    	    break;
//    	   }
//       }
//       //再把剩下的好友加入到对应的列表里面
//	   MygoodFriends f6;
//	   Myclassmates f7;
//	   Myfamily f8;
//	   Myteachers f9;
//	   MyOwns f10;
//       for(int i=0,k=0;i<U.Userdata.getMygoodFriend().length&&k<map1.size();i++)
//       {
//    	   if((f6=(MygoodFriends)map1.get(U.Userdata.getMygoodFriend()[i].getId()))!=null)
//    	   {root1.add(new IconNode(f6.getHeadicon(),f6.getId()+"   离线"));
//    	   k++;}
//       }
//       for(int i=0,k=0;i<U.Userdata.getMygoodFriend().length&&k<map2.size();i++)
//       {
//    	   if((f7=(Myclassmates)map2.get(U.Userdata.getMyclassmates()[i].getId()))!=null)
//    	   {root2.add(new IconNode(f7.getHeadicon(),f7.getId()+"   离线"));
//    	   k++;}
//       }
//       for(int i=0,k=0;i<U.Userdata.getMygoodFriend().length&&k<map3.size();i++)
//       {
//    	   
//    	   if((f8=(Myfamily)map3.get(U.Userdata.getMyfamily()[i].getId()))!=null)
//    	   {root3.add(new IconNode(f8.getHeadicon(),f8.getId()+"   离线"));
//    	   k++;}
//       }
//       for(int i=0,k=0;i<U.Userdata.getMygoodFriend().length&&k<map4.size();i++)
//       {
//    	   if((f9=(Myteachers)map4.get(U.Userdata.getMyteachers()[i].getId()))!=null)
//    	   {root4.add(new IconNode(f9.getHeadicon(),f9.getId()+"   离线"));
//    	   k++;}
//       }
//       for(int i=0,k=0;i<U.Userdata.getMygoodFriend().length&&k<map5.size();i++)
//       {
//    	   if((f10=(MyOwns)map5.get(U.Userdata.getMyowns()[i].getId()))!=null)
//    	   {root5.add(new IconNode(f10.getHeadicon(),f10.getId()+"   离线"));
//    	   k++;}
//       }
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
	   final JTree tree = new JTree(Root);//定义树   
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
	   JScrollPane sp = new JScrollPane(tree);
	   jj.add(sp);
	   jj.setPreferredSize(new Dimension(300, 400));
	   tree.setOpaque(false);
	   sp.setOpaque(false);
	   sp.getViewport().setOpaque(false);
       Container container = this.getContentPane();
       //tree.setBackground(Color.GRAY);
       new demo(jj);
//       container.add(jj);
	   this.setLocationRelativeTo(null);
	   //this.getContentPane().add(sp, BorderLayout.CENTER); 
	   this.setVisible(true);
	   this.setLocation(1000, 170);
	   container.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
	   this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
	   
   }
   public static void main(String args[])
   {
	   new FLists(null);
   }
public void mouseDragged(MouseEvent arg0) {
	// TODO 自动生成的方法存根
	
}
public void mouseMoved(MouseEvent arg0) {
	// TODO 自动生成的方法存根
	
}
public void mouseClicked(MouseEvent arg0) {
	// TODO 自动生成的方法存根
	
}
public void mouseEntered(MouseEvent arg0) {
	// TODO 自动生成的方法存根
	
}
public void mouseExited(MouseEvent arg0) {
	// TODO 自动生成的方法存根
	
}
public void mousePressed(MouseEvent arg0) {
	// TODO 自动生成的方法存根
	
}
public void mouseReleased(MouseEvent arg0) {
	// TODO 自动生成的方法存根
	
}
public void actionPerformed(ActionEvent arg0) {
	// TODO 自动生成的方法存根
	
}
}