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
	   this.setTitle("�����б�");
	   this.setSize(250, 530);
	   this.setLayout(null);
	   this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   this.setUndecorated(true);
	   IconNode root1=new IconNode(new ImageIcon("src/image/qq1.png"),"�ҵĺ���"); 
	   IconNode root2=new IconNode(new ImageIcon("src/image/qq1.png"),"�ҵ�ͬѧ"); 
	   IconNode root3=new IconNode(new ImageIcon("src/image/qq1.png"),"�ҵļ���");
	   IconNode root4=new IconNode(new ImageIcon("src/image/qq1.png"),"�ҵ���ʦ");
	   IconNode root5=new IconNode(new ImageIcon("src/image/qq1.png"),"�ر��");
	   //���ҵĺ��ѷŽ���ϣ����ȥ
//	   HashMap map1=new HashMap<String,MygoodFriends>();
//	   for(int i=0;i<U.Userdata.getMygoodFriend().length;i++)
//	   {
//		   map1.put(U.Userdata.getMygoodFriend()[i].getId(), U.Userdata.getMygoodFriend()[i]);
//	   }
//	   //���ҵ�ͬѧ�ŵ���ϣ����ȥ
//	   HashMap map2=new HashMap<String,Myclassmates>();
//	   for(int i=0;i<U.Userdata.getMyclassmates().length;i++)
//	   {
//		   map2.put(U.Userdata.getMyclassmates()[i].getId(),U.Userdata.getMyclassmates()[i]);
//	   }
//	   //���ҵļ��˷ŵ���ϣ����ȥ
//	   HashMap map3=new HashMap<String,Myfamily>();
//	   for(int i=0;i<U.Userdata.getMyfamily().length;i++)
//	   {
//		   map3.put(U.Userdata.getMyfamily()[i].getId(),U.Userdata.getMyfamily()[i]);
//	   }
//	   //���ҵ���ʦ�ŵ���ϣ����ȥ
//	   HashMap map4=new HashMap<String,Myteachers>();
//	   for(int i=0;i<U.Userdata.getMyteachers().length;i++)
//	   {
//		   map4.put(U.Userdata.getMyteachers()[i].getId(), U.Userdata.getMyteachers()[i]);
//	   }
//	   //���ر�ķŵ���ϣ����ȥ
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
//	   //�����ߵĺ����ȼӽ�ȥ��������ʾ
//       for(int i=0;i<U.Addonline.getOnlinepeople().length;i++)
//       {
//    	   //��flag��1��ʱ��ͷ����ҵĺ����б����flag��2��ʱ��ͷ����ҵ�ͬѧ�б����棻��flag��3��ʱ��ͷ����ҵļ������棻
//    	   //��flag��4��ʱ��ͷ����ҵ���ʦ�б����棻��flag��5��ʱ��ͷ����ر���б�����
//    	   //ͬʱ��Ϊ�˷��㣬��������ֱ�������ֱ�ʶ�����߻������ߣ����ߵ��ں���������ߣ����ߵ��ں����������
//    	   switch(U.Addonline.getOnlinepeople()[i].getFlag())
//    	   {
//    	   case 1:f1=(MygoodFriends)map1.get(U.Addonline.getOnlinepeople()[i].getId());
//    		      if(f1!=null)
//    		      {root1.add(new IconNode(f1.getHeadicon(),f1.getId()+"   ����"));map1.remove(f1.getId());}
//    		      break;
//    	   case 2:f2=(Myclassmates)map2.get(U.Addonline.getOnlinepeople()[i].getId());
//    	          if(f2!=null)
//    	          {root2.add(new IconNode(f2.getHeadicon(),f2.getId()+"   ����"));map2.remove(f2.getId());}
//    		      break;
//    	   case 3:f3=(Myfamily)map3.get(U.Addonline.getOnlinepeople()[i].getId());
//    	          if(f3!=null)
//    	          {root3.add(new IconNode(f3.getHeadicon(),f3.getId()+"   ����"));map3.remove(f3.getId());}
//    		      break;
//    	   case 4:f4=(Myteachers)map4.get(U.Addonline.getOnlinepeople()[i].getId());
//    	          if(f4!=null)
//    	          {root4.add(new IconNode(f4.getHeadicon(),f4.getId()+"   ����"));map4.remove(f4.getId());}
//    		     break;
//    	   case 5:f5=(MyOwns)map5.get(U.Addonline.getOnlinepeople()[i].getId());
//    	          if(f5!=null)
//    	          {root5.add(new IconNode(f5.getHeadicon(),f5.getId()+"����"));map5.remove(f5.getId());}
//    		     break;
//    		     default:
//    		    	    break;
//    	   }
//       }
//       //�ٰ�ʣ�µĺ��Ѽ��뵽��Ӧ���б�����
//	   MygoodFriends f6;
//	   Myclassmates f7;
//	   Myfamily f8;
//	   Myteachers f9;
//	   MyOwns f10;
//       for(int i=0,k=0;i<U.Userdata.getMygoodFriend().length&&k<map1.size();i++)
//       {
//    	   if((f6=(MygoodFriends)map1.get(U.Userdata.getMygoodFriend()[i].getId()))!=null)
//    	   {root1.add(new IconNode(f6.getHeadicon(),f6.getId()+"   ����"));
//    	   k++;}
//       }
//       for(int i=0,k=0;i<U.Userdata.getMygoodFriend().length&&k<map2.size();i++)
//       {
//    	   if((f7=(Myclassmates)map2.get(U.Userdata.getMyclassmates()[i].getId()))!=null)
//    	   {root2.add(new IconNode(f7.getHeadicon(),f7.getId()+"   ����"));
//    	   k++;}
//       }
//       for(int i=0,k=0;i<U.Userdata.getMygoodFriend().length&&k<map3.size();i++)
//       {
//    	   
//    	   if((f8=(Myfamily)map3.get(U.Userdata.getMyfamily()[i].getId()))!=null)
//    	   {root3.add(new IconNode(f8.getHeadicon(),f8.getId()+"   ����"));
//    	   k++;}
//       }
//       for(int i=0,k=0;i<U.Userdata.getMygoodFriend().length&&k<map4.size();i++)
//       {
//    	   if((f9=(Myteachers)map4.get(U.Userdata.getMyteachers()[i].getId()))!=null)
//    	   {root4.add(new IconNode(f9.getHeadicon(),f9.getId()+"   ����"));
//    	   k++;}
//       }
//       for(int i=0,k=0;i<U.Userdata.getMygoodFriend().length&&k<map5.size();i++)
//       {
//    	   if((f10=(MyOwns)map5.get(U.Userdata.getMyowns()[i].getId()))!=null)
//    	   {root5.add(new IconNode(f10.getHeadicon(),f10.getId()+"   ����"));
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
	   IconNode Root=new IconNode(null,null);//������ڵ� 
	   Root.add(root1);//��������ڵ�
	   Root.add(root2);//��������ڵ�   
	   Root.add(root3);
	   Root.add(root4);
	   Root.add(root5);
	   final JTree tree = new JTree(Root);//������   
	   tree.setCellRenderer(new IconNodeRenderer()); //���õ�Ԫ������  
	   tree.setEditable(false); //�������Ƿ�ɱ༭  
	   tree.setRootVisible(false);//�������ĸ��ڵ��Ƿ����
	   tree.setToggleClickCount(1);//���õ�������չ�����ڵ� 
	   tree.putClientProperty("JTree.lineStyle" , "Angeled");
	   tree.setShowsRootHandles(true);
	   tree.setRootVisible(true);
	  // DefaultTreeCellRenderer cellRenderer = new DefaultTreeCellRenderer();
	   DefaultTreeCellRenderer  cellRenderer=(DefaultTreeCellRenderer)tree.getCellRenderer();//��ȡ������Renderer  
	   cellRenderer.setClosedIcon(new ImageIcon("img/xiaotouxiang.jpg"));//�رմ�ͼ�� 
	   cellRenderer.setOpenIcon(new ImageIcon("img/xiaotouxiang.jpg"));//����չ��ͼ��
	   cellRenderer.setBackgroundNonSelectionColor(new Color(0, 0, 0, 0));
	   cellRenderer.setBackgroundSelectionColor(new Color(0, 0, 0, 0));
	   tree.addMouseListener(new MouseAdapter() 
	   {  
		   public void mouseClicked(MouseEvent e) 
		   { 
			   if(e.getClickCount()==2)//˫���ڵ�
		     {  
			   TreePath path=tree.getSelectionPath();//��ȡѡ�нڵ�·��  
		       IconNode node=(IconNode)path.getLastPathComponent();//ͨ��·����ָ��ָ��ýڵ�  
		       if(node.isLeaf())//����ýڵ���Ҷ�ӽڵ� 
			   { 
			       tree.repaint();//�ػ������  
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
	// TODO �Զ����ɵķ������
	
}
public void mouseMoved(MouseEvent arg0) {
	// TODO �Զ����ɵķ������
	
}
public void mouseClicked(MouseEvent arg0) {
	// TODO �Զ����ɵķ������
	
}
public void mouseEntered(MouseEvent arg0) {
	// TODO �Զ����ɵķ������
	
}
public void mouseExited(MouseEvent arg0) {
	// TODO �Զ����ɵķ������
	
}
public void mousePressed(MouseEvent arg0) {
	// TODO �Զ����ɵķ������
	
}
public void mouseReleased(MouseEvent arg0) {
	// TODO �Զ����ɵķ������
	
}
public void actionPerformed(ActionEvent arg0) {
	// TODO �Զ����ɵķ������
	
}
}