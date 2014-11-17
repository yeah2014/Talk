package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class test extends JFrame implements ActionListener{
	public static void main(String [] agr)
	{
		new test();
	}
	//在线名单
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2;
	JScrollPane jsp;
	JLabel []jbls;
	
	//离线名单
	
	JPanel sjp1,sjp2,sjp3,sjp4;
	JButton sjb1,sjb2;
	JScrollPane sjsp;
	JLabel []sjbls;
	
	CardLayout c;
	
	public void initleaveline()
	{
		sjp1 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		sjb1 = new JButton("在线好友");
		sjb2 = new JButton("离线好友");
		sjp4 = new JPanel(new BorderLayout());
		sjb1.addActionListener(this);
		sjb2.addActionListener(this);
		//假定有50个好友
		sjp2 = new JPanel(new GridLayout(50, 1, 4, 4));
		//给jp3初始化50个好友
		sjbls = new JLabel[10];
		for(int i = 0 ; i < sjbls.length ; i++)
		{
			sjbls[i] = new JLabel(i+1+"",new ImageIcon("D://Desktop/xiaotouxiang.jpg"),JLabel.LEFT);
			sjbls[i].setEnabled(false);
			sjp2.add(sjbls[i]);
			
		}
		sjbls[0].setEnabled(true);
//		jp3 = new JPanel();
		
//		jp3.add(jb2);
		sjp4.setPreferredSize(new Dimension(285, 300));
		sjb1.setPreferredSize(new Dimension(300, 30));
		sjb2.setPreferredSize(new Dimension(300, 30));
		sjsp = new JScrollPane(sjp2);
		sjp4.add(sjsp);
		sjsp.getVerticalScrollBar().setUnitIncrement(30);
		sjp1.add(sjb1);
		sjp1.add(sjb2);
		sjp1.add(sjp4);
		sjp1.setOpaque(false);
		sjp2.setOpaque(false);
		sjp4.setOpaque(false);
		sjsp.setOpaque(false);
		sjsp.getViewport().setOpaque(false);
		sjb1.setContentAreaFilled(false);
		sjb2.setContentAreaFilled(false);

	}
	
	public void initonline()
	{
		jp1 = new JPanel(new BorderLayout());
		jb1 = new JButton("在线好友");
		jb2 = new JButton("离线好友");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		//假定有50个好友
		jp2 = new JPanel(new GridLayout(50, 1, 4, 4));
		//给jp3初始化50个好友
		jbls = new JLabel[50];
		for(int i = 0 ; i < jbls.length ; i++)
		{
			jbls[i] = new JLabel(i+1+"",new ImageIcon("D://Desktop/xiaotouxiang.jpg"),JLabel.LEFT);
			jbls[i].setEnabled(false);
			jp2.add(jbls[i]);
//			jbls[i].setOpaque(false);
		}
		jbls[1].setEnabled(true);
//		jp3 = new JPanel();
		
//		jp3.add(jb2);
		jb1.setPreferredSize(new Dimension(300, 30));
		jb2.setPreferredSize(new Dimension(300, 30));
		jsp = new JScrollPane(jp2);
		jsp.getVerticalScrollBar().setUnitIncrement(30);
		jp1.add(jb1,"North");
		jp1.add(jsp, "Center");
		jp1.add(jb2, "South");
		jp1.setOpaque(false);
		jp2.setOpaque(false);
//		jp3.setOpaque(false);
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		jb1.setContentAreaFilled(false);
		jb2.setContentAreaFilled(false);
		
	}
	

	public test()
	{
		initonline();
		initleaveline();
		c = new CardLayout();
		this.setLayout(c);
		this.add(jp1,"1");
		this.add(sjp1,"2");
	     this.setUndecorated(true);

		this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));

		this.setSize(300, 400);
		this.setVisible(true);

//		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == jb1)
		{
			c.show(this.getContentPane(), "1");
		}
		else if(e.getSource() == jb2)
		{
			c.show(this.getContentPane(), "2");
		}
		else if(e.getSource() == sjb1)
		{
			c.show(this.getContentPane(), "1");
		}
		else if(e.getSource() == sjb2)
		{
			c.show(this.getContentPane(), "2");
		}
	}
}
