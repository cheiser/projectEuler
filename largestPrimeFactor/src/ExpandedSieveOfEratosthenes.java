
public class ExpandedSieveOfEratosthenes {
	private boolean[][] primes;
	private long primesSize = 0;
	private int indexOuter;
	private int indexInner;
	
	public ExpandedSieveOfEratosthenes(){
		
	}
	
	public void findPrimes(long maxSize){
		int sqrtMaxSize = (int) Math.sqrt(maxSize);
		indexOuter = 1;
		indexInner = (int) maxSize; // TODO:
		
		for(int i = sqrtMaxSize; i > 1; i--){
			if(maxSize%i == 0){
				indexOuter = i;
				indexInner = (int) (maxSize/i);
				break;
			}
		}
		
		
		
		primesSize = maxSize;
		primes = new boolean[indexOuter][indexInner];
		
		// loop through all and set them to prime and later change the ones that's not prime
		for(int i = 0; i < indexOuter; i++){
			for(int j = 0; j < indexInner; j++){
				primes[i][j] = true;
			}
		}
		
		for(int i = 0; i < indexOuter; i++){
			for(int j = 0; j < indexInner; j++){
				if(primes[i][j] == true){
					// Go through the array to the end, setting all the multiples of the current number to false
					long primeNumber = this.getNumber(i, j, indexOuter, indexInner);
					if(primeNumber == 1) continue; // TODO: MAKE A SEXIER SOLUTION HERE
					
					
					// for every time i goes up one the number increases with j
					for(long n = 2; primeNumber*n <= maxSize; n++){
						int[] indexes = this.getIndexes((n*primeNumber), indexOuter, indexInner);
						primes[indexes[0]][indexes[1]] = false;
					}
				}
			}
		}
	}
	
	public void printPrimes(){
		for(int i = 0; i < indexOuter; i++){
			for(int j = 0; j < indexInner; j++){
				if(primes[i][j]){
					System.out.println(this.getNumber(i, j, indexOuter, indexInner));
				}
			}
		}
	}
	
	
	public void printMatrix(){
		for(int i = 0; i < indexOuter; i++){
			for(int j = 0; j < indexInner; j++){
				System.out.print(this.getNumber(i, j, indexOuter, indexInner) + " ");// primes[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * gets the number that should be in a matrix containing all numbers from 1 to max, inorder
	 * @param i the i "coordinate" one is currently at
	 * @param j the j "coordinate" one is currently at and want to know the number for
	 * @param maxI the ceiling for the i coord
	 * @param maxJ the ceiling for the j coord
	 * @return
	 */
	public long getNumber(int i, int j, int maxI, int maxJ){
		return (i*maxJ)+(j+1);
	}
	
	/**
	 * Gets the indexes for a number if that number would be part of a matrix which contains all numbers from
	 * 1 to max, inorder
	 * @param number the number one wants the indexes for
	 * @param maxI the ceiling for the i coordinate
	 * @param maxJ the ceiling for the j coordinate
	 * @return the indexes for the number, the i coord is in the first cell and the j in the second
	 */
	public int[] getIndexes(long number, int maxI, int maxJ){
		int[] indexes = new int[2];
		
		// Hitta största möjliga värdet på i där i * maxJ är mindre än number
		// dra av 1 från number och dela sedan med maxJ och avrunda neråt för att få fram i
		// för att sedan få fram j tar man bara (number - (i*maxJ + 1))
		
		indexes[0] = (int) Math.floor((number-1)/maxJ); // the i coordinate
		indexes[1] = (int) (number - ((indexes[0]*maxJ)+1)); // the j coordinate
		
		return indexes;
	}
	
	public boolean isPrime(int prime){
		int[] indexes = this.getIndexes(prime, indexOuter, indexInner);
		if(primes[indexes[0]][indexes[1]]){
			return true;
		} else{
			return false;
		}
	}
	
	public boolean[][] getPrimes() {
		return primes;
	}
	
	public boolean[][] getPrimes(int toNumber) {
		this.findPrimes(toNumber);
		return primes;
	}
	
	public long getPrimesSize() {
		return primesSize;
	}
}
