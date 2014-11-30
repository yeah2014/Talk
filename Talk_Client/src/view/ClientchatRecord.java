package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ClientchatRecord extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8982492544081909032L;
	public JTextField jl;//信息提示框
	public JTextArea jta1;
	public ClientchatRecord(RowSet b)
	{
		Container c=getContentPane();//创建一个容器
		c.setLayout(null);
		jta1=new JTextArea();
		jta1.setForeground(Color.black);
		jta1.setLineWrap(true);//设置为自动转行
		jta1.setWrapStyleWord(true);
		jta1.setEditable(true);//设置为可以编辑
		JScrollPane scrollpane=new JScrollPane(jta1);//创建一个滚动窗口的对象
		scrollpane.setSize(450,230);//设置大小
		scrollpane.setLocation(10,88);//设置它的位置坐标
		c.add(scrollpane);//把这个滚动的显示框加入容器内部
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		this.setSize(600,550);
		this.setVisible(true);
		this.setLocation(280,280);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		try {
			while(b.next())     //b.next()表示指针不断往下一个，只要不为空即可
			{
				jta1.append(b.getString(4) + "\n"   //b.getString(1)表示一条查询结果的第1个字段的值
					+ b.getString(1) + ": "                //b.getString(2)表示一条查询结果的第2个字段的值
					+ b.getString(3) +"\n")                 //b.getString(3)表示一条查询结果的第3个字段的值
					;                      //b.getString(4)表示一条查询结果的第4个字段的值
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		if (b != null)
		{
			try {
				b.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}   //关闭ResultSet 对象
		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
