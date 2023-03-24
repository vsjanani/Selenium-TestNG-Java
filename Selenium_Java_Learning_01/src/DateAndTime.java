import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAndTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();		
		System.out.println(d.toString());
		SimpleDateFormat sdf = new SimpleDateFormat("M/dd/YYYY");
		System.out.println(sdf.format(d));
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
	}

}
