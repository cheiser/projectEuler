
public class LatticePaths {
	
	/** KOM IH�G MAN KAN ENDAST G� NER�T OCH �T H�GER
	 * Skapa en boolean array och l�t 1 indikera att det inte g�r ett streck igenom den och l�t 0 indikera att
	 * det g�r ett streck igenom den och kolla sedan s� det g�r ifr�n start till slut(detta inneb�r att man f�r
	 * kolla p� b�de platsen(sistY, sistX) och (sistY-1, sistX).
	 * 
	 * F�r att kolla s� att "strecket" �r ihopkopplat s� kollar man helt enkelt "cellen" p� platsen direkt
	 * nedanf�r eller direkt till h�ger om en sj�lv �r "streck" eller "slutet", �r den inte det s� �r det inte
	 * ihopkopplat och man kan sluta
	 * 
	 * 
	 * L�ttast blir nog att g�ra en "s�kning" och helt enkelt b�rja med att g� s� l�ngt till h�ger som g�r och 
	 * efter det g� ner�t tills det inte g�r l�ngre och d� g�r man tillbaka och n�r man provat alla som g�r �r
	 * det �ver och d� presenterar man bara summan av hur m�nga g�nger det inte g�r l�ngre
	 */
	
	private static int gridSize = 20;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberOfLines(20));
//		System.out.println(searchGrid(0, 0));
		System.out.println(dynamicProgrammingSolveGrid(gridSize));
	}
	
	/*
	 * returns the number of "lines" in the grid at the specified position in the succession(eg at position 1 it
	 * is simply a square and therefor there is 4 lines)
	 */
	public static int numberOfLines(int inSuccession){
		if(inSuccession == 1){
			return 4;
		} else if(inSuccession == 2){
			return 12;
		} else{
			return numberOfLines(inSuccession-1) + (numberOfLines(inSuccession-1) -
					numberOfLines(inSuccession-2) + 4);
		}
	}
	
	/*
	 * Beh�ver inte ens ha en array, kan helt enkelt ta och kolla om det inte g�r att g� l�ngre p� positionX
	 * och positionY(allts� st�rre �n 20) och om dem �r det s� returnera en variabel som inneh�ller 1 + det man
	 * f�tt fram av andra s�kningar vilket kommer vara 0 p� botten niv�n, allts� 1 + 0 = 1
	 */
	/**
	 * ALGORITM: b�rja p� position (0, 0) och kolla om det g�r att g� till h�ger och om det g�r s� g�r det
	 * 	och addera resultatet fr�n det med det resultatet som ligger sparat sedan tidigare
	 * om det inte g�r att g� till h�ger s� prova att g� ner�t och g�r det s� g�r det och addera resultatet fr�n
	 * 	det med det resultatet som ligger sparat sedan tidigare
	 * om det inte g�r att g� ner�t eller �t h�ger s� returnera 1 d� vi n�tt positionen l�ngst ner till h�ger
	 * 	i "griden"
	 * @param positionX simply set this to 0 as this is the x coordinate of the starting position
	 * @param positionY simply set this to 0 as this is the y coordinate of the starting position
	 * @return the number of routes one can take from by simply moving either to the right or down
	 */
	public static int searchGrid(int positionX, int positionY){
		int currentMaxed = 0;
		
		if(positionY >= gridSize && positionX >= gridSize){
			return 1;
		}
		
		// kolla �t h�ger och addera till currentMaxed
		if(positionX < gridSize){
			currentMaxed += searchGrid(positionX+1, positionY);
		}
		// kolla ner�t och addera till currentMaxed
		if(positionY < gridSize){
			currentMaxed += searchGrid(positionX, positionY+1);
		}
		
		return currentMaxed;
	}
	
	private static long dynamicProgrammingSolveGrid(int gridSize){
		// we have a gridSize*gridSize grid but gridSize+1*gridSize+1 gridpoints(edges on the squares)
		long[][] gridPoints = new long[gridSize+1][gridSize+1]; 
		
		// initialize the grid and set the boundaries to 1
		for(int i = 0; i < gridSize; i++){
			gridPoints[i][gridSize] = 1;
			gridPoints[gridSize][i] = 1;
		}
		
		for(int i = gridSize - 1; i >= 0; i--){
			for(int j = gridSize - 1; j >= 0; j--){
				gridPoints[i][j] = gridPoints[i+1][j] + gridPoints[i][j+1];
			}
		}
		
		return gridPoints[0][0];
	}

}
