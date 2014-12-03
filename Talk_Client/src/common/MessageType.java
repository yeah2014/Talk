package common;

import java.io.Serializable;

public class MessageType implements Serializable{
	/**
	 * id这个对象一定要初始化;
	 * 客户端发送时：
	 * flag = 1时，Users载入数据，即用来验证登陆;
	 * flag = 2时，Message 载入数据，即发送普通消息;
	 * flag = 3时，Image 载入数据，即发送图片;
	 * flag = 4时，Users 载入数据，即注册;
	 * flag = 5时，Forget 载入数据，即找回密码;
	 * flag = 6时，Users载入数据，即修改密码;
	 * flag = 7时,Users载入数据，添加好友,
	 * 
	 * temp对应多少就有多少个人在相应的列表
	 * 服务端发送时;
	 * flag = 0时，即登陆验证失败，或找回密码失败,修改密码成功;
	 * flag = 1时，登陆成功，发送Userdata;
	 * flag = 2时， 转发Message;
	 * flag = 3时，输发Image;
	 * 4 通知在线  5通知离线
	 * flag = 7 , 添加好友
	 * flag = 8, 添加好友成功
	 * 9添加好友失败
	 */
	private static final long serialVersionUID = 1L;
	private int flag;
	private String id;
	public Users Users = new Users();
	public Message Message = new Message();
	public Userdata Userdata = new Userdata();
	public Forget Forget = new Forget();
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

}
