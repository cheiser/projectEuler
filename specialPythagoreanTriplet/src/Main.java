
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] triplet = specialPythagoreanTriplet(1000);
//		System.out.println("a = " + triplet[0] + " b = " + triplet[1] + " c = " + triplet[2]);
		
		sPythagorianTriplet(0, 0, 0, 1000, 0);

//		sPythagorianTriplet(1000);
		
//		forLoop(0, 0, 0, 2, 0);

		// forLoop(0, 3);
	}
	
	public static int[] specialPythagoreanTriplet(int number){
		int[] triplet = new int[3];
		int a = 0, b = 0, c = 0;
		
		while(a + b + c != number){
			
			if(a > 500){
				a = 0;
				b++;
			}
			double temp = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));
			int temp2 = (int) temp;
			if(temp - temp2 == 0){
				c = (int) temp;
			}
			c = 0;
			a++;
			System.out.println("a, b, c = " + a + ", " + b + ", " + c);
			System.out.println("temp = " + temp + " temp2 =  " + temp2);
			
		}
		
		triplet[0] = a;
		triplet[1] = b;
		triplet[2] = c;
		return triplet;
	}
	
	public static void sPythagorianTriplet(int number){
		for(int a = 0; a < number; a++){
			for(int b = 0; b < number; b++){
				for(int c = 0; c < number; c++){
					if((a + b + c) == number && pythagorianTriplet(a, b, c)){
						System.out.println("found number with a:" + a + ", b:" + b + ", c:" + c);
					}
				}
			}
		}
		
	}
	
	public static void sPythagorianTriplet(Integer a, Integer b, Integer c, int number, int current){
		if((a + b + c) == number && pythagorianTriplet(a, b, c)){
			System.out.println("found number with a:" + a + ", b:" + b + ", c:" + c);
		}
		
		if(a >= number || b >= number || c >= number){
			return;
		}
		
		if(current == 0){
			sPythagorianTriplet(a+1, b, c, number, current);
			current++;
		}
		if(current == 1){
			sPythagorianTriplet(a, b+1, c, number, current);
			current++;
		}
		if(current == 2){
			sPythagorianTriplet(a, b, c+1, number, current);
		}
		
		
	}
	
	private static boolean pythagorianTriplet(int a, int b, int c){
		if((Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(c, 2)){
			return true;
		} else{
			return false;
		}
	}
	
	/**
	 * simulates a triplenested for-loop using recursion
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static boolean forLoop(int a, int b, int c, int max, int current){
		if(a < max && b < max && c < max){
			if(current == 0){
				forLoop(a+1, b, c, max, current);
				current++;
			}
			if(current == 1){
				forLoop(a, b+1, c, max, current);
				current++;
			}
			if(current == 2){
				forLoop(a, b, c+1, max, current);
			}
		}else{
			return false;
		}
		// anledningen till att det failar är för att den går ner i en och sedan går tillbaka men sedan tar
		// den samma väg igen eftersom den i t.ex. b går in i a direkt fastän den redan har besökts
		
		System.out.println("numbers: " + a + b + c);
		return false;
	}
	
	private static boolean forLoop(int a, int max){
		if(a < max){
			forLoop(a+1, max);
		}else{
			return false;
		}
		
		System.out.println("number: " + a);
		return false;
	}
}
