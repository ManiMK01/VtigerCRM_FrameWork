package java.com.comcast.crm.generic.Webdriverutility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random ranNum = new Random();
		int ran = ranNum.nextInt(1000);
		return ran;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSystemDateYYYYMMDD() {
		Date dateobj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String data = sim.format(dateobj);
		return data;
	}
	
	/**
	 * 
	 * @param date 
	 * @return
	 */
	public String getReqiredDateYYYYMMDD(int days) {
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		//cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		
		String data = sim.format(cal.getTime());
		return data;
	}
	
	public String getCurrentTimeAndDate() {
		return LocalDateTime.now().toString().replace(":", "_");
	}
	
	public String getAlphaNumeric(int limit) {
		
		String all = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
		int n = limit;
		StringBuilder sb = new StringBuilder(n);
		for(int i=0; i<n; i++) {
			int index = (int) (all.length()*Math.random());
			sb.append(all.charAt(index));
		}
		return sb.toString();
	}
}
