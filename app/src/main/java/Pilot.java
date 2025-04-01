public class Pilot {

	public static void main(String[] args) {
	
		int GRIDSIZE = Integer.valueOf(args[0]);
		Point[][] grid = new Point[GRIDSIZE][GRIDSIZE];
		for (int x = 0; x < GRIDSIZE; x++)
			for (int y = 0; y < GRIDSIZE; y++)
				grid[x][y] = null;
		Triangle myAngle = new Triangle(new Point(5, 9, grid), new Point(3, 2, grid), new Point(6, 2, grid), grid);
		myAngle.shift(5, Direction.UP);
		for (int x = 0; x < GRIDSIZE; x++)
			for (int y = 0; y < GRIDSIZE; y++)
				System.out.print(" " + grid[x][y]);
		System.out.println();
			
		
	}

}
