

public class CircularPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SieveOfEratosthenes siv = new SieveOfEratosthenes(); // sieve from QuadraticPrimes27
		boolean[] primes = siv.getPrimes(1000000);
		
		int numberOfCircularPrimes = 0;
		for(int i = 2; i < 1000000; i++){ // 1000000
			int[] digits = DigitFactorials.getDigits(i); // getDigits from problem34
			// TODO: count the number of cirular primes
			if(isCircularPrime(digits, primes)){
				numberOfCircularPrimes++;
//				System.out.println("number: " + i + " is circular prime");
			}
			
		}
		
		System.out.println("number of circular primes: " + numberOfCircularPrimes);
		
		
	}
	
	public static boolean isCircularPrime(int[] number, boolean[] primes){
		for(int i = 0; i < number.length; i++){
			int[] shifted = shiftArray(number, i);
			String intString = "";
			for(int j = 0; j < number.length; j++){
				intString = intString + shifted[j];
			}
			if(!primes[Integer.parseInt(intString)])
				return false;
		}
		
		return true;
	}
	
	
	/**
	 * shifts the array "arr" "steps" steps to the right and returns the resulting array
	 * @param arr the array to be shifted, e.g. arr = {1, 2, 3} and steps = 1 will result in
	 * the array newArr = {3, 1, 2}
	 * @param steps the number of steps to shift to the left
	 * @return the result of the shift operation
	 */
	public static int[] shiftArray(int[] arr, int steps){
		int[] newArr = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			newArr[(i + steps) % arr.length] = arr[i];
		}
		
		return newArr;
	}
	
	/**
	 * returns all permutations of the array passed as an argument
	 * @param digits the array to be permutated
	 * @return all permutations of the array as an array, so the first permutated array is
	 * accessed as (permutate(a))[0] and the first element in that array as (permutate(a))[0][0]
	 */
	public static int[][] permutate(int[] digits){
		int[][] perms = new int[factorial(digits.length)][digits.length];
		permutateArray(digits, new int[digits.length], perms, digits.length, new int[2]);
		return perms;
	}
	
	private static void permutateArray(int[] oldDigits, int[] newDigits, int[][] permutations,
			int level, int[] indexPointer){
		if(level == 0){
			permutations[indexPointer[0]] = newDigits;
			indexPointer[0]++;
			return;
		}
		
		for(int i = 0; i < oldDigits.length; i++){
			int[] tempNewArr = copyArray(newDigits);
			tempNewArr[newDigits.length-level] = oldDigits[i];
			permutateArray(copyArrayMinusNumber(oldDigits, oldDigits[i]), tempNewArr, permutations, level-1, indexPointer);
		}
	}
	
	private static int factorial(int number){
		int fact = 1;
		for(int i = 1; i <= number; i++){
			fact *= i;
		}
		return fact;
	}
	
	// really ugly fast solution, requires that the digits really is in the array
	private static int[] copyArrayMinusNumber(int[] arr, int digit){
		int[] newArr = new int[arr.length-1];
		int arrayPointer = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != digit)
				newArr[arrayPointer++] = arr[i];
		}
		
		return newArr;
	}
	
	// really ugly fast solution
	private static int[] copyArray(int[] arr){
		int[] newArr = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
				newArr[i] = arr[i];
		}
		
		return newArr;
	}
	

}
