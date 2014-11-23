package FriendsLists;
import java.awt.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
public class IconNodeRenderer extends DefaultTreeCellRenderer
{
	public Component getTreeCellRendererComponent(JTree tree, Object value,boolean sel,   boolean expanded, boolean leaf, int row,boolean hasFocus)
	{
		super.getTreeCellRendererComponent(tree,value, sel, expanded, leaf, row, hasFocus) ;//���ø���ĸ÷��� 
		Icon icon = ((IconNode) value).getIcon();//�ӽڵ��ȡͼƬ 
		String txt=((IconNode) value).getText(); //�ӽڵ��ȡ�ı� 
		setIcon(icon);//����ͼƬ
		setText(txt);//�����ı� 
		this.setFont(new Font("����",Font.BOLD,16));
		this.setForeground(Color.WHITE);
		return this; 
	}
}
