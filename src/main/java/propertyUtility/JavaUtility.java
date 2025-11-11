package propertyUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int generateRandomNumber()
	{
		Random random=new Random();
		int randomNum = random.nextInt(1000);
		return randomNum;
	}
	
	public String generateDateandTime() 
	
	{
		Date d=new Date();
	   String date = d.toString().replace(" ", "_").replace(":","_" );
	   
	   return date;
	}
	
	public String getRequiredDate(int days)
	{
		Date d=new Date();
		SimpleDateFormat s =new SimpleDateFormat("dd-mm-yyyy");
		s.format(d);
		Calendar c=s.getCalendar();
		c.add(c.DAY_OF_MONTH, days);
		return s.format(c.getTime());
	}

}
