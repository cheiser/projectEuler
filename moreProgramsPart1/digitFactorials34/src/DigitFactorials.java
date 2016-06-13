import java.io.ObjectInputStream.GetField;


public class DigitFactorials {

	/**
	 * Algorithm: Store the factorials in an array where the result of using as the index the 
	 * number that one wants the factorial for, so for example fact[4] == 24
	 * If the resulting factorial sum of any digit is greater than the sought after sum we don't
	 * need to look on any higher numbers....
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fact = DigitFactorials.getFactArray(9);
		/* for(int i = 0; i < fact.length; i++){
			System.out.println("the factorial for " + i + " is " + fact[i]);
		}
		System.out.println("the digits is: ");
		for(int i = 0; i < getDigits(43256).length; i++){
			System.out.println("digit " + (i+1) + " is " + (getDigits(43256))[i]);
		}
		/**/
		int totSum = 0;
		for(int i = 3; i < 3265920; i++){
			int sum = 0;
			int[] digits = DigitFactorials.getDigits(i);
			for(int j = 0; j < digits.length; j++){
				sum += fact[digits[j]];
			}
			
			if(sum == i){
				System.out.println("works for " + i);
				totSum = totSum+sum;
			}
		}
		
		System.out.println("totSum: " + totSum);
	}
	
	/**
	 * Returns an array with the factorial for each number from 0 to top,
	 * so for example (getFactArray(10))[4] == 24
	 * @param top the biggest number we want to get factorials for
	 * @return an array with factorials for the numbers from 0 to and including top
	 */
	public static int[] getFactArray(int top){
		int[] factArr = new int[top+1];
		factArr[0] = 1;
		for(int i = 1; i < top+1; i++){
			factArr[i] = factArr[i-1] * i;
		}
		
		return factArr;
	}
	
	/**
	 * Returns an array of the individual digits in the number passed as argument, is zero-
	 * indexed so if you want the first digits you use 0 as index and so on
	 * @param number the number you want the digits for
	 * @return an array of the individual digits for the number
	 */
	public static int[] getDigits(int number){
		int length = 0;
		int tempNr = number;
		while(tempNr > 0){
			tempNr = tempNr / 10;
			length++;
		}
		
		int[] digits = new int[length];
		tempNr = number;
		int index = length-1;
		while(tempNr > 0){
			digits[index--] = tempNr % 10;
			tempNr = tempNr / 10;
			
		}
		
		return digits;
	}
	
	public static boolean isEqual(int[] arr1, int[] arr2){
		if(arr1.length != arr2.length)
			return false;
		for(int i = 0; i < arr1.length; i++)
			if(arr1[i] != arr2[i])
				return false;
		
		return true;
	}
	

}
