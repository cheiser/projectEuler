
public class CalendarCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSundays(1901, 2001));
	}
	
	public static int countSundays(int yearFrom, int YearTo){
		int sum = 0, currentYear = 1900, weekDay = 0;
		// b�rja p� 1900 talet och s�tt det till m�ndag och r�kna upp d�rifr�n till man n�r datumet man �r ute
		// efter och b�rja d�refter r�kna s�ndagar.
		// n�r man r�knar upp kollar man bara de angivna reglerna, allts� 
		/* 1 Jan 1900 was a Monday.
			Thirty days has September,
			April, June and November.
			All the rest have thirty-one,
			Saving February alone,
			Which has twenty-eight, rain or shine.
			And on leap years, twenty-nine.
			A leap year occurs on any year evenly divisible by 4, but not on a century unless it is
			divisible by 400.
		 */
		
		for(int yearCount = 0; currentYear+yearCount < YearTo; yearCount++){
			int daysOnYear = 365, shift = 0;
			if((currentYear % 4 == 0 && (currentYear%100 != 0)) ||
					(currentYear % 4 == 0 && (currentYear%400 == 0))){
				daysOnYear = 366;
				shift = 1;
			}
			
			for(int i = 0; i < daysOnYear; i++){
				if(weekDay == 6){
					if((i == 0)) // january
						sum++;
					if(i == 31+shift) // february
						sum++;
					if(i == 59+shift) // march
						sum++;
					if(i == 90+shift) // april
						sum++;
					if(i == 120+shift) // may
						sum++;
					if(i == 151+shift) // june
						sum++;
					if(i == 181+shift) // july
						sum++;
					if(i == 212+shift) // august
						sum++;
					if(i == 243+shift) // september
						sum++;
					if(i == 273+shift) // october
						sum++;
					if(i == 304+shift) // november
						sum++;
					if(i == 334+shift) // december
						sum++;
				}
				weekDay = (weekDay+1) % 7;
				
				
			}
		}
		
		if(yearFrom != 1900)
			return sum-countSundays(1900, yearFrom);
		else
			return sum;
	}

}
