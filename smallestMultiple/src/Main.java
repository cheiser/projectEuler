
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("smallest multiple = " + smallestMultiple(1, 20));
	}
	
	/**
	 * returns the smallest positive number that is evenly divisible by all the numbers from "from" to "to"
	 * @param from the starting number to test
	 * @param to the end number to test
	 * @return the smallest positive number that is evenly divisible by all the numbers in the interval
	 */
	public static int smallestMultiple(int from, int to){
		int number = 0;
		for(int j = 0; number == 0; j++){
			for(int i = from; i < to; i++){
				// test the number here
				number = j;
				if(j%i != 0){
					number = 0;
					break;
				}
			}
		}
		return number;
	}

}
