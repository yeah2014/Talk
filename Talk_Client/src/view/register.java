package view;
import javax.swing.*;

import java.net.*;
import java.awt.*;
import java.awt.event.*;

import SendType.*;
import common.*;
import control.ClientConnect;
public class register extends JFrame  implements ActionListener,MouseListener ,MouseMotionListener,KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6619369305741071492L;

	public static void main(String[] args) {
		new register(null);
	}
		
//			定义组件
//			面板
			JPanel act;
//			标签
			JLabel jlabel_account,jlabel_question,jlabel_answer,jlabel_userName,jlabel_password1,jlabel_password2,jlabel_sign,jlabel_sex,j_question;
//			文本框
			JTextField question , answer,userName,sign,account;
			//密码
			JPasswordField  password1,password2;
//			按扭
			JButton confirm,cancel;
			//单选按钮
			JRadioButton man,woman;
			//创建单选按钮组
		    ButtonGroup bg = new ButtonGroup();
		    
		    demo d;
		    Socket s;
		    ClientConnect connect;
			 public register(Socket s)
			 {
				 
				 this.s=s;
//				 实例化面板组件
				 act = new JPanel();
				 
//				 实例化标签组件
				 jlabel_account = new JLabel("帐号");
				 jlabel_question = new JLabel("问题");
				 jlabel_answer = new JLabel("答案");
				 jlabel_userName = new JLabel("名字");
				 jlabel_password1 = new JLabel("密码");
				 jlabel_password2 = new JLabel("密码");
				 jlabel_sign = new JLabel("签名");
				 jlabel_sex = new JLabel("性别");
				 j_question = new JLabel(" 小学毕业于？");
				 
				 
//				 实例化按扭组件
				 confirm = new JButton("确定");
				 cancel = new JButton("取消");
				 
				 //实例化单选
				 man = new JRadioButton(" 男");
				 woman = new JRadioButton(" 女",true);
				 
//				 实例化文本框组件
				 question = new JTextField(12);
				 answer = new JTextField(12);
				 userName = new JTextField(12);
				 password1 = new JPasswordField(12);
				 password2 = new JPasswordField(12);
				 account = new JTextField(12);
				 sign = new JTextField(12);
				 
				 
//				 设置面板布局
			     act.setLayout(new FlowLayout(FlowLayout.CENTER,10,15));
			     
//				设置面板大小	     
				 act.setPreferredSize(new Dimension(190, 550));
				 
//		            禁用输入法
			     userName.enableInputMethods(false);
			     password1.enableInputMethods(false);
			     password2.enableInputMethods(false);
				 
//				 面板透明化
			     act.setOpaque(false);
			     
//			             文本框透明化
			     account.setOpaque(false);
			     question.setOpaque(false);
			     answer.setOpaque(false);
			     userName.setOpaque(false);
			     password1.setOpaque(false);
			     password2.setOpaque(false);
			     sign.setOpaque(false);
			     man.setOpaque(false);
			     woman.setOpaque(false);
			     
//			     设置字体
			     account.setFont(new Font("宋体",Font.BOLD,18));
			     question.setFont(new Font("宋体",Font.BOLD,18));
			     answer.setFont(new Font("宋体",Font.BOLD,18));
			     userName.setFont(new Font("宋体",Font.BOLD,18));
			     password1.setFont(new Font("宋体",Font.BOLD,18));
			     password2.setFont(new Font("宋体",Font.BOLD,18));
			     sign.setFont(new Font("宋体",Font.BOLD,18));
			     man.setFont(new Font("宋体",Font.BOLD,18));
			     woman.setFont(new Font("宋体",Font.BOLD,18));
			     
			     jlabel_account.setFont(new Font("宋体",Font.BOLD,18));
			     jlabel_question.setFont(new Font("宋体",Font.BOLD,18));
			     jlabel_answer.setFont(new Font("宋体",Font.BOLD,18));
			     jlabel_userName.setFont(new Font("宋体",Font.BOLD,18));
			     jlabel_password1.setFont(new Font("宋体",Font.BOLD,18));
			     jlabel_password2.setFont(new Font("宋体",Font.BOLD,18));
			     jlabel_sign.setFont(new Font("宋体",Font.BOLD,18));
			     jlabel_sex.setFont(new Font("宋体",Font.BOLD,18));
			     j_question.setFont(new Font("宋体",Font.BOLD,18));
			     
//			     设置字体颜色
			     jlabel_account.setForeground(Color.white);
			     jlabel_question.setForeground(Color.white);
			     jlabel_answer.setForeground(Color.white);
			     jlabel_userName.setForeground(Color.white);
			     jlabel_password1.setForeground(Color.white);
			     jlabel_password2.setForeground(Color.white);
			     jlabel_sign.setForeground(Color.white);
			     jlabel_sex.setForeground(Color.white);
			     j_question.setForeground(Color.white);
			     
			     account.setForeground(Color.white);
			     question.setForeground(Color.white);
			     answer.setForeground(Color.white);
			     userName.setForeground(Color.white);
			     password1.setForeground(Color.white);
			     password2.setForeground(Color.white);
			     sign.setForeground(Color.white);
			     man.setForeground(Color.white);
			     woman.setForeground(Color.white);
			     
			   //将单选按钮添加到按钮组中
		         bg.add(man);
		         bg.add(woman);
		         
//			            添加组件
		         act.add(jlabel_account);
		         act.add(account);
			     act.add(jlabel_userName);
			     act.add(userName);
			     act.add(jlabel_password1);
			     act.add(password1);
			     act.add(jlabel_password2);
			     act.add(password2);
			     act.add(jlabel_question);
			     //act.add(question);
			     act.add(question);
			     act.add(jlabel_answer);
			     act.add(answer);
			     act.add(jlabel_sign);
			     act.add(sign);
			     act.add(jlabel_sex);
			     act.add(man);
			     act.add(woman);
			     act.add(confirm);
			     act.add(cancel);
				 
//				 添加监听

				 confirm.addActionListener(this);
				 cancel.addActionListener(this);
				 userName.addMouseListener(this);
				 

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
				if(e.getSource() == userName) 
				{
					userName.setText("");
				}
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
				else 
				{
					String sex;
					if(man.isSelected() == true) sex="男";
					else sex="女";
					Users u = new Users(account.getText(), new String(password2.getPassword()), userName.getText(),
										sex, 1, sign.getText(), question.getText(), answer.getText());
					try {
						registers rs = new registers(s, u);
						
						if(rs.bl == true)
						{
						
						JOptionPane.showMessageDialog(null, "注册成功，确定返回登录"); 
						this.dispose();
						d.dispose();
						new Login();
						}
						else {
							JOptionPane.showMessageDialog(null, "帐号存在"); 
							connect = new ClientConnect();
							this.s = connect.getS();
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			public void keyPressed(KeyEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO 自动生成的方法存根
			}

			public void keyTyped(KeyEvent arg0) {
				// TODO 自动生成的方法存根
				
			}
			 
			 

	}

