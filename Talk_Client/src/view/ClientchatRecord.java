/*
 * 查找消息记录的界面
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ClientchatRecord extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8982492544081909032L;
	public JTextField jl;
	public JTextArea jta1;
	public ClientchatRecord(RowSet b)
	{
		Container c=getContentPane();
		c.setLayout(null);
		jta1=new JTextArea();
		jta1.setForeground(Color.black);
		jta1.setLineWrap(true);
		jta1.setWrapStyleWord(true);
		jta1.setEditable(true);
		JScrollPane scrollpane=new JScrollPane(jta1);
		scrollpane.setSize(450,230);
		scrollpane.setLocation(10,88);
		c.add(scrollpane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		this.setSize(600,550);
		this.setVisible(true);
		this.setLocation(280,280);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		try {
			while(b.next())     
			{
				jta1.append(b.getString(4) + "\n"   
					+ b.getString(1) + ": "                
					+ b.getString(3) +"\n")                 
					;                      
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (b != null)
		{
			try {
				b.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}   
		}
	}
}
