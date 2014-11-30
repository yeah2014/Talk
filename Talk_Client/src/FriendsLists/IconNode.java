package FriendsLists;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
public class IconNode extends DefaultMutableTreeNode
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7432627464696229454L;
	private ImageIcon icon;
	private String text;
	public boolean b;
	public IconNode(String text)
	{
		super();
		this.setText(text);
	}
	public IconNode(int icon,String text,boolean b)
	{
		super();
		System.out.println("Í·ÏñÎª"+icon);
		if(icon==1) this.icon = new ImageIcon("src/image/test.png");
		this.setText(text);
		this.b=b;
	}
	public IconNode(ImageIcon icon,String text,boolean b)
	{
		super();
		this.setIcon(icon);
		this.setText(text);
		this.b=b;
	}
	public Icon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
