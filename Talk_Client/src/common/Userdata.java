package common;

import java.io.Serializable;

import javax.swing.ImageIcon;

/*
 * 这是用户的具体信息
 */
public class Userdata implements Serializable{
	/**
	 */
	private static final long serialVersionUID = 1L;
	private String id;//acount
	private String name;
	private String sex;
	private String sign;
	private ImageIcon headicon;
	private Friends[] friend;
	
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
	public void setAll(String id,String name,String sex,String sign,ImageIcon headicon)
	{
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.sign = sign;
		this.headicon = headicon;
	}
	public Friends[] getFriend() {
		return friend;
	}
	public void setFriend(Friends[] friend) {
		this.friend = friend;
	}

}
