package FriendsLists;
import java.awt.*;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
public class IconNodeRenderer extends DefaultTreeCellRenderer
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1769510364953027226L;

	public Component getTreeCellRendererComponent(JTree tree, Object value,boolean sel,   boolean expanded, boolean leaf, int row,boolean hasFocus)
	{
		super.getTreeCellRendererComponent(tree,value, sel, expanded, leaf, row, hasFocus) ;//���ø���ĸ÷��� 
		Icon icon = ((IconNode) value).getIcon();//�ӽڵ��ȡͼƬ 
		String txt=((IconNode) value).getText(); //�ӽڵ��ȡ�ı� 
		boolean b = ((IconNode) value).b;
		setIcon(icon);//����ͼƬ
		setText(txt);//�����ı� 
		this.setFont(new Font("����",Font.BOLD,16));
		this.setForeground(Color.WHITE);
		if(b==true) this.setEnabled(true);
		else this.setEnabled(false);
		return this; 
	}
}
