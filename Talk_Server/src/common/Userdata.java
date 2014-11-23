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
	private String id;
	private String name;
	private String sex;
	private String sign;
	private int headicon;
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
	public int getHeadicon() {
		return headicon;
	}
	public void setHeadicon(int headicon) {
		this.headicon = headicon;
	}
	public void setAll(String id,String name,String sex,String sign,int headicon)
	{
		this.setId(id);
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
