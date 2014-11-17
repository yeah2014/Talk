package common;

import java.io.Serializable;

import javax.swing.ImageIcon;

/*
 * 这是用户的具体信息
 */
public class Userdata implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String sex;
	private String sign;
	private ImageIcon headicon;
	private Friend[] Friend;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public ImageIcon getHeadicon() {
		return headicon;
	}
	public void setHeadicon(ImageIcon headicon) {
		this.headicon = headicon;
	}

	public Friend[] getFriend() {
		return Friend;
	}
	public void setFriend(Friend[] friend) {
		Friend = friend;
	}
}
