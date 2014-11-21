package common;

import java.io.Serializable;

/*
 * 这是用户的登陆帐号密码
 */
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String name;
	private String sex;
	private String sign;
	private int headicon;
	private Forget forget;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getHeadicon() {
		return headicon;
	}
	public void setHeadicon(int headicon) {
		this.headicon = headicon;
	}
	public Forget getForget() {
		return forget;
	}
	public void setForget(Forget forget) {
		this.forget = forget;
	}

}
