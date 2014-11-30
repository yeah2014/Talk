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
	public JTextField jl;//��Ϣ��ʾ��
	public JTextArea jta1;
	public ClientchatRecord(RowSet b)
	{
		Container c=getContentPane();//����һ������
		c.setLayout(null);
		jta1=new JTextArea();
		jta1.setForeground(Color.black);
		jta1.setLineWrap(true);//����Ϊ�Զ�ת��
		jta1.setWrapStyleWord(true);
		jta1.setEditable(true);//����Ϊ���Ա༭
		JScrollPane scrollpane=new JScrollPane(jta1);//����һ���������ڵĶ���
		scrollpane.setSize(450,230);//���ô�С
		scrollpane.setLocation(10,88);//��������λ������
		c.add(scrollpane);//�������������ʾ����������ڲ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.black);
		this.setSize(600,550);
		this.setVisible(true);
		this.setLocation(280,280);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		try {
			while(b.next())     //b.next()��ʾָ�벻������һ����ֻҪ��Ϊ�ռ���
			{
				jta1.append(b.getString(4) + "\n"   //b.getString(1)��ʾһ����ѯ����ĵ�1���ֶε�ֵ
					+ b.getString(1) + ": "                //b.getString(2)��ʾһ����ѯ����ĵ�2���ֶε�ֵ
					+ b.getString(3) +"\n")                 //b.getString(3)��ʾһ����ѯ����ĵ�3���ֶε�ֵ
					;                      //b.getString(4)��ʾһ����ѯ����ĵ�4���ֶε�ֵ
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		if (b != null)
		{
			try {
				b.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}   //�ر�ResultSet ����
		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
