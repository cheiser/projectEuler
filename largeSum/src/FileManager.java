import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FileManager {
	
	public static String readFileAsString(String fileName) throws IOException{
		return readFileAsString(fileName, "\n");
	}
	
	public static String readFileAsString(String fileName, String appendPostfix) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String allLines;
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(appendPostfix);
	            line = br.readLine();
	        }
	        allLines = sb.toString();
	    } finally {
	        br.close();
	    }
	    
	    return allLines;
	}
	
	
	public static String[] readFileAsStrings(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		ArrayList<String> allLines = new ArrayList<String>();
		String[] allLinesStrings;
	    try {
	        String line = br.readLine();

	        while (line != null) {
	            allLines.add(line);
	            line = br.readLine();
	        }
	    } finally {
	        br.close();
	    }
	    
	    allLinesStrings = new String[allLines.size()];
	    allLines.toArray(allLinesStrings);
	    return allLinesStrings;
	}
}
