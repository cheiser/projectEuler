
public class SieveOfEratosthenes {
	private boolean[] primes;
	private int primesSize = 0;
	
	public SieveOfEratosthenes(){
		
	}
	
	public void findPrimes(int maxSize){
		primesSize = maxSize;
		primes = new boolean[maxSize];
		// loop through all and set them to prime and later change the ones that's not prime
		for(int i = 2; i < maxSize; i++){
			primes[i] = true;
		}
		
		
		for(int i = 2; i*i < maxSize; i++){
			if(primes[i] == true){
				for(int j = i; j*i < maxSize; j++){
					primes[j*i] = false;
				}
			}
		}
	}
	
	public void printPrimes(){
		for(int i = 0; i < primesSize; i++){
			if(primes[i]){
				System.out.println(i);
			}
		}
	}
	
	
	public boolean isPrime(int prime){
		if(primes[prime]){
			return true;
		} else{
			return false;
		}
	}
	
	public int findPrimeThatContains(int number){
		String numberS = new Integer(number).toString();
		for(int i = number; i < primesSize; i++){
			if(isPrime(i) && new Integer(i).toString().contains(numberS)){
				return i;
			}
		}
		
		return -1;
	}
	
	
	public int findPrimeThatContains(int number1, int number2){
		String number1S = new Integer(number1).toString();
		String number2S = new Integer(number2).toString();
		for(int i = Integer.parseInt(number1S + number2S); i < primesSize; i++){
			if(isPrime(i)){
				String iString = new Integer(i).toString();
				if(iString.contains(number1S) && iString.contains(number2S)){
					return i;
				}
			}
		}
		
		return -1;
	}
	
	public boolean[] getPrimes() {
		return primes;
	}
	
	public boolean[] getPrimes(int toNumber) {
		this.findPrimes(toNumber);
		return primes;
	}
	
	public int getPrimesSize() {
		return primesSize;
	}
}
