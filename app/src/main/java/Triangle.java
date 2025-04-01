class Triangle implements Movable {

	private Point[] pts;
	private Point[][] grid;
	
	public Triangle(Point p1, Point p2, Point p3, Point grid[][]) {
	
		this.pts = new Point[3];
		this.pts[0] = p1;
		this.pts[1] = p2;
		this.pts[2] = p3;
		this.grid = grid;
	
	}
	
	@Override
	public void jump(int x, int y) {
	
		if (grid[x][y] != null)
			throw new InvalidPointLocationException(grid[x][y]);
		grid[pts[0].getXCord()][pts[0].getYCord()] = null;
		pts[0] = new Point(x, y, grid);
		//TODO: Complex logic for moving the other points relative to the pilot point
	
	}
	
	@Override
	public void shift(int places, Direction d) {
	
		//Pass shifting responsibility off to individual points
		for (int i = 0; i < 3; i++)
			pts[i].shift(places, d);
		
	}
	
	@Override
	public String toString() {
	
		return "Triangle at points " + pts[0].getXCord() + "X " + pts[0].getYCord() + "Y | " + pts[1].getXCord() + "X " + pts[1].getYCord() + "Y | " + pts[2].getXCord() + "X " + pts[2].getYCord() + "Y.";
	
	}
	
}
