
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(largestPrimeFactor(600851475143L, 1400000000));
		
		
//		ExpandedSieveOfEratosthenes esoe = new ExpandedSieveOfEratosthenes();
//		SieveOfEratosthenes soe = new SieveOfEratosthenes();
//		
//		int[] ind = esoe.getIndexes(6, 5, 3);
//		int number = (int) esoe.getNumber(0, 0, 5, 3);
//		System.out.println("indexes: " + ind[0] + " " + ind[1]);
//		System.out.println("number: " + number);
//		
//		esoe.findPrimes(30);
//		esoe.printPrimes();
////		esoe.printMatrix();
//		
//		soe.findPrimes(30);
//		soe.printPrimes();
	}
	
	
	public static int largestPrimeFactor(long findFactorNumber, int largestPrime){
		SieveOfEratosthenes siev = new SieveOfEratosthenes();
		boolean[] primes = siev.getPrimes(largestPrime);
		
		for(int i = primes.length-1; i > 1; i--){
			if(primes[i] && (findFactorNumber % i == 0)){
				return i;
			}
		}
		return 1;
	}
	
//	public static int largestPrimeFactor(long findFactorNumber, int largestPrime){
//		ExpandedSieveOfEratosthenes siev = new ExpandedSieveOfEratosthenes();
//		boolean[][] primes = siev.getPrimes(largestPrime);
//		
//		System.out.println("Done getting primes");
////		6857
////		for(int i = primes.length-1; i > 1; i--){
////			if(siev.isPrime(i) && (findFactorNumber % i == 0)){
////				return i;
////			}
////		}
//		return 1;
//	}
}
