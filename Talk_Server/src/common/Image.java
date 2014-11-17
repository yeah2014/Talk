package common;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Image implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon ii;

	public ImageIcon getIi() {
		return ii;
	}

	public void setIi(ImageIcon ii) {
		this.ii = ii;
	}
	
}
