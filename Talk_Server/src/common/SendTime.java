package common;
import java.util.*;
import java.io.Serializable;
public class SendTime implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int year;
	int month;
	int day;
	int hour;
	int minute;
	public SendTime()
	{
		this.year = Calendar.getInstance().get(Calendar.YEAR);
		this.month = Calendar.getInstance().get(Calendar.MONTH)+1;
		this.day = Calendar.getInstance().get(Calendar.DATE);
		this.hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		this.minute = Calendar.getInstance().get(Calendar.MINUTE);
	}
}
