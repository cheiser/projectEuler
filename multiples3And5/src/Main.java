
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumOfAllMultiples(1000, 3, 5));
	}
	
	
	public static int sumOfAllMultiples(int limit, int multiNumber1, int multiNumber2){
		int sum = 0;
		for(int i = 1; i < limit; i++){
			if(((i % multiNumber1) == 0) || ((i % multiNumber2) == 0)){
				sum += i;
			}
		}
		return sum;
	}
}
