
public class LatticePaths {
	
	/** KOM IHÅG MAN KAN ENDAST GÅ NERÅT OCH ÅT HÖGER
	 * Skapa en boolean array och låt 1 indikera att det inte går ett streck igenom den och låt 0 indikera att
	 * det går ett streck igenom den och kolla sedan så det går ifrån start till slut(detta innebär att man får
	 * kolla på både platsen(sistY, sistX) och (sistY-1, sistX).
	 * 
	 * För att kolla så att "strecket" är ihopkopplat så kollar man helt enkelt "cellen" på platsen direkt
	 * nedanför eller direkt till höger om en själv är "streck" eller "slutet", är den inte det så är det inte
	 * ihopkopplat och man kan sluta
	 * 
	 * 
	 * Lättast blir nog att göra en "sökning" och helt enkelt börja med att gå så långt till höger som går och 
	 * efter det gå neråt tills det inte går längre och då går man tillbaka och när man provat alla som går är
	 * det över och då presenterar man bara summan av hur många gånger det inte går längre
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
	 * Behöver inte ens ha en array, kan helt enkelt ta och kolla om det inte går att gå längre på positionX
	 * och positionY(alltså större än 20) och om dem är det så returnera en variabel som innehåller 1 + det man
	 * fått fram av andra sökningar vilket kommer vara 0 på botten nivån, alltså 1 + 0 = 1
	 */
	/**
	 * ALGORITM: börja på position (0, 0) och kolla om det går att gå till höger och om det går så gör det
	 * 	och addera resultatet från det med det resultatet som ligger sparat sedan tidigare
	 * om det inte går att gå till höger så prova att gå neråt och går det så gör det och addera resultatet från
	 * 	det med det resultatet som ligger sparat sedan tidigare
	 * om det inte går att gå neråt eller åt höger så returnera 1 då vi nått positionen längst ner till höger
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
		
		// kolla åt höger och addera till currentMaxed
		if(positionX < gridSize){
			currentMaxed += searchGrid(positionX+1, positionY);
		}
		// kolla neråt och addera till currentMaxed
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
