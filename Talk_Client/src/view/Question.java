package view;
import javax.swing.*;

import java.awt.*;
import java.net.*;
import java.awt.event.*;
import control.*;
import common.*;
import control.ClientConnect;
import SendType.*;

public class Question extends JFrame  implements ActionListener,MouseListener ,MouseMotionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2964486594368306911L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Question(null);
	}

			
//			定义组件
//			面板
			JPanel act;
//			标签
			JLabel jlabel_question,jlabel_answer,jlable_userName,j_question;
//			文本框
			JTextField question,answer,userName;
//			按扭
			JButton confirm,cancel;
			demo d;
			Socket s;
			ClientConnect connect;
			 public Question(Socket s)
			 {
				 this.s = s;
//				 实例化面板组件
				 act = new JPanel();
				 
//				 实例化标签组件
				 jlabel_question = new JLabel("-问题-");
				 jlabel_answer = new JLabel("-答案-");
				 jlable_userName =new JLabel("-帐号-");
				 j_question = new JLabel(" 小学毕业于？");
				 
//				 实例化按扭组件
				 confirm = new JButton("确定");
				 cancel = new JButton("取消");
				 
//				 实例化文本框组件
				 question = new JTextField(12);
				 answer = new JTextField(12);
				 userName = new JTextField(12);
				 
//				 设置面板布局
			     act.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
			     
//				设置面板大小	     
				 act.setPreferredSize(new Dimension(190, 350));
				 
				 //输入法禁用
				 userName.enableInputMethods(false);
				 
//				 面板透明化
			     act.setOpaque(false);
			     
//			             文本框透明化
			     question.setOpaque(false);
			     answer.setOpaque(false);
			     userName.setOpaque(false);
			     
//			     设置字体
			     question.setFont(new Font("宋体",Font.BOLD,18));
			     answer.setFont(new Font("宋体",Font.BOLD,18));
			     userName.setFont(new Font("宋体",Font.BOLD,18));
			     jlabel_question.setFont(new Font("宋体",Font.BOLD,18));
			     jlabel_answer.setFont(new Font("宋体",Font.BOLD,18));
			     jlable_userName.setFont(new Font("宋体",Font.BOLD,18));
			     j_question.setFont(new Font("宋体",Font.BOLD,18));
//			     设置字体颜色
			     jlabel_question.setForeground(Color.white);
			     jlabel_answer.setForeground(Color.white);
			     jlable_userName.setForeground(Color.white);
			     j_question.setForeground(Color.white);
			     userName.setForeground(Color.white);
			     
			     question.setForeground(Color.white);
			     answer.setForeground(Color.white);
			     
//			            添加组件
			     act.add(jlable_userName);
			     act.add(userName);
			     act.add(jlabel_question);
//			     act.add(j_question);
			     act.add(question);
			     act.add(jlabel_answer);
			     act.add(answer);
			     act.add(confirm);
			     act.add(cancel);
				 
//				 添加监听
				 confirm.addActionListener(this);
				 cancel.addActionListener(this);
				 
				 d = new demo(act);
			 }
			
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == cancel)
				{
					this.dispose();
					d.dispose();
					new Login();
				}
				else if(e.getSource() == confirm)
				{
					Forget fg = new Forget(userName.getText(), question.getText(), answer.getText());
					Found f = new Found(s, fg);
					if(f.bl == false) 
					{
						JOptionPane.showMessageDialog(null, "资料填写错误"); 
						connect = new ClientConnect();
						this.s = connect.getS();
					}
					else{
					this.dispose();
					d.dispose();
					new Login();
					}
				}
			}
			 
			 

	}

