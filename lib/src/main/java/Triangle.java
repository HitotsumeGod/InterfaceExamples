class Triangle implements Movable {

	private Point[] pts;
	private Point[][] grid;
	
	public Triangle(Point p1, Point p2, Point p3, Point grid[][]) {
	
		this.pts = new Point[3];
		this.pts[0] = p1;
		this.pts[1] = p2;
		this.pts[2] = p3;
		this.grid = grid;
		for (int i = 0; i < 3; i++) 
			this.grid[pts[i].getXCord()][pts[i].getYCord()] = pts[i];
	
	}
	
	@Override
	public boolean jump(int x, int y) {
	
		if (this.grid[x][y] != null)
			return false;
		this.grid[pts[0].getXCord()][pts[0].getYCord()] = null;
		pts[0] = new Point(x, y, this.grid);
		//TODO: Complex logic for moving the other points relative to the pilot point
		return true;
	
	}
	
	@Override
	public boolean shift(int places, Direction d) {
	
		for (int i = 0; i < 3; i++)
			this.grid[pts[i].getXCord()][pts[i].getYCord()] = null;
		switch (d) {
		case Direction.UP:
			for (int i = 0; i < 3; i++) 
				pts[i] = new Point(pts[i].getXCord(), pts[i].getYCord() + places, this.grid);
			break;
		case Direction.DOWN:
			for (int i = 0; i < 3; i++) 
				pts[i] = new Point(pts[i].getXCord(), pts[i].getYCord() - places, this.grid);
			break;
		case Direction.LEFT:
			for (int i = 0; i < 3; i++) 
				pts[i] = new Point(pts[i].getXCord() - places, pts[i].getYCord(), this.grid);
			break;
		case Direction.RIGHT:
			for (int i = 0; i < 3; i++) 
				pts[i] = new Point(pts[i].getXCord() + places, pts[i].getYCord(), this.grid);
			break;
		default:
			System.out.println("Please provide a proper direction.");
			return false;
		}
		for (int i = 0; i < 3; i++)
			this.grid[pts[i].getXCord()][pts[i].getYCord()] = pts[i];
		return true;
	}
	
}
