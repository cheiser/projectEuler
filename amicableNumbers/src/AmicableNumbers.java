import java.util.ArrayList;


public class AmicableNumbers {
	
	
	// borde f�rmodligen skapa en bool matrix(initial 0 p� alla positioner) d�r man indexerar som f�ljande:
	// [siffran man vill se "divisors" f�r][siffran man kollar om den �r en "divisor"(har 1 om den kan det)]
	
	// borde dock kunna f�renkla avserv�rt och endast skapa en array d�r man sparar "divisor" summan p�
	// motsvarande plats. t.ex. listan[6] ger 6 d� "proper divisors" p� 6 �r 1, 2, 3 och dessa ger summan 6.
	// sedan n�r man ska hitta "amicable pairs" s� g�r man bara igenom listan fr�n b�rjan och kollar p�
	// den platsen i listan som resultatet ger och om det st�r samma d�r som det(index) man st�r p�
	// s� �r dem ett par.
	// man kan g�ra p� olika s�tt men det enklaste blir nog att dela slutresultatet med 2 d� summan av paren
	// kommer r�knas 2 g�nger.
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(findProperDivisorsSum(284));
		System.out.println(amicableNumbersSum(100000));
	}
	
	/**
	 * returns the sum of the amicable numbers
	 * @param to specifies for how far one should look for amicable pairs
	 * @return the sum of all the amicable pairs under the specified number
	 */
	public static long amicableNumbersSum(int to){
		long sum = 0;
		
		int[] properDivisorsSum = new int[to];
		
		for(int i = 0; i < to; i++){
			properDivisorsSum[i] += findProperDivisorsSum(i);// findProperDivisorsSumFast(i);
		}
		
//		for(int i = 0; i < to; i++){
//			System.out.println(i + " " + properDivisorsSum[i]);
//		}
		
		for(int i = 0; i < to; i++){
			try{
				// make sure that the sum isn't equal to the number itself, eg. d(6) == 6 which isn't a pair
				if(properDivisorsSum[properDivisorsSum[i]] == i && properDivisorsSum[i] != i){
					System.out.println(i + " and " + properDivisorsSum[i] + " is an amicable pair");
					sum += i;
				}
			} catch(IndexOutOfBoundsException ex){
//				System.out.println("out of bound");
				continue; // make sure that this behaves as you expect as it could cause problems if it skipped
			}
		}
		
		return sum;
	}
	
	
	
	/**
	 * returns the sum of the proper divisors for the number specified
	 * @param number the number to find divisors for
	 * @return the sum of all the proper divisors for the number
	 */
	public static int findProperDivisorsSum(int number){
		int sum = 0;
		
		for(int i = 1; i < (number/2)+1; i++){
			if(number % i == 0){
				sum += i;
			}
//			else{
//				System.out.println("number: " + number + " i: " + i);
//			}
		}
		
		
		return sum;
	}
	
	
	private static int findProperDivisorsSumFast(int number) {
	    int sqrtOfNumber = (int)Math.sqrt(number);
	    int sum = 1;
	 
	    //If the number is a perfect square
	    //Count the squareroot once in the sum of factors
	    if (number == sqrtOfNumber * sqrtOfNumber) {
	        sum += sqrtOfNumber;
	        sqrtOfNumber--;
	    }
	 
	    for (int i = 2; i <= sqrtOfNumber; i++) {
	        if (number % i == 0) {
	            sum = sum + i + (number / i);
	        }
	    }
	 
	    return sum;
	}
	
	
}
