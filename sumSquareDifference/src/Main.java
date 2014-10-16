
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("sumOfSquares = " + sumOfSquares(1, 100));
		System.out.println("squareOfSums = " + squareOfSums(1, 100));
		System.out.println("sum square difference = " + sumSquareDifference(1, 100));
	}
	
	public static int sumSquareDifference(int from, int to){
		return squareOfSums(from, to) - sumOfSquares(from, to);
	}
	
	public static int sumOfSquares(int from, int to){
		int sum = 0;
		for(int i = from; i <= to; i++){
			sum += Math.pow(i, 2);
		}
		return sum;
	}
	
	public static int squareOfSums(int from, int to){
		int sum = 0;
		
		for(int i = from; i <= to; i++){
			sum += i;
		}
		
		return (int) Math.pow(sum, 2);
	}

}
