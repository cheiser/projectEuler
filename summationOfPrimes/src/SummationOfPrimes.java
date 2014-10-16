
public class SummationOfPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("sum of primes = " + sumOfPrimes(2000000));
	}
	
	/**
	 * returns the sum of all primes below the specified number
	 * @param primesBelow the number that the prime must be below to be counted into the sum
	 * @return the sum of all the primes belowed the limit
	 */
	public static long sumOfPrimes(int primesBelow){
		long sum = 0;
		SieveOfEratosthenes siv = new SieveOfEratosthenes();
		boolean[] primes = siv.getPrimes(primesBelow+1);
		
		for(int i = 0; i < primes.length; i++){
			if(primes[i]){
				sum += i;
			}
		}
		
		return sum;
	}

}
