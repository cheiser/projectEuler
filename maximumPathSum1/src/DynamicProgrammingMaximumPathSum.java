import java.io.IOException;


public class DynamicProgrammingMaximumPathSum {
	
	/**
	 * en m�jlig algoritm:
	 * Man b�rjar ifr�n botten och g�r upp�t och sparar f�r varje "nummer" ovanf�r sin siffra och den siffran
	 * under som har h�gst v�rde. Detta b�r resultera i att resultatet kommer st� p� platsen l�ngst upp.
	 * 
	 * Jag borde kunna spara den som den ser ut i en array allts� den �versta hamnar p� (0, 0) dem tv� n�sta p�
	 * (1, 0) och (1, 1). Sedan n�r ja b�rjar nerifr�n s� tar jag en rad �t g�ngen och b�rjar p� den n�st sista
	 * och kollar helt enkelt p� numret som st�r rakt under den p� den positionen man �r p�(l�t s�ga vi �r p�
	 * (4, 5)) d� kollar man bara (5, 5) och den till h�ger om den, allts� (5, 6) och s� v�ljer man den st�rsta
	 * och adderar till det numret som st�r p� den positionen man �r p� och uppdaterar med det, sedan n�r man �r
	 * f�rdig med den raden man �r p� s� g�r man bara upp en rad och upprepar, detta g�r man tills man n�r
	 * sista(�versta) raden och n�r man gjort den s� st�r resultatet �verst d�r
	 */
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String[] grid = FileManager.readFileAsStrings("C:\\Users\\Mattis\\workspace\\projectEuler\\" +
				"maximumPathSum1\\src\\triangle.txt");
		int[][] gridMatrix = convertStringArrayToIntMatrix(grid, 100);
		printMatrix(gridMatrix);
		
		System.out.println(calculateMaximumPathSum(gridMatrix));
	}
	
	
	public static int calculateMaximumPathSum(int[][] triangle){
		int sum = 0;
		
		for(int j = triangle.length-2; j >= 0; j--){
			int i = 0;
			while(triangle[j][i] != -1){
				// choose the largest of the two adjacent numbers on the row below one is at and add to itself
				triangle[j][i] += (triangle[j+1][i] > triangle[j+1][i+1])?triangle[j+1][i] : triangle[j+1][i+1];
				i++; // then move on to the next number and do the same
			}
			// then move up one row and repeat
		}
		
		sum = triangle[0][0];
		
		return sum;
	}
	
	
	
	
	
	/**
	 * converts an string array to an int matrix, assumes that the rows shape an triangle
	 * @param array
	 * @return
	 */
	public static int[][] convertStringArrayToIntMatrix(String[] array, int rowLength){
		int[][] matrix = new int[array.length][rowLength];
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				matrix[i][j] = -1;
			}
		}
		
		for(int i = 0; i < array.length; i++){
			String[] splitted = array[i].split(" ");
			for(int j = 0; j < i+1; j++){
				matrix[i][j] = Integer.parseInt(splitted[j]);
			}
		}
		
		return matrix;
	}
	
	
	public static void printMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
