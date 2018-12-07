import java.util.*;

public class MoonPhase {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the date (e.g. July 4, 1776): ");
		String month = in.next();
		String dayComma = in.next(); // This is the day with the comma
		int year = in.nextInt();
		
		String dayNumber = dayComma.substring(0,dayComma.length()-1); // This is the day without the comma but still as a string
		int day = Integer.parseInt(dayNumber); // This is the day as an int
		
		int monthNumber = 1; // This variable will allow the month name to be converted to a number
		
		if (month.equals("January"))
			monthNumber = 1;
		else if (month.equals("February"))
			monthNumber = 2;
		else if (month.equals("March"))
			monthNumber = 3;
		else if (month.equals("April"))
			monthNumber = 4;
		else if (month.equals("May"))
			monthNumber = 5;
		else if (month.equals("June"))
			monthNumber = 6;
		else if (month.equals("July"))
			monthNumber = 7;
		else if (month.equals("August"))
			monthNumber = 8;
		else if (month.equals("September"))
			monthNumber = 9;
		else if (month.equals("October"))
			monthNumber = 10;
		else if (month.equals("November"))
			monthNumber = 11;
		else if (month.equals("December"))
			monthNumber = 12;		
		
		
		int a = ((14 - monthNumber)/12);
		int y = year + 4800 - a;
		int m = monthNumber + (12*a) - 3;
		int julian = day + (153*m + 2)/5 + 365*y + y/4 - y/100 + y/400 - 32045;
		
		System.out.println(month + " " + dayComma + " " + year + " has a Julian day of " + julian + ".");
		
		int d = (julian + 1) % 7;
		String week = Integer.toString(d);
		
		switch (d) {
		
		case 0: week = "Sunday"; break;
		case 1: week = "Monday"; break;
		case 2: week = "Tuesday"; break;
		case 3: week = "Wednesday"; break;
		case 4: week = "Thursday"; break;
		case 5: week = "Friday"; break;
		case 6: week = "Saturday"; break;
		
		}
		
		System.out.println("Its day of the week is " + week + "."); 
		
		int julianNewMoon = 1 + (153*10+2)/5 + 365*(1900+4800-1) + (1900+4800-1)/4 -(1900+4800-1)/100 + (1900+4800-1)/400 -32045;
		double moonPhase = 1;
		
		if (julian < julianNewMoon)
			moonPhase = Math.round((((julian - julianNewMoon) % 29.530588853)/29.530588853)*8 + 8);
			
		else if (julian >= julianNewMoon)
			moonPhase = Math.round((((julian - julianNewMoon) % 29.530588853)/29.530588853)*8);
		
		String phase = Double.toString(moonPhase);
		
		if( moonPhase == 0 )
			phase = "New Moon";
		else if ( moonPhase == 1 )
			phase = "Waxing Crescent";
		else if ( moonPhase == 2 )
			phase = "First Quarter";
		else if ( moonPhase == 3 )
			phase = "Waxing Gibbous";
		else if ( moonPhase == 4 )
			phase = "Full Moon";
		else if ( moonPhase == 5 )
			phase = "Waning Gibbous";
		else if ( moonPhase == 6 )
			phase = "Last Quarter";
		else if ( moonPhase == 7 )
			phase = "Waning Crescent";
		else if ( moonPhase == 8 )
			phase = "New Moon";
		
		System.out.print("Its phase of the moon is " + phase + ".");
	}

}
