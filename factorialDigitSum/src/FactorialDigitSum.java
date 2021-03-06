import java.math.BigInteger;


public class FactorialDigitSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getFactorialDigitSum(100));
	}
	
	public static long getFactorialDigitSum(int factorialNumber){
		BigInteger largeFactorial = new BigInteger("1");
		String largeFacString = "";
		long sum = 0;
		
		for(int i = 1; i < factorialNumber; i++){
			largeFactorial = largeFactorial.multiply(new BigInteger("" + i));
		}
		
		largeFacString = largeFactorial.toString();
		
		for(int i = 0; i < largeFacString.length(); i++){
			sum += Integer.parseInt(largeFacString.substring(i, i+1));
		}
		
		return sum;
	}
}
