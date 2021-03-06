
public class LargeBinaryPower {
	
	private static int arraySize = 305; // 305 because it fits 2^1000 nicely
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printArray(largePowerBinary(1000));
		System.out.println(sumArray(largePowerBinary(1000)));
	}
	
	
	/**
	 * algoritm:
	 * b�rja med tv� p� position 499 och dubbla det, forts�tt dubbla tills man �verstiger 10 d� tar man resten(
	 * allts� man l�mnar det som kommer efter 1 i 10 och flyttar den 1'an) och flyttar ett steg �t v�nster(
	 * position 498) och dubblar f�rst det som redan �r d�r och g�r ovanst�ende med rest m.m. och sedan adderar
	 * den 1'an som man har fr�n rest i nedanst�ende.
	 * 
	 * @param raiseTo
	 * @return
	 */
	// raises the number 2 to the power of the specified number
	public static int[] largePowerBinary(int raiseTo){
		int[] theNumber = new int[arraySize];
		
		int lastIndex = arraySize-1;
		theNumber[lastIndex] = 1;
		for(int i = 0; i < raiseTo; i++){
			int carry = 0;
			for(int j = arraySize-1; j >= 0; j--){
				int temp = (theNumber[j]*2)+carry;
				if(temp > 9){
					carry = 1;
					theNumber[j] = temp-10;
				} else{
					carry = 0;
					theNumber[j] = temp;
				}
			}
		}
		
		return theNumber;
	}
	
	public static void printArray(int[] theArray){
		for(int i = 0; i < theArray.length; i++){
			System.out.print(theArray[i]);
		}
		System.out.println();
	}
	
	
	public static long sumArray(int[] theArray){
		long sum = 0;
		
		for(int i = 0; i < theArray.length; i++){
			sum += theArray[i];
		}
		
		return sum;
	}
	
}
