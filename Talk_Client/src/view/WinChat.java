package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel;
import org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel;
import org.jvnet.substance.skin.SubstanceBusinessLookAndFeel;
import org.jvnet.substance.skin.SubstanceGreenMagicLookAndFeel;

import SendType.messages;

import java.net.*;
public class WinChat extends JFrame implements ActionListener{

	//一个大面板，一个可编缉的文本框，一个不可编缉的文本框，一个滚动条，三个控扭
	JPanel back,big,min,li;
	JTextArea edit ,noedit;
	JScrollPane jsp,nojsp;
	JButton close,send,record;
	Socket s;
	String fromwho;
	String towho;
	String message;
	public static void main(String []agr){
		new WinChat(null,null,null);
	}
	
	public WinChat(Socket s,String fromwho,String towho)
	{
		this.fromwho = fromwho;
		this.towho = towho;
		this.s = s;
		li = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		min = new JPanel();
		big = new JPanel();
		back = new JPanel(new BorderLayout(100, 10));
		edit = new JTextArea();
		noedit = new JTextArea();
		
		close = new JButton("关闭");
		send = new JButton("发送");
		record = new JButton("消息记录");
		li.add(record,FlowLayout.LEFT);
		li.add(close);
		li.add(send);
//		noedit.setEditable(false);
		noedit.setLineWrap(true);
		edit.setEditable(true);
		edit.setLineWrap(true);
		jsp = new JScrollPane(noedit);
		nojsp = new JScrollPane(edit);
		min.setPreferredSize(new Dimension(600,100));
		min.add(edit);
		big.setPreferredSize(new Dimension(600, 400));
		big.add(jsp);
		jsp.setPreferredSize(new Dimension(600, 400));
		edit.setPreferredSize(new Dimension(600, 100));
		back.setPreferredSize(new Dimension(600, 500));
		back.add(big,BorderLayout.NORTH);
		back.add(min,BorderLayout.CENTER);
		back.add(li,BorderLayout.SOUTH);
		close.addActionListener(this);
		send.addActionListener(this);
		record.addActionListener(this);
		 try 
		   { 
			   //UIManager.setLookAndFeel( new SubstanceBusinessBlackSteelLookAndFeel());
			   //UIManager.setLookAndFeel(new SubstanceGreenMagicLookAndFeel());
			   //UIManager.setLookAndFeel( new SubstanceBusinessBlueSteelLookAndFeel());
			   UIManager.setLookAndFeel(new SubstanceBusinessLookAndFeel());

			   SwingUtilities.updateComponentTreeUI(big);  
			   SwingUtilities.updateComponentTreeUI(min);
			   SwingUtilities.updateComponentTreeUI(li);
			   
		   }
		   catch(Exception e){} 
		this.setBackground(Color.black);
		this.add(back);
		this.setSize(700, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addtext(String s )
	{
		this.noedit.append(s);
		this.noedit.append("/n");
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == close)
		{
			this.dispose();
		}
		else if (e.getSource() == send)
		{
			message = this.edit.getText();
			try {
				System.out.println("3.."+fromwho+" "+towho);
				messages.sendmessages(this.s, fromwho, towho, message);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == record)
		{
			
		}
	}
	
}
