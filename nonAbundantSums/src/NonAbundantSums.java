import java.math.BigInteger;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class NonAbundantSums {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tempNr = 14100;
		Integer[] divs = properDivisors(tempNr);
		for(int i = 0; i < divs.length; i++){
			System.out.println("divisor: " + divs[i]);
		}
		System.out.println("is abundant: " + isAbundant(tempNr));
		
		int maxNumber = 28200;
		
		List<Integer> abundantNumbers = new ArrayList<Integer>();
		for(int i = 1; i < maxNumber; i++){
			if(isAbundant(i))
				abundantNumbers.add(i);
		}
		
		boolean[] sumAbundNum = new boolean[maxNumber+1];
		for(int i = 0; i < abundantNumbers.size(); i++){
			for(int j = i; j < abundantNumbers.size(); j++){
//				System.out.println("storing the sum of " + (abundantNumbers.get(i)) + " and " + (abundantNumbers.get(j)));
				if((abundantNumbers.get(i)) + (abundantNumbers.get(j)) < maxNumber)
				sumAbundNum[(abundantNumbers.get(i)) + (abundantNumbers.get(j))] = true;
				if((abundantNumbers.get(i)) + (abundantNumbers.get(j)) == 28199) // 28120
					System.out.println("28120 made with " + abundantNumbers.get(i) + " and " + abundantNumbers.get(j));
			}
		}
		
		BigInteger sum = new BigInteger("0");
		for(int i = 1; i < maxNumber; i++){
			if(sumAbundNum[i] == false){
//				System.out.println("adding " + i);
				sum = sum.add(new BigInteger("" + i));
			}
		}
		
		System.out.println("the sum is " + sum);
		
		System.out.println(abundantNumbers.size());
		/**/
	}
	
	
	
	public static Integer[] properDivisors(int divNumber){
		List<Integer> divisorsList = new ArrayList<Integer>();
		for(int i = 1; i < (divNumber/2)+1; i++){
			if(divNumber%i == 0) // ((divNumber / i) - ((double)divNumber/(double)i) == 0)
				divisorsList.add(i);
		}
		
		return divisorsList.toArray(new Integer[divisorsList.size()]);
	}
	
	
	public static boolean isAbundant(Integer number){
		int sum = 0;
		Integer[] properDivisors = properDivisors(number);
		
		for(int i = 0; i < properDivisors.length; i++){
			sum += properDivisors[i];
		}
		
		return sum > number;
	}
	

}
