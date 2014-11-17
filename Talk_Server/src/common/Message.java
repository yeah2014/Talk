package common;

import java.io.Serializable;

public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fromwho;
	private String towho;
	private String message;
	private String sendtime;

	public String getFromwho() {
		return fromwho;
	}
	public void setFromwho(String fromwho) {
		this.fromwho = fromwho;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTowho() {
		return towho;
	}
	public void setTowho(String towho) {
		this.towho = towho;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime() {

		SendTime st = new SendTime();
		this.sendtime = st.year+"."+st.month+"."+st.day+" "+st.hour+":"+st.minute;
	}
}
