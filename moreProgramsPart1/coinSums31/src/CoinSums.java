import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

// still not f***ing working....
public class CoinSums {
	private static HashMap<String, int[]> sums = new HashMap<String, int[]>();
	
	private static int increasePlace = 0;
	private static int goalNumber = 5;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("get value: " + getValue(3));
		int[] coinArray = new int[8];
		CoinSums.sumCoins(coinArray, goalNumber, 0);
		
		printHashmap();
//		for(int i = 0; i < sums.size(); i++){
//			System.out.println("one solution: ");
//			printArray(sums.get(i));
//		}
	}
	
	// stega neråt och för varje steg provar vi att ta en av varje möjligt alternativ(1p, 2p osv)
	// för varje steg drar vi bort motsvarande peng från startsumman(200) och gör så tills
	// start summan är 0.
	
	public static void sumCoins(int[] coinSum, int startSum, int increaseIndex){
		if(startSum == 0){
//			System.out.println("bottomed out with ");
			// printArray(coinSum);
//			System.out.println("coinSum.toString = " + coinSum.toString());
			sums.put(makeString(coinSum), copyArray(coinSum));
			if(coinSum[0] == goalNumber && increasePlace == 0)
				increasePlace = 1;
			if(coinSum[1] >= goalNumber/2 && increasePlace == 1)
				increasePlace = 2;
			if(coinSum[2] >= goalNumber/5 && increasePlace == 2)
				increasePlace = 3;
			if(coinSum[3] >= goalNumber/10 && increasePlace == 3)
				increasePlace = 4;
			if(coinSum[4] >= goalNumber/20 && increasePlace == 4)
				increasePlace = 5;
			if(coinSum[5] >= goalNumber/50 && increasePlace == 5)
				increasePlace = 6;
			if(coinSum[6] >= goalNumber/100 && increasePlace == 6)
				increasePlace = 7;
			return;
		}else if(startSum <= 0){
			// System.out.println("to big returning");
			if(coinSum[0] == goalNumber && increasePlace == 0)
				increasePlace = 1;
			if(coinSum[1] >= goalNumber/2 && increasePlace == 1)
				increasePlace = 2;
			if(coinSum[2] >= goalNumber/5 && increasePlace == 2)
				increasePlace = 3;
			if(coinSum[3] >= goalNumber/10 && increasePlace == 3)
				increasePlace = 4;
			if(coinSum[4] >= goalNumber/20 && increasePlace == 4)
				increasePlace = 5;
			if(coinSum[5] >= goalNumber/50 && increasePlace == 5)
				increasePlace = 6;
			if(coinSum[6] >= goalNumber/100 && increasePlace == 6)
				increasePlace = 7;
			return;
		}
		
		for(int i = increasePlace; i < 8; i++){
			coinSum[i] = coinSum[i] + 1;
			sumCoins(coinSum, startSum - getValue(i+1), i);
//			printArray(coinSum);
			coinSum[i] = coinSum[i] - 1;
		}
	}
	
	
	public static int getValue(int index) throws IndexOutOfBoundsException{
		switch(index){
		case 1:
				return 1;
		case 2:
				return 2;
		case 3:
				return 5;
		case 4:
				return 10;
		case 5:
				return 20;
		case 6:
				return 50;
		case 7:
				return 100;
		case 8:
				return 200;
		default:
				throw new IndexOutOfBoundsException("out of bound in getValue");
		}
	}
	
	public static void printArray(int[] array){
		if(array == null)
			return;
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	
	public static int[] copyArray(int[] arr){
		int[] tempArr = new int[arr.length];
		
		for(int i = 0; i < tempArr.length; i++){
			tempArr[i] = arr[i];
		}
		
		return tempArr;
	}
	
	
	public static void printHashmap(){
		Iterator<Entry<String, int[]>> it = sums.entrySet().iterator();
		
		while(it.hasNext()){
			Entry<String, int[]> temp = it.next();
			System.out.println("sums key: " + temp.getKey());
			printArray(temp.getValue());
		}
	}
	
	
	public static String makeString(int[] arr){
		String tempString = "";
		
		for(int i = 0; i < arr.length; i++){
			tempString = tempString + arr[i];
		}
		
		return tempString;
	}
	
	
}