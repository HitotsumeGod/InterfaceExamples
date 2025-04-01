class Point implements Movable {

	private int xCoordinate;
	private int yCoordinate;
	private Point[][] grid;
	
	public Point(int x, int y, Point grid[][]) {
	
		this.xCoordinate = x;
		this.yCoordinate = y;
		this.grid = grid;
		this.grid[xCoordinate][yCoordinate] = this;
	
	}
	
	public int getXCord() {
	
		return this.xCoordinate;
	
	}
	
	public int getYCord() {
	
		return this.yCoordinate;
	
	}
	
	public Point[][] getgrid() {
	
		return this.grid;
	
	}
	
	@Override
	public boolean jump(int x, int y) {
	
		if (grid[x][y] != null)
			return false;
		this.grid[xCoordinate][yCoordinate] = null;
		this.xCoordinate = x;
		this.yCoordinate = y;
		this.grid[xCoordinate][yCoordinate] = this;
		return true;
	
	}
	
	@Override
	public boolean shift(int places, Direction d) {
	
		this.grid[xCoordinate][yCoordinate] = null;
		switch (d) {
		case Direction.UP:
			this.yCoordinate += places;
			break;
		case Direction.DOWN:
			this.yCoordinate -= places;
			break;
		case Direction.LEFT:
			this.xCoordinate -= places;
			break;
		case Direction.RIGHT:
			this.xCoordinate += places;
			break;
		default:
			System.out.println("Please provide a proper direction.");
			return false;
		}
		this.grid[xCoordinate][yCoordinate] = this;
		return true;
	
	}
	
	@Override
	public String toString() {
	
		return "Point at " + this.xCoordinate + "X " + this.yCoordinate + "Y.";
	
	}

}
