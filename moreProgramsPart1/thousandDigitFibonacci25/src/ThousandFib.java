import java.math.BigInteger;


public class ThousandFib {
	public static int digits = 1000;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("biggest number greater than " + ThousandFib.digits + " is " +
		fibNr(new BigInteger("1"), new BigInteger("1"), 3));
	}
	
	
	public static long fibNr(BigInteger big1, BigInteger big2, long index){
		if(big1.add(big2).toString().length() >= digits){
			return index;
		} else{
			return fibNr(big2, big1.add(big2), index+1);
		}
	}
	
	
	

}
