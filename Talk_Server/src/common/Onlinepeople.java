package common;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Onlinepeople implements Serializable{
	/**
	 * 当flag=1时。表示添加MygoodFriends
	 * 当flag=2时。表示添加Myclassmates
	 * 当flag=3时。表示添加Myfamily
	 * 当flag=4时，表示添加Myteachers
	 * 当flag=5时，表示添加MyOwns
	 */
	private static final long serialVersionUID = 5951792042466810765L;
	private String id;
//	private String name;
//	private String friendsign;
//	private ImageIcon headicon;
	private int flag;
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getFriendsign() {
//		return friendsign;
//	}
//	public void setFriendsign(String friendsign) {
//		this.friendsign = friendsign;
//	}
//	public ImageIcon getHeadicon() {
//		return headicon;
//	}
//	public void setHeadicon(ImageIcon headicon) {
//		this.headicon = headicon;
//	}
//	public void setdata(String id , String name , String friendsign ,ImageIcon headicon) {
//		this.id = id;
//		this.name = name ;
//		this.friendsign = friendsign;
//		this.headicon = headicon;
//	}

}
