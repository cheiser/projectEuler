
public class HighlyDivisibleTriangularNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] triangulars = {10, 20, 30, 40};
//		System.out.println(highlyDivisibleTriangular(500, 30000000));
		System.out.println(highlyDivisibleTriangularBruteForce(500, 3000000));
		System.out.println(highlyDivisibleTriangularBruteForce(5, 30));
//		System.out.println(highlyDivisibleTriangular(3, 1000));
//		System.out.println(isTriangular(20, triangulars));
//		System.out.println(isTriangular(11, triangulars));
//		System.out.println(isTriangular(340, triangulars));
	}
	
	
	public static int highlyDivisibleTriangular(int numberOfDivisors, int maxSizeNumber){
		int[] divisors = new int[maxSizeNumber];
		
		int[] triangularNumbers = new int[maxSizeNumber];
		int current = 0;
		
		for(int i = 0; i < maxSizeNumber; i++){
			current += i;
			triangularNumbers[i] += current;
		}
		
		for(int i = 1; i < maxSizeNumber; i++){
			for(int j = i; j < maxSizeNumber; j += i){
				divisors[j]++;
			}
		}
		
		int k = 0;
		for(int i = 0; i < maxSizeNumber; i++){
//			System.out.println(i + " : " + divisors[i]);
			
			if(divisors[i] >= numberOfDivisors && isTriangular(i, triangularNumbers)){
				System.out.println("the number " + i + " has " + divisors[i] + " divisors");
				if(k == 10){
					return i;
				}
				k++;
			}
		}
		
		return 0;
	}
	
	public static int highlyDivisibleTriangularBruteForce(int numberOfDivisors, int maxSizeNumber){
		int divisors = 0;
		int current = 0, k = 0;
		
		for(int i = 0; i < maxSizeNumber; i++){
			current += i;
			divisors = 0;
			
			int sqrt = (int) Math.sqrt(current);
			for(int j = 1; j <= sqrt; j++){
				if(current % j == 0){
					divisors += 2;
				}
			}
			
			if (sqrt * sqrt == current) {
				divisors--;
		    }
			
//			System.out.println("number of divisors: " + divisors + " for " + current);
			
			if(divisors >= numberOfDivisors){
				System.out.println("number of divisors: " + divisors + " for " + current);
				if(k == 0){
					return current;
				}
				k++;
			}
		}
		
		
		
		return 0;
	}

	private static boolean isTriangular(int number, int[] triangularNumber) {
		for(int j = 1; j < triangularNumber.length; j++){
			if(triangularNumber[j] == number){
				return true;
			}
			if(triangularNumber[j] == 0){
				return false;
			}
		}
		
		return false;
	}

}
