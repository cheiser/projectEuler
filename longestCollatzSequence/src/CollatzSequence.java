
public class CollatzSequence {
	
	// will hold the result of starting the collatzSequence at the specific number
	public static int[] collatzNumbers = new int[1000000];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(longestCollatzSequence(1000000));
		System.out.println(longestCollatzSequence(15));
		System.out.println(goThroughChain(837799));
	}
	
	// all numbers that is multiples(*2) of a number that is evenly divisible by two will contain the same
	// amount of steps + 1
	
	// perhaps have an array of all the resulting collatz numbers so far and simply look up the results once one
	// reaches a number in the array and calculate and save if it can not be found
	// perhaps a structure like an hashmap or something where lookups are fast, although could just have an
	// ordinary array and use the number as the index but it's not sure exactly how big the numbers will get
	// could try around 3 000 000
	
	public static int longestCollatzSequence(int upperLimit){
		int currentLongest = 0, currentNumber = 0, temp;
		collatzNumbers[1] = 1;
		
		for(int i = 2; i < upperLimit; i++){
			temp = goThroughChain(i);
			collatzNumbers[i] = temp;
//			System.out.println("temp: " + temp + " i: " + i);
			if(temp > currentLongest){
				currentNumber = i;
				currentLongest = temp;
			}
		}
		
		System.out.println("currentLongest: " + currentLongest);
		
		return currentNumber;
	}
	
	
	/**
	 * uses the collatz rules and counts the number of steps it takes to get to 1
	 * @param startNumber the number to start at
	 * @return the number of steps it took
	 */
	private static int goThroughChain(long startNumber){
		long number = startNumber;
		int steps = 0;
		while(number != 1){
			if(number < collatzNumbers.length && collatzNumbers[(int) number] > 0){
				if(startNumber == 837799){
					System.out.println("collatzNumers: " + collatzNumbers[(int) number] + " steps: " + steps);
					System.out.println("number: " + number);
				}
				
				steps = collatzNumbers[(int) number] + steps;
				number = 1;
			}else{ 
				number = getNextInteger(number);
				steps++;
			}
		}
		
		return steps;
	}
	
	private static long getNextInteger(long collatzNumber){
		if(collatzNumber % 2 == 0){
			return collatzNumber/2;
		}else{
			return collatzNumber*3 + 1;
		}
	}

}
