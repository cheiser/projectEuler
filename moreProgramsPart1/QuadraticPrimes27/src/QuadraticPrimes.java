
public class QuadraticPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SieveOfEratosthenes siv = new SieveOfEratosthenes();
		boolean[] primes = siv.getPrimes(1000000);
		
		int a = 0, b = 0, longest = 0;
		for(int i = -999; i < 999; i++){ // a
			for(int j = -999; j < 999; j++){ // b
				int n = 0;
				while(true){
					if((int)(Math.pow(n, 2) + i*n + j) > 0){
						if(primes[(int)(Math.pow(n, 2) + i*n + j)])
							n++;
						else
							break;
					}else{
						break;
					}
				}
				if(n > longest){
					longest = n;
					a = i;
					b = j;
				}
			}
		}
		
		System.out.println("the best one got length: " + longest + " with the values:" +
				a + " and " + b);
	}
}
