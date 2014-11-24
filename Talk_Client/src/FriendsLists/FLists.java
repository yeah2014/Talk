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
//	���
	JPanel back,head,body,top;
//	��ǩ
	JLabel headjlabel;
//	��Ť
	JButton button_min,button_exit;
//	������
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
//		 ���Ҫ��ͼƬ
		 ImageIcon headimage = new ImageIcon("src/image/touxiang.jpg");
		 ImageIcon min = new ImageIcon("src/image/min.png");
		 ImageIcon exit = new ImageIcon("src/image/exit.png");
	 
//		 ʵ����������
		 back  = new JPanel();
		 top = new JPanel();
		 head = new JPanel();
		 body = new JPanel();
		 
//		 ʵ������ǩ���
		 headjlabel  = new JLabel(headimage);
		 
//		 ʵ������Ť���
		 button_min  = new JButton(min);
		 button_exit = new JButton(exit);
		 
		 
//		 ������岼��
		 top.setLayout(new FlowLayout(FlowLayout.RIGHT,1,5));
	     head.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
	     body.setLayout(new FlowLayout(FlowLayout.CENTER,0,50));
	     
//		��������С	     
		 top.setPreferredSize(new Dimension(300, 30));
		 head.setPreferredSize(new Dimension(300, 60));
		 
//		 ���ð�Ť��С
		 button_min.setPreferredSize(new Dimension(min.getIconWidth(), min.getIconHeight()));
		 button_exit.setPreferredSize(new Dimension(exit.getIconWidth(), exit.getIconHeight()));

//		 ��Ť͸����
		 button_min.setContentAreaFilled(false);
		 button_exit.setContentAreaFilled(false);
		 
//		 ���͸����
		 back.setOpaque(false);
		 head.setOpaque(false);
		 body.setOpaque(false);
		 top.setOpaque(false);
	     
//		 ȥ���߿�
	     this.setUndecorated(true);
	     
//	            ������
	     
	     top.add(button_min);
	     top.add(button_exit);
		 head.add(headjlabel);
		 back.add(top,BorderLayout.NORTH);
		 back.add(head,BorderLayout.CENTER);
		 back.add(body,BorderLayout.SOUTH);
		 this.add(back);
		 
//		 ��Ӽ���
		 button_min.addActionListener(this);
		 button_exit.addActionListener(this);
		 back.addMouseListener(this);
		 back.addMouseMotionListener(this);
		 
//		 JFrame������ɫ
		 this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
//		 ���ô�С��λ��
		 this.setBounds(500, 300, 300, 600);
		 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	             ���ÿɼ�
		 this.setVisible(true);
	       popMenu = new JPopupMenu();
	       popMenu1 = new JPopupMenu();
	       addItem = new JMenuItem("���");
	       addItem.addActionListener(this);
	       delItem = new JMenuItem("ɾ��");
	       delItem.addActionListener(this);
	       editItem = new JMenuItem("�޸�����");
	       editItem.addActionListener(this);
	       //popMenu.add(addItem);
	       popMenu.add(delItem);
	       popMenu.add(editItem);
	       popMenu1.add(addItem);
	   JPanel jj = new JPanel();
	   jj.setOpaque(false);
	   jj.setLayout(new BorderLayout());
	   root1=new IconNode(new ImageIcon("src/image/qq1.png"),"�ҵĺ���"); 
	   root2=new IconNode(new ImageIcon("src/image/qq1.png"),"�ҵ�ͬѧ"); 
	   root3=new IconNode(new ImageIcon("src/image/qq1.png"),"�ҵļ���");
	   root4=new IconNode(new ImageIcon("src/image/qq1.png"),"�ҵ���ʦ");
	   root5=new IconNode(new ImageIcon("src/image/qq1.png"),"�ر��");
	   //���ҵĺ��ѷŽ���ϣ����ȥ
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
  	   //��flag��1��ʱ��ͷ���"�ҵĺ���"�б����flag��2��ʱ��ͷ����ҵ�ͬѧ�б����棻��flag��3��ʱ��ͷ����ҵļ������棻
  	   //��flag��4��ʱ��ͷ����ҵ���ʦ�б����棻��flag��5��ʱ��ͷ����ر���б�����
  	   //ͬʱ��Ϊ�˷��㣬��������ֱ�������ֱ�ʶ�����߻������ߣ����ߵ��ں���������ߣ����ߵ��ں����������
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
  	   //��flag��1��ʱ��ͷ���"�ҵĺ���"�б����flag��2��ʱ��ͷ����ҵ�ͬѧ�б����棻��flag��3��ʱ��ͷ����ҵļ������棻
  	   //��flag��4��ʱ��ͷ����ҵ���ʦ�б����棻��flag��5��ʱ��ͷ����ر���б�����
  	   //ͬʱ��Ϊ�˷��㣬��������ֱ�������ֱ�ʶ�����߻������ߣ����ߵ��ں���������ߣ����ߵ��ں����������
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
//	 //��U.getppppp()==1��ʱ�򣬱�ʾ���Ǹողŵ�½�ģ���ʱֻ�贫���ߵ����ѹ���
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
	   IconNode Root=new IconNode(null,null);//������ڵ� 
	   Root.add(root1);//��������ڵ�
	   Root.add(root2);//��������ڵ�   
	   Root.add(root3);
	   Root.add(root4);
	   Root.add(root5);
	   tree = new JTree(Root);//������   
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
	// TODO �Զ����ɵķ������
	if(e.getY()<=100)
	{Point p = getLocation();  //������϶�ʱ��ȡ���ڵ�ǰλ��
    //���ô��ڵ�λ��
    //���ڵ�ǰ��λ�� + ��굱ǰ�ڴ��ڵ�λ�� - ��갴�µ�ʱ���ڴ��ڵ�λ��
    setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);

	}
}
public void mouseMoved(MouseEvent arg0) {
	// TODO �Զ����ɵķ������
	
}
public void mouseClicked(MouseEvent arg0) {
	// TODO �Զ����ɵķ������
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
	// TODO �Զ����ɵķ������
	
}
public void mouseExited(MouseEvent arg0) {
	// TODO �Զ����ɵķ������
	
}
public void mousePressed(MouseEvent e) {
	// TODO �Զ����ɵķ������
	origin.x = e.getX();  //����갴�µ�ʱ���ô��ڵ�ǰ��λ��
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
	// TODO �Զ����ɵķ������
	
}
public void actionPerformed(ActionEvent e) {
	// TODO �Զ����ɵķ������
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