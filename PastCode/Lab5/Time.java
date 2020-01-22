/*
	
	Patrick Griffin
	Lab 5
	Problem 2: Time

*/

public class Time{

	static double secondsToMinutes(int seconds){

		double minutes;

		minutes = (double)seconds / 60.0;

		return minutes;

	}

	static double secondsToHours(int seconds){

		double hours;
		double minutes;

		minutes = (double)seconds / 60.0;

		hours = minutes / 60;

		return hours;

	}

	static double secondsToDays(int seconds){

		double hours;
		double minutes;
		double days;

		minutes = (double)seconds / 60.0;

		hours = minutes / 60;

		days = hours / 24;

		return days;

	}

	static double secondsToYears(int seconds){

		double hours;
		double minutes;
		double days;
		double years;

		minutes = (double)seconds / 60.0;

		hours = minutes / 60;

		days = hours / 24;

		years = days / 365;

		return years;

	}

	static double minutesToSeconds(double minutes){

		double seconds;

		seconds = minutes * 60;

		return seconds;

	}

	static double hoursToSeconds(double hours){

		double seconds;
		double minutes;

		minutes = hours * 60;

		seconds = minutes * 60;

		return seconds;

	}

	static double daysToSeconds(double days){

		double seconds;
		double minutes;
		double hours;

		hours = days * 24;

		minutes = hours * 60;

		seconds = minutes * 60;

		return seconds;

	}

	static double yearsToSeconds(double years){

		double seconds;
		double minutes;
		double hours;
		double days;

		days = years * 365;

		hours = days * 24;

		minutes = hours * 60;

		seconds = minutes * 60;

		return seconds;

	}

}


