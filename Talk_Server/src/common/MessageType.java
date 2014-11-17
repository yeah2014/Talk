package common;

import java.io.Serializable;

public class MessageType implements Serializable{
	/**
	 * id�������һ��Ҫ��ʼ��;
	 * �ͻ��˷���ʱ��
	 * flag = 1ʱ��Users�������ݣ���������֤��½,;
	 * flag = 2ʱ��Message �������ݣ���������ͨ��Ϣ;
	 * flag = 3ʱ��Image �������ݣ�������ͼƬ;
	 * flag = 4ʱ��Userdata �������ݣ���ע��;
	 * flag = 5ʱ��Forget �������ݣ����һ�����;
	 * flag = 6ʱ��Users�������ݣ����޸�����;
	 * ����˷���ʱ;
	 * flag = 0ʱ������½��֤ʧ�ܣ����һ�����ʧ��,�޸�����ɹ�;
	 * flag = 1ʱ����½�ɹ�������Userdata,;
	 * flag = 2ʱ�� ת��Message;
	 * flag = 3ʱ���䷢Image;
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int flag;
	private String id;
	public Users Users = new Users();
	public Message Message = new Message();
	public Userdata Userdata = new Userdata();
	public Forget Forget = new Forget();
	public Addonline Addonline = new Addonline();
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