package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.jvnet.substance.skin.SubstanceBusinessLookAndFeel;

import common.MessageType;
import control.ManageThread;

import java.io.ObjectOutputStream;
import java.net.*;
public class WinChat extends JFrame implements ActionListener,WindowListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6057688970283356344L;
	//一个大面板，一个可编缉的文本框，一个不可编缉的文本框，一个滚动条，三个控扭
	JPanel back,big,min,li;
	public JTextArea edit ,noedit;
	JScrollPane jsp,nojsp;
	JButton close,send,record;
	Socket s;
	String fromwho;
	String towho;
	String message;
	public static void main(String []agr){
		new WinChat(null,null);
	}
	
	public WinChat(String fromwho,String towho)
	{
		this.setTitle(fromwho+"和"+towho+"聊天");
		this.fromwho = fromwho;
		this.towho = towho;
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
		noedit.setEditable(false);
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
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.addWindowListener(this);
	}

	public void addtext(String s )
	{
		this.noedit.append(s);
		this.noedit.append("/n");
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == close)
		{
			ManageThread.removechat(fromwho+"->"+towho);
			this.dispose();
		}
		else if (e.getSource() == send)
		{
			message = this.edit.getText();
			this.noedit.append(fromwho+": "+message+"\n");
			try {
				MessageType m = new MessageType();
				m.setFlag(2);
				m.setId(fromwho);
				m.Message.setFromwho(fromwho);
				m.Message.setTowho(towho);
				m.Message.setMessage(message);
				System.out.println(fromwho+"对"+towho+"说"+message+"\n");
				ObjectOutputStream oos = new ObjectOutputStream(ManageThread.Getthreadfrommap(fromwho).s.getOutputStream()); 
				oos.writeObject(m);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == record)
		{
			
		}
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		ManageThread.removechat(fromwho+"->"+towho);
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}
	
}
