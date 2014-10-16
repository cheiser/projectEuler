
public class NumberLettersCount {
	
	// Kolla om numret är jämnt delbart med 1000, 100, respektive 10 för att avgöra hur långt det är och
	// ta ut den individuella siffran genom att dela med 1000, 100 respektive 10 och gör heltals division för
	// att slippa resten.
	// Sedan har man helt enkelt en array där man hämtar ut antalet bokstäver för den siffran(addera 3 på dem
	// som är jämnt delbara med 10 och har en siffra framför sig(ex. 142, där har 42 en 1 framför sig och ska
	// därför ha +3 bokstäver)).
	
	private static int[] thousandArray = {11};
	private static int[] hundredArray = {10, 10, 12, 11, 11, 10, 12, 12, 11};
	private static int[] multiplesOfTen = {3, 6, 6, 5, 5, 5, 7, 6, 6};
	private static int[] lessThanTwentyArray = {3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8}; // TODO: double check spelling here
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(getLetterCount(19));
		System.out.println(getTotalLetterCount(1, 1000));
	}
	
	
	/**
	 * Gets the total number of letters for all the numbers between "from" and "to"
	 * @param from the starting number
	 * @param to the ending number
	 * @return the letter count for all the numbers between the specified parameters
	 */
	public static int getTotalLetterCount(int from, int to){
		int totalLetterCount = 0;
		
		for(int i = from; i <= to; i++){
			totalLetterCount += getLetterCount(i);
		}
		
		return totalLetterCount;
	}
	
	
	
	/**
	 * Gets the number count for the number specified
	 * @param number the number you want to get the letter count for
	 * @return the number of letters in the spelled out version of the number
	 */
	public static int getLetterCount(int number){
		int letterCount = 0;
		String numberString = new String("" + number);
		int hundreds = 0;
		int tens = 0;
		int ones = 0;
		
		if(numberString.length() >= 4){
			return thousandArray[0];
		}
		
		if(numberString.length() == 3){
			hundreds = Integer.parseInt(numberString.substring(numberString.length()-3, numberString.length()-2));
		}
		
		if(numberString.length() >= 2){
			tens = Integer.parseInt(numberString.substring(numberString.length()-2, numberString.length()-1));
		}
		if(numberString.length() >= 1){
			ones = Integer.parseInt(numberString.substring(numberString.length()-1, numberString.length()));
		}
		
		System.out.println("hundreds-tens-ones " + hundreds + " - " + tens + " - " + ones);
		
		
		if(hundreds > 0){ // should be whole integer division but if buggy make sure
			// the number is bigger than equal to 100
			letterCount += hundredArray[hundreds-1];
			if(tens > 0 || ones > 0){
				letterCount += 3;
			}
		}
		
		if(tens > 0 && tens < 2){
			int tempNumber = 10 + ones;
			letterCount += lessThanTwentyArray[tempNumber-1];
		} else if(tens > 0){
			letterCount += multiplesOfTen[tens-1];
		}
		
		if(ones > 0 && (tens <= 0 || tens > 1)){
			letterCount += lessThanTwentyArray[ones-1];
		}
		
		return letterCount;
	}
	
}
