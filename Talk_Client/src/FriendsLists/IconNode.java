package FriendsLists;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
public class IconNode extends DefaultMutableTreeNode
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7432627464696229454L;
	private Icon icon;
	private String text;
	public IconNode(String text)
	{
		super();
		this.setText(text);
	}
	public IconNode(int icon,String text)
	{
		super();
		System.out.println("Í·ÏñÎª"+icon);
		if(icon==1) this.icon = new ImageIcon("src/image/test.png");
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
