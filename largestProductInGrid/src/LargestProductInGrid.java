import java.io.IOException;


public class LargestProductInGrid {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		System.out.println(FileManager.readFileAsStrings("C:\\Users\\Mattis\\workspace\\projectEuler\\" +
//		"largestProductInGrid\\src\\test.txt"));
//		printStrings(FileManager.readFileAsStrings("C:\\Users\\Mattis\\workspace\\projectEuler\\" +
//		"largestProductInGrid\\src\\test.txt"));
		
		String[] grid = FileManager.readFileAsStrings("C:\\Users\\Mattis\\workspace\\projectEuler\\" +
				"largestProductInGrid\\src\\test.txt");
		int[][] gridMatrix = convertStringArrayToIntMatrix(grid, 20);
		
		System.out.println(largestProductInGrid(gridMatrix));
		
	}
	
	
	public static long largestProductInGrid(int[][] grid){
		long product = 1, tempProduct = 1;;
		int gridLength = grid.length;
		
		
		
		
		// left to right
		for(int row = 0; row < grid.length; row++){
			for(int i = 0; i < gridLength; i++){
				for(int j = i; j < 4 && j < gridLength; j++){
					tempProduct *= grid[row][i+j];
				}
				if(tempProduct > product){
					product = tempProduct;
				}
				tempProduct = 1;
			}
		}
		
		// up to down
		for(int i = 0; i < gridLength; i++){
			for(int row = 0; row < grid.length; row++){
				for(int j = row; j < 4 && j < gridLength; j++){
					tempProduct *= grid[row+j][i];
				}
				if(tempProduct > product){
					product = tempProduct;
				}
				tempProduct = 1;
			}
		}
		
		tempProduct = 1;
		
		// diagonally upper left to lower right
		for(int c = 0; c < gridLength; c++){
			for(int r = 0; r < grid.length; r++){
				for(int i = 0; i < 4 && c+i < gridLength && r+i < grid.length; i++){
					try{
						tempProduct *= grid[c+i][r+i];
					} catch(ArrayIndexOutOfBoundsException ex){
						System.out.println("exception with i = " + i + " c = " + c + " r = " + r);
					}
				}
				
				if(tempProduct > product){
					product = tempProduct;
				}
				
//				System.out.println("tempProduct: " + tempProduct);
				if(tempProduct == 1788696){
					System.out.println("found number at " + c + ":" + r);
				}
				if(tempProduct == 279496){
					System.out.println("found number at " + c + ":" + r);
				}
				tempProduct = 1;
			}
		}
		
		
		System.out.println("gridLength " + gridLength + " grid.length " + grid.length);
		
		// diagonally lower left to upper right
		for(int c = 0; c < gridLength; c++){
			for(int r = 0; r < grid.length; r++){
				for(int i = 0; i < 4 && c+i < gridLength && r-i > 0; i++){
					try{
						tempProduct *= grid[c+i][r-i];
					} catch(ArrayIndexOutOfBoundsException ex){
						System.out.println("exception with i = " + i + " c = " + c + " r = " + r);
					}
				}
				
				if(tempProduct > product){
					product = tempProduct;
				}
				
//				System.out.println("tempProduct: " + tempProduct);
				if(tempProduct == 1788696){
					System.out.println("found number at " + c + ":" + r);
				}
				if(tempProduct == 279496){
					System.out.println("found number at " + c + ":" + r);
				}
				tempProduct = 1;
			}
		}
		
		return product;
	}
	
	
	public static void printStrings(String[] strings){
		for(int i = 0; i < strings.length; i++){
			System.out.println(strings[i]);
		}
	}
	
	/**
	 * converts an string array to an int matrix, assumes that all the rows in the array are the same size
	 * @param array
	 * @return
	 */
	public static int[][] convertStringArrayToIntMatrix(String[] array, int rowLength){
		int[][] matrix = new int[array.length][rowLength];
		
		for(int i = 0; i < array.length; i++){
			String[] splitted = array[i].split(" ");
			for(int j = 0; j < rowLength; j++){
				matrix[i][j] = Integer.parseInt(splitted[j]);
			}
		}
		
		return matrix;
	}

}
