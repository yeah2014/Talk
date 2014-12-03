package view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import control.*;

public class ServerView extends JFrame implements ActionListener {

	/**
	 * ����˿�����ͼ�ν���
	 */
	private Connect C = null;
	private static final long serialVersionUID = 1L;
	static JPanel jp1,jp2;
	static JButton open,close;
	ImageIcon ii;
	public static JTextArea ja=null;
	static JScrollPane jsp=null;
	public ServerView()
	{
		//���ñ���ͼƬ
		this.setimg();
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		open = new JButton("���������");
		close = new JButton("�رշ����");
	
		ja = new JTextArea(ii.getIconHeight()/35, ii.getIconWidth()/15);
		ja.setLineWrap(true);
		ja.setFont(new Font("����",Font.BOLD,20));
		ja.setForeground(Color.BLACK);
		
		jsp = new JScrollPane(ja);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 10));
		
		jp1.add(open);
		jp1.add(close);
		
		jp2.add(jsp);
		
		close.addActionListener(this);
		open.addActionListener(this);
		
		
		jp1.setOpaque(false);
		jp2.setOpaque(false);
		ja.setOpaque(false);
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		
		this.setLayout(new  BorderLayout(50, 40));
		
		this.add(jp2, BorderLayout.NORTH);
		this.add(jp1, BorderLayout.CENTER);
		this.setTitle("TalkServer");
		this.setSize(ii.getIconWidth(), ii.getIconHeight());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
	}
//	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == open )
		{
			//����������
			if(C != null) 
			{
				appendtoserver("�˿����ڼ����У������ظ�������");
			}
			else
			{
				C=new Connect();
				C.start();
			}
			
		}
		else if(e.getSource() == close )
		{
			//�رշ�����
			System.exit(0);

			
		}
	}
	//���ñ���ͼƬ
	public void setimg()
	{
		   ((JPanel)this.getContentPane()).setOpaque(false);
		   ii = new  ImageIcon(ServerView.class.getResource("222.jpg"));
		   JLabel background = new JLabel(ii);
		   this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
		   background.setBounds(0, 0, ii.getIconWidth(), ii.getIconHeight());
	}
	
	//�������ʾ��Ϣ�Ľӿ�
	public static void appendtoserver(String s)
	{
		//System.out.println(s);
		ja.append(s+"\n");
		ja.paintImmediately(ja.getX(), ja.getY(), ja.getWidth(), ja.getHeight());
	}

}
