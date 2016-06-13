import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NamesScore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> names = null;
		
		BigInteger allNamesScore = new BigInteger("0");
		
		String fileName = "C:\\Users\\Mattis\\workspace\\projectEuler\\namesScores\\src\\names.txt";
		
		try {
			names = NamesScore.readFile(fileName);
			System.out.println("READ NAMES \nprinting the 10 first");
			for(int i = 0; i < 10; i++){
				System.out.println(names.get(i));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("could not find the specified files, EXITING");
		}
		
		// Collections.sort(names, String.CASE_INSENSITIVE_ORDER);
		names = mergeSort(names);
		
		System.out.println("after sort");
		for(int i = 0; i < 10; i++){
			System.out.println(names.get(i));
		}
		
		for(int i = 0; i < names.size(); i++){
			allNamesScore = allNamesScore.add(new BigInteger("" + (nameSum(names.get(i)) * (i + 1))));
			if(names.get(i).equals("COLIN")){
				System.out.println("colins total: " + nameSum(names.get(i)) * (i + 1));
			}
		}
//		System.out.println("nameSum COLIN: " + nameSum("COLIN"));
//		allNamesScore = allNamesScore.add(new BigInteger("" + nameSum("COLIN")));
		System.out.println("big integer: " + allNamesScore.toString());
		
		System.out.println("LAST NAME: " + names.get(names.size()-1));
		
		
		
		List<String> sortIt = new ArrayList<String>();
		sortIt.add("1");
		sortIt.add("3");
		sortIt.add("7");
		sortIt.add("8");
		sortIt.add("9");
		sortIt.add("10");
		sortIt.add("11");
		
		
		List<String> sortIt2 = new ArrayList<String>();
		sortIt2.add("2");
//		sortIt2.add("4");
//		sortIt2.add("5");
//		sortIt2.add("6");
//		sortIt2.add("9");
//		sortIt2.add("13");
//		sortIt2.add("14");
		
		System.out.println("MERGESORTED: ");
		sortIt = mergeSort(sortIt); // merge(sortIt, sortIt2);
		for(int i = 0; i < sortIt.size(); i++){
			System.out.println("" + sortIt.get(i));
		}
		
		System.out.println("compare: " + compare("TEST", "TEST"));
		
		
	}
	
	
	public static int nameSum(String name){
		int sum = 0;
		for(int i = 0; i < name.length(); i++){
			sum += name.charAt(i) - 64;
		}
		
		return sum;
	}
	
	
	
	/*
	 * Algoritm:
	 * Läs in hela textfilen, borde kunna hålla hela i ram då den endast
	 * är på 46kb.
	 * 
	 * Ha den som en ArrayList där varje namn blir en separat add, kör sedan
	 * Collections.sort(theList, String.CASE_INSENSITIVE_ORDER);
	 * 
	 * 
	 * namnen lagras enligt:
	 * "namn1", "namn2", ....
	 * 
	 * 
	 */
	
	/*public static List<String> readFile(String fileName) throws FileNotFoundException{
		List<String> theList = new ArrayList<String>();
		Scanner s = new Scanner(new File(fileName));
		s.useDelimiter("\",\""); // kommer att läsa "mary istället för mary på första
		s.next();
		theList.add("MARY");
		
		while(s.hasNext()){
			theList.add(s.next());
		}
		
		return theList;
	}/**/
	
	public static List<String> readFile(String fileName) throws FileNotFoundException{
		List<String> theList = new ArrayList<String>();
		Scanner s = new Scanner(new File(fileName));
		s.useDelimiter(", *");
		// s.next();
		
		while(s.hasNext()){
			String temp = s.next();
			temp = temp.substring(1, temp.length()-1);
			theList.add(temp);
		}
		return theList;
	}
	
	
	public static List<String> mergeSort(List<String> toBeSorted){
		if(toBeSorted.size() <= 1){
			return toBeSorted;
		}
		
		List<String> sub1, sub2;
//		System.out.println("toBeSorted.size()/2: " + toBeSorted.size()/2 + "\nsize: " + toBeSorted.size());
		
		sub1 = toBeSorted.subList(0, toBeSorted.size()/2);
		sub2 = toBeSorted.subList((toBeSorted.size()/2), toBeSorted.size());
		
		sub1 = mergeSort(sub1);
		sub2 = mergeSort(sub2);
		
//		System.out.print("sub1: ");
//		for(int i = 0; i < sub1.size(); i++){
//			System.out.print(sub1.get(i) + " ");
//		}
//		System.out.print("\nsub2: ");
//		for(int i = 0; i < sub2.size(); i++){
//			System.out.print(sub2.get(i) + " ");
//		}
//		System.out.println();
		
		
		
		return merge(sub1, sub2);
	}
	
	
	/**
	 * Returns the merged list sorted assuming that the two list that get passed as arguments(part1 and part2) is already 
	 * individually sorted
	 * @param part1 one of the parts to be merged
	 * @param part2 one of the parts to be merged
	 * @return part1 + part2 merged together to a single list
	 */
	public static List<String> merge(List<String> part1, List<String> part2){
		List<String> mergedList = new ArrayList<String>(); // TODO: inte den vackraste lösningen kanske...
		
		int part1Index = 0, part2Index = 0;
		
		if(part1.size() == 0) return part2;
		if(part2.size() == 0) return part1;
		
		for(int i = 0; i < part1.size() + part2.size(); i++){
			if(compare(part1.get(part1Index), (part2.get(part2Index)))){ // part1.get(part1Index).compareTo(part2.get(part2Index)) < 0
				mergedList.add(part1.get(part1Index++));
				if(part1Index >= part1.size()){
					// if we have no more elements in part1 just append what is left in part2 to the end of the list
					for(; part2Index < part2.size(); part2Index++){
						mergedList.add(part2.get(part2Index));
					}
					break;
				}
			} else{
				mergedList.add(part2.get(part2Index++));
				if(part2Index >= part2.size()){
					for(; part1Index < part1.size(); part1Index++){
						mergedList.add(part1.get(part1Index));
					}
					break;
				}
			}
		}
		
		return mergedList;
	}
	
	/**
	 * returns true if string1 is alphabetically less than string2
	 * @param string1 the first of the two strings to be compared
	 * @param string2 the second of the two string to be compared
	 * @return true if string1 < string2 alphabetically 
	 * false otherwise
	 */
	public static boolean compare(String string1, String string2){
		for(int i = 0; i < string1.length() && i < string2.length(); i++){
//			System.out.println("comparing: " + string1.charAt(i) + " and " + string2.charAt(i));
			if(string1.charAt(i) == string2.charAt(i)){
				continue;
			} else{
//				System.out.println("returning" + (string1.charAt(i) < string2.charAt(i)));
				return string1.charAt(i) < string2.charAt(i);
			}
		}
		
		return string1.length() < string2.length();
	}

}
