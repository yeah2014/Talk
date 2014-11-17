package common;

import java.io.Serializable;

public class Addonline implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] onlinepeople;

	public String[] getOnlinepeople() {
		return onlinepeople;
	}

	public void setOnlinepeople(String[] onlinepeople) {
		this.onlinepeople = onlinepeople;
	}
	
}
