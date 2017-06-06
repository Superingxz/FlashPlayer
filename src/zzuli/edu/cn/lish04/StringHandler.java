package zzuli.edu.cn.lish04;

public class StringHandler {

	public static String getTimeToShow(int num){
		String time = null;
		int hour = num / 360;
		int minute = num / 60 % 60;
		int second = num % 60;
		if(hour < 10){
			time = "0" + hour;
		} else {
			time = "" + hour;
		}
		if(minute < 10){
			time += ":0" + minute;
		} else {
			time += ":" + minute;
		}
		if(second < 10){
			time += ":0" + second;
		} else {
			time += ":" + second;
		}
		return time;
	}	
}
