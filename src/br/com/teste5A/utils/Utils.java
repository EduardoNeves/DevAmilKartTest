package br.com.teste5A.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.teste5A.objects.Pilot;

public final class Utils {
	
	public static String preparString(String str) {
		str = str.replaceAll("\\s",";");
		str = str.replaceAll(";–;","-");
		while(str.contains(";;"))
			str = str.replaceAll(";;",";");
		return str;
	}
	
	public static Date converStringToDate(String str){
		String sdf = null;
		if(str.length()==12)
			sdf = "HH:mm:ss.SSS";
		else if(str.length()==8)
			sdf = "m:ss.SSS";
		else
			return null;
		SimpleDateFormat df = new SimpleDateFormat(sdf);
		Date d = null;
		try {d = df.parse(str);}catch (Exception e) {}
		return d;
	}
	
	public static Pilot converStringPilot(String str){
		Pilot pilot = new Pilot();
		String[] strSplint = str.split("-");
		pilot.setNumber(Integer.parseInt(strSplint[0]));
		pilot.setName(strSplint[1]);
		return pilot;
	}
	
	public static Float convertStringToFloat(String str) {
		str = str.replaceAll(",", ".");
		return Float.parseFloat(str);
	}
	
	public static Date sumDates(Date d1, Date d2) {
		long sum = d1.getTime() + d2.getTime();
		Date sumDate = new Date(sum);
		return sumDate;
	}
	
	public static Date averageTime(Date d1, int av) {
		long average = d1.getTime()/av;
		Date averageDate = new Date(average);
		return averageDate;
	}
	
	public static String formatDate(Long timeStamp) {
		DateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");
		Date date = new Date(timeStamp);
		return dateFormat.format(date);
	}
}
