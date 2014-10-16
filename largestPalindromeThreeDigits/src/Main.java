
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test is palindrome: " + isPalindrome("test"));
		System.out.println("tet is palindrome: " + isPalindrome("tet"));
		System.out.println("9009 is palindrome: " + isPalindrome("9009"));
		System.out.println("9018 is palindrome: " + isPalindrome("9018"));
		System.out.println("aftfa is palindrome: " + isPalindrome("aftfa"));
		
		System.out.println(calculateStartNumber(4));
		
		System.out.println("largest palindrome is " + largestPalindromeFromXNumbersLong(3));
	}
	
	public static int largestPalindromeFromXNumbersLong(int x){
		int startNumber = calculateStartNumber(x);
		int palindromeNumber = 0;
		
		System.out.println("startNumber is " + startNumber);
		
		for(int i = startNumber; i > 0; i--){
			for(int j = startNumber; j > 0; j--){
				if((i*j > palindromeNumber) && isPalindrome(Integer.toString(i*j))){
					palindromeNumber = i*j;
				}
			}
		}
		
		return palindromeNumber;
	}
	
	private static int calculateStartNumber(int xLong){
		int temp = 0;
		
		for(int i = 0; i < xLong; i++){
			temp += 9 * (Math.pow(10, (i)));
		}
		
		return temp;
	}
	
	
	/**
	 * Checks if the entered string is a palindrome
	 * @param checkIfPalindrome the string to be checked
	 * @return true if palindrome, false otherwise
	 */
	public static boolean isPalindrome(String checkIfPalindrome){
		for(int i = 0; i < checkIfPalindrome.length()/2; i++){
			if(checkIfPalindrome.charAt(i) != checkIfPalindrome.charAt((checkIfPalindrome.length()-1)-i)){
				return false;
			}
		}
		return true;
	}

}
