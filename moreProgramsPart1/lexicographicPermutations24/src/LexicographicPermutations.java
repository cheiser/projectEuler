import java.util.Arrays;


public class LexicographicPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr1 = {"test1", "test2", "test3"};
		String[] arr2 = {"test4", "test5", "test6", "test7"};
		String[] concated = (new LexicographicPermutations()).concatStringArrs(arr1, arr2);
		
		for(int i = 0; i < concated.length; i++){
			System.out.println("at " + i + " is " + concated[i]);
		}
		
		
		LexicographicPermutations lp = new LexicographicPermutations();
		String[] permutations1 = lp.getPermutations("0123456789");
		long[] permutations = lp.convertToIntArr(permutations1);
		for(int i = 0; i < permutations.length; i++){
			// System.out.println("permutation " + (i + 1) + " is " + permutations[i]);
			if(i+1 == 1000000)
				System.out.println("permutation " + i + " is " + permutations[i]);
		}
	}
	
	/**
	 * returns all permutations of the string permutate
	 * @param permutate the string to be permutateds
	 * @return the permuations of the strings
	 */
	public String[] getPermutations(String permutate){
		// all permutations of a string is all different first letters followed by all
		// permutations of the rest of the string
		
		return getPerms(permutate, "");
	}
	
	/**
	 * returns the string permutate permutated with the string locked appended to the beginning
	 * @param permutate the string to be permutated
	 * @param locked the variable to be appended
	 * @return all permutations of the permutate string with the variable locked concatenated
	 */
	public String[] getPerms(String permutate, String locked){
		if(permutate.equals("")){
			String[] tempArr = {locked};
			return tempArr;
		}
		
		String[] tempArr = {};
		for(int i = 0; i < permutate.length(); i++){
			String temp = "";
			for(int n = 0; n < permutate.length(); n++){
				temp = temp + (i == n? "" : permutate.charAt(n));
			}
			
			tempArr = concatStringArrs(getPerms(temp, locked + permutate.charAt(i)), tempArr);
		}
		
		return tempArr;
	}
	
	/**
	 * concatenates two string arrays
	 * @param arr1 the first array (will be first in the new array)
	 * @param arr2 the second array
	 * @return the two arrays concatenated
	 */
	private String[] concatStringArrs(String[] arr1, String[] arr2){
		String[] newArr = new String[arr1.length + arr2.length];
		int arrIndex = 0;
		for(int i = 0; i < arr1.length; i++){
			newArr[arrIndex++] = arr1[i];
		}
		
		for(int i = 0; i < arr2.length; i++){
			newArr[arrIndex++] = arr2[i];
		}
		
		return newArr;
	}
	
	/**
	 * converts the string array to an int array and returns it sorted
	 * @param strings the string array to be converted
	 * @return an integer array version of strings sorted
	 */
	public long[] convertToIntArr(String[] strings){
		long[] intArray = new long[strings.length];
		
		for(int i = 0; i < intArray.length; i++){
			intArray[i] = Long.parseLong(strings[i]);
		}
		
		Arrays.sort(intArray);
		return intArray;
	}

}
