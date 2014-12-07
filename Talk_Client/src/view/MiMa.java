/*
 * 修改密码界面
 */
package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
public class MiMa extends JFrame  implements ActionListener,MouseListener ,MouseMotionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 879179576852195833L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiMa(null);
	}

//			定义组件
//			面板
			JPanel act;
//			标签
			JLabel jlabel_password1,jlabel_password;
//			文本框
			JPasswordField  account , password;
//			按扭
			JButton register,enter;
			Socket s;
			 public MiMa(Socket s)
			 {
				 this.s = s;
//				 实例化面板组件
				 act = new JPanel();
				 
//				 实例化标签组件
				 jlabel_password1 = new JLabel("新密码");
				 jlabel_password = new JLabel("新密码");
				 
//				 实例化按扭组件
				 register = new JButton("确定");
				 enter = new JButton("取消");
				 
//				 实例化文本框组件
				 account = new JPasswordField(12);
				 password = new JPasswordField(12);
				 
//				 设置面板布局
			     act.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
			     
//				设置面板大小	     
				 act.setPreferredSize(new Dimension(200, 300));
				 
//				 面板透明化
			     act.setOpaque(false);
			     
//			             文本框透明化
			     account.setOpaque(false);
			     password.setOpaque(false);
			     
			     //输入法禁用
			     account.enableInputMethods(false);
			     password.enableInputMethods(false);
			     
//			     设置字体
			     account.setFont(new Font("宋体",Font.BOLD,18));
			     password.setFont(new Font("宋体",Font.BOLD,18));
			     jlabel_password1.setFont(new Font("宋体",Font.BOLD,18));
			     jlabel_password.setFont(new Font("宋体",Font.BOLD,18));
//			     设置字体颜色
			     jlabel_password1.setForeground(Color.white);
			     jlabel_password.setForeground(Color.white);
			     account.setForeground(Color.white);
			     password.setForeground(Color.white);
			     
//			            添加组件
			     act.add(new JLabel("长度不超过12的非汉字字符"));
			     act.add(jlabel_password1);
			     act.add(account);
			     act.add(jlabel_password);
			     act.add(password);
			     act.add(register);
			     act.add(enter);
				 
//				 添加监听
				 register.addActionListener(this);
				 enter.addActionListener(this);
				 
				 new demo(act,s);
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
				
			}
			 
			 

	}

