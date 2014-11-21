package FriendsLists;
import java.awt.*;

import javax.swing.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
public class IconNode extends DefaultMutableTreeNode
{
	private Icon icon;
	private String text;
	public IconNode(String text)
	{
		super();
		this.setText(text);
	}
	public IconNode(Icon icon,String text)
	{
		super();
		this.setIcon(icon);
		this.setText(text);
	}
	public Icon getIcon() {
		return icon;
	}
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
