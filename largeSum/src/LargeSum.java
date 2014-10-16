import java.io.IOException;
import java.math.BigInteger;

// problemet är att man ska läsa nummer som är 50 "tecken" långa, inte läsa varje siffra för sig
public class LargeSum {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		System.out.println("getSum = " + getSum("1234"));
		String numbers = FileManager.readFileAsString("C:\\Users\\Mattis\\workspace\\projectEuler\\" +
				"largeSum\\src\\test.txt", "");
		
		String[] numbers2 = FileManager.readFileAsStrings("C:\\Users\\Mattis\\workspace\\projectEuler\\" +
				"largeSum\\src\\test.txt");
		
		System.out.println("numbers: " + numbers.charAt(10));
		
		System.out.println("sum: " + getSum2(numbers));
		System.out.println("sum: " + getSum(numbers2));
		
//		printNumber(numbers2);
	}
	
	
	public static BigInteger getSum2(String numberString){
		BigInteger sum = new BigInteger("0");
		
		for(int i = 0; i < numberString.length(); i += 50){
			BigInteger num = new BigInteger(numberString.substring(i, i+50));
			sum = sum.add(num);
		}
		
		return sum;
	}
	
	public static long getSum(String numberString){
		long sum = 0;
		long overFlow = 0;
		for(int n = 0; n < numberString.length(); n++){
			sum += Integer.parseInt(numberString.substring(n, n+1));
			if(sum >= Long.MAX_VALUE-9){
				overFlow++;
			}
		}
		
		System.out.println("overFlow = " + overFlow);
		return sum;
	}
	
	public static long getSum(String[] numberStrings){
		long sum = 0;
		long overFlow = 0;
		for(int i = 0; i < numberStrings.length; i++){
			for(int n = 0; n < numberStrings[i].length(); n++){
				sum += Integer.parseInt(numberStrings[i].substring(n, n+1));
				if(sum >= Long.MAX_VALUE-9){
					overFlow++;
				}
			}
		}
		
		
		System.out.println("overFlow = " + overFlow);
		return sum;
	}
	
	
	public static void printNumber(String[] numbers){
		for(int i = 0; i < numbers.length; i++){
			System.out.println(numbers[i]);
		}
	}
	

}
