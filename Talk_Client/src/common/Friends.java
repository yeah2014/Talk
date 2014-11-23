package common;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Friends implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String friendsign;
	private ImageIcon headicon;
	private int flag;
	private int flag1;
	private int temp;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFriendsign() {
		return friendsign;
	}
	public void setFriendsign(String friendsign) {
		this.friendsign = friendsign;
	}
	public ImageIcon getHeadicon() {
		return headicon;
	}
	public void setHeadicon(ImageIcon headicon) {
		this.headicon = headicon;
	}
	public void setdata(String id , String name , String friendsign ,ImageIcon headicon) {
		this.id = id;
		this.name = name ;
		this.friendsign = friendsign;
		this.headicon = headicon;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public int getFlag1() {
		return flag1;
	}
	public void setFlag1(int flag1) {
		this.flag1 = flag1;
	}
}
