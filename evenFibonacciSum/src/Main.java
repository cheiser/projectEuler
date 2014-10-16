
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(evenFibSum(4000000));
	}
	
	
	public static int evenFibSum(int max){
		int fib1 = 1, fib2 = 1, curFib = 2, sum = 0;
		
		while(true){
			curFib = fib1 + fib2;
			fib1 = fib2;
			fib2 = curFib;
			
			if(fib2 >= max){
				break;
			}
			
			if((curFib % 2) == 0){
				sum += curFib;
			}
		}
		return sum;
	}

}
