
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("10001st prime = " + nthPrime(10001));
	}
	
	public static long nthPrime(int n){
		int prime = 0, primeCount = 0;
		SieveOfEratosthenes siv = new SieveOfEratosthenes();
		boolean[] primes = siv.getPrimes(14000000);
		for(int i = 0; i < primes.length; i++){
			if(primes[i]){
				primeCount++;
			}
			
			if(primeCount == n){
				prime = i;
				break;
			}
		}
		
		return prime;
	}

}
