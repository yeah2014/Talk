package common;

import java.io.Serializable;

public class Addonline implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Onlinepeople[] onlinepeople;

	public Onlinepeople[] getOnlinepeople() {
		return onlinepeople;
	}

	public void setOnlinepeople(Onlinepeople[] onlinepeople) {
		this.onlinepeople = onlinepeople;
	}
	
}
