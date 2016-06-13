import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class DistinctPowers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// use hashmap to store the values and BigInteger during calculations
		HashMap<String, BigInteger> values = new HashMap<String, BigInteger>();
		
		for(int i = 2; i <= 100; i++){
			for(int j = 2; j <= 100; j++){
				BigInteger temp = new BigInteger("" + i);
				temp = temp.pow(j);
				values.put(temp.toString(), temp);
				// System.out.println("temp tostring: " + temp.toString());
			}
		}
		
		Iterator<Entry<String, BigInteger>> it = values.entrySet().iterator();
		long distinct = 0;
		while(it.hasNext()){
			distinct++;
			it.next();
		}
		
		System.out.println("distinct values: " + distinct);
	}

}
