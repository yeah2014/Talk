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
	private ImageIcon headicon;
	private MygoodFriends[] MygoodFriend;
	private Myclassmates[] Myclassmates;
	private Myteachers[] Myteachers;
	private MyOwns[] Myowns;
	private Myfamily[] Myfamily;
	public MygoodFriends[] getMygoodFriend() {
		return MygoodFriend;
	}
	public void setMygoodFriend(MygoodFriends[] mygoodFriend) {
		MygoodFriend = mygoodFriend;
	}
	public Myclassmates[] getMyclassmates() {
		return Myclassmates;
	}
	public void setMyclassmates(Myclassmates[] myclassmates) {
	     Myclassmates = myclassmates;
	}
	public Myteachers[] getMyteachers() {
		return Myteachers;
	}
	public void setMyteachers(Myteachers[] myteachers) {
		Myteachers = myteachers;
	}
	public MyOwns[] getMyowns() {
		return Myowns;
	}
	public void setMyowns(MyOwns[] myowns) {
		Myowns = myowns;
	}
	public Myfamily[] getMyfamily() {
		return Myfamily;
	}
	public void setMyfamily(Myfamily[] myfamily) {
		Myfamily = myfamily;
	}
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

}
