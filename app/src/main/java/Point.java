import java.util.Arrays;

class Point implements Movable {

	private int xCoordinate;
	private int yCoordinate;
	private Point[][] grid;
	
	public Point(int x, int y, Point grid[][]) {
	
		if (grid[x][y] != null)
			throw new InvalidPointLocationException(grid[x][y]);
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
	public void jump(int x, int y) {
	
		if (grid[x][y] != null)
			throw new InvalidPointLocationException(grid[x][y]);
		grid[xCoordinate][yCoordinate] = null;
		this.xCoordinate = x;
		this.yCoordinate = y;
		grid[xCoordinate][yCoordinate] = this;
	
	}
	
	@Override
	public void shift(int places, Direction d) {
	
		switch (d) {
		case Direction.UP:
			//Check if new location is empty or not
			if (grid[xCoordinate][yCoordinate + places] != null)
				throw new InvalidPointLocationException(grid[xCoordinate][yCoordinate + places]);
			//Remove self from current grid location
			grid[xCoordinate][yCoordinate] = null;
			//Update coordinates in anticipation of new location
			yCoordinate += places;
			break;
		case Direction.DOWN:
			if (grid[xCoordinate][yCoordinate - places] != null)
				throw new InvalidPointLocationException(grid[xCoordinate][yCoordinate - places]);
			grid[xCoordinate][yCoordinate] = null;
			yCoordinate -= places;
			break;
		case Direction.LEFT:
			if (grid[this.xCoordinate - places][yCoordinate] != null)
				throw new InvalidPointLocationException(grid[xCoordinate - places][yCoordinate]);
			grid[xCoordinate][yCoordinate] = null;
			xCoordinate -= places;
			break;
		case Direction.RIGHT:
			if (grid[xCoordinate + places][yCoordinate] != null)
				throw new InvalidPointLocationException(grid[xCoordinate + places][yCoordinate]);
			grid[xCoordinate][yCoordinate] = null;
			xCoordinate += places;
			break;
		default:
			throw new IllegalArgumentException("Received an invalid Direction. Valid options are " + Arrays.toString(Direction.values()) + '.');
		}
		//Insert self into new grid location
		grid[xCoordinate][yCoordinate] = this;
	
	}
	
	@Override
	public String toString() {
	
		return "Point at " + xCoordinate + "X " + yCoordinate + "Y.";
	
	}

}
