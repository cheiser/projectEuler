
public class LongestCycle {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println("cycle is " + recurringNumber(14));
		
		int maxCycle = 0;
		int maxIndex = 1;
		for(int i = 2; i < 1000; i++){
			System.out.println("checking number: " + i);
			int recNum = recurringNumber(i);
			System.out.println("done checking");
			if(recNum > maxCycle){
				maxCycle = recNum;
				maxIndex = i;
			}
		}/**/
		
		System.out.println("the maximum recurring cycle is at " + maxIndex +
				" with length " + maxCycle);
		
		/*
		System.out.println("is cyclic: " + isSingleCyclic("baabaa", "baabaabaabaa"));
		
		int maxCycleLength = 0;
		int maxCycleIndex = 1;
		for(int i = 1; i < 1000; i++){
			double fraction = 1.0 / i;
			// all values that don't "max out" the decimal holder won't be a recurring cycle
			// so we can skip those values. after we know that we check each value at position
			// n*x where n is the distance between the recurring values(will need to find it)
			// and x is each value 1, 2... etc. that is necessary and don't cause an
			// OutOfBoundsException.
			// starting at i = 1 save substring(beginning, i) as the cycle and then see if
			// it repeats itself until the end of the string, if it does not then just increase
			// i until we can no longer increase i (maybe stop at like i/2 otherwise we can not
			// really say it's a cycle).
			
			String fractionString = "" + fraction;
			fractionString = fractionString.substring(2);
			
			int longest = 0;
			
			for(int j = 1; j < fractionString.length(); j++){
				String sub = fractionString.substring(0, j);
				if(isSingleCyclic(sub, fractionString)){
					// System.out.println(sub + " is cyclic on " + fractionString);
					// check so all numbers are unique here, i.e. the sub is not cyclic on itself
					int same = 0;
					for(int n = 0; n < sub.length(); n++){
						if(sub.charAt(0) == sub.charAt(n))
							same++;
					}
					
					if(same < sub.length()-1)
						longest = j;
				}
			}
			
			if(longest > maxCycleLength){
				maxCycleLength = longest;
				maxCycleIndex = i;
			}
		}
		
		System.out.println("the best dividor for largest cycle is: " + maxCycleIndex);
		/**/
	}
	
	
	// TODO: VERIFY
	public static boolean isCyclic(String cycle, String text){
		int cyclePointer = 0;
		for(int i = 0; i < text.length(); i++){
			if(text.charAt(i) != cycle.charAt(cyclePointer)){
				return false;
			}
			cyclePointer = (cyclePointer + 1) % cycle.length();
		}
		
		return true;
	}
	
	
	/**
	 * @param n the number to check cycle length for
	 * @return the length of the recurring cycle, 0 if no recurring cycle
	 */
	public static int recurringNumber(int n){
		int[] prevRemainders = new int[n];
		
		int numberOfTimes = 0;
		int newN = 1; // we know that 1 mod anynumber will always be one except when anynumber=1
		while(true){
			prevRemainders[newN] = numberOfTimes;
			newN = newN*10; // multiplies with 10 to go to the next number "in the line"
			newN = newN % n; // finds the remainder for the next number
			
			if(prevRemainders[newN] != 0 || newN == 0)
				return numberOfTimes;
			numberOfTimes++;
		}
	}
	
	
	/**
	 * 
	 * @param cycle the string to check if "text" is cyclic of
	 * @param text the text to see if it is cyclic
	 * @return true if the text contain a cycle of the "cycle" variable and it is not cyclic on
	 * it self
	 */
	public static boolean isSingleCyclic(String cycle, String text){
		int cyclePointer = 0;
		
		if(cycle.equals(""))
			return false;
		
		for(int i = 1; i < cycle.length(); i++){
			String sub = cycle.substring(0, i);
			if(isSingleCyclic(sub, cycle))
				return false; // baa vs aab...
		}
		
		for(int i = 0; i < text.length(); i++){
			if(text.charAt(i) != cycle.charAt(cyclePointer)){
				return false;
			}
			cyclePointer = (cyclePointer + 1) % cycle.length();
		}
		
		return true;
	}

}
