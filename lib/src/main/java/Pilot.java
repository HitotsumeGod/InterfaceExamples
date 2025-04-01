public class Pilot {

	public static void main(String[] args) {
	
		Point[][] grid = new Point[10][10];
		for (int x = 0; x < 10; x++)
			for (int y = 0; y < 10; y++)
				grid[x][y] = null;
		Point MyPoint = new Point(0, 0, grid);
		MyPoint.jump(5,2);
		System.out.println(MyPoint);
	
	}

}
