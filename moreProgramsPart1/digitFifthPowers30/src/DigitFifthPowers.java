import java.util.ArrayList;


public class DigitFifthPowers {

	/**
	 * @param args
	 * off by 1...
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int raiseTo = 5;
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		int searchTo = 1000000;
		
		System.out.println("The length is " + getNumberLength(3));
		System.out.println("The 2 digit is " + getNumberAt(12345, 0));
		
		for(int i = 1; i < searchTo; i++){
			int numberLength = getNumberLength(i);
			int sum = 0;
			for(int j = 0; j < numberLength; j++){
				sum += Math.pow(getNumberAt(i, j), raiseTo);
			}
			
			if(sum == i){
				numberList.add(i);
			}
		}
		
		int tempSum = 0;
		for(int i = 0; i < numberList.size(); i++){
			tempSum += numberList.get(i);
		}
		
		System.out.println("the sum is " + tempSum);
	}
	
	
	// NOT CORRECT YET...
	public static int getNumberAt(int numberString, int numberAtIndex){
		int numberLength = getNumberLength(numberString);
		int[] indNumber = new int[numberLength];
		int index = 0;
		
		int tempNumber = numberString;
		while(tempNumber > 0){
			indNumber[index++] = tempNumber % 10;
			tempNumber = tempNumber / 10;
		}
		
		
		
		return indNumber[numberLength - (numberAtIndex + 1)];
	}
	
	
	
	public static int getNumberLength(int number){
		int divisor = 10;
		int nrDivs = 1;
		while((number / divisor) > 0){
			nrDivs++;
			divisor = divisor * 10;
		}
		
		return nrDivs;
	}

}
