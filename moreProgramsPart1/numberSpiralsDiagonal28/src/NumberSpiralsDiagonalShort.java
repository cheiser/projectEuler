
public class NumberSpiralsDiagonalShort {

	/**
	 * utilizes information about the underlying structure of the problem to make the problem
	 * easier.
	 * What i do is i first add 1 to the sum as this will be the centered one, after that i will
	 * want to add the first four numbers with 1 element between them, after them the next four
	 * but with 3 elements between them and then the next four with 5 elements and so on.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int addToI = 2;
		int addToICounter = 0;
		int sum = 1;
		
		for(int i = 3; i <= 1002001; i += addToI){
			sum += i;
			System.out.println("adding " + i);
			addToICounter++;
			if(addToICounter > 3){
				addToI += 2;
				addToICounter = 0;
			}
		}
		
		System.out.println("the sum is " + sum);
	}

}
