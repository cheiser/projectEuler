import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;


public class PandigitalProducts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPandigital("123"));
		BigInteger sum = new BigInteger("0");
		HashMap<Integer, Integer> uniqueNumbers = new HashMap<Integer, Integer>();
		for(int i = 1; i < 9876; i++){
			for(int j = 1; j < 9876; j++){
				if(isPandigital("" + i + j + (i*j))){
					System.out.println("is pandigital: " + "i: " + i + " j: " + j +
							" i*j: " + (i*j));
					uniqueNumbers.put((i*j), (i*j));
				}
			}
		}
		
		Iterator it = uniqueNumbers.keySet().iterator();
		while(it.hasNext()){
			sum = sum.add(new BigInteger(it.next() + ""));
		}
		
		
		System.out.println("sum " + sum);
	}
	
	public static boolean isPandigital(String number){
		if(number.length() != 9) return false;
//		System.out.println("number length: " + number.length() + " content: " + number);
		boolean[] numbers = new boolean[9];
		for(int i = 0; i < number.length(); i++){
			int nr = Integer.parseInt(number.substring(i, i+1));
			if(nr == 0) return false;
			if(numbers[nr-1] == true) return false;
			else numbers[nr-1] = true;
		}
		
		boolean ones = true;
		// step through numbers and verify that the numbers are in order, unecessary...
		for(int i = 0; i < numbers.length; i++){
			if(ones == false && numbers[i] == true) return false;
			if(numbers[i] == false) ones = false;
		}
		
		return true;
	}

}
