import java.util.Arrays;

class Point implements Movable {

	private int xCoordinate;
	private int yCoordinate;
	private Point[][] graph;
	private Quadrant q;
	
	public Point(int x, int y, Point graph[][]) {
	
		if (graph[x][y] != null)
			throw new InvalidPointLocationException(graph[x][y]);
		this.q = assignQuadrant(x, y);
		this.xCoordinate = x;
		this.yCoordinate = y;
		this.graph = graph;
		this.graph[xCoordinate][yCoordinate] = this;
	
	}
	
	private Quadrant assignQuadrant(int x, int y) {
		
		if (x > 0 && y > 0)
			return Quadrant.Q1;
		else if (x < 0 && y > 0)
			return Quadrant.Q2;
		else if (x < 0 && y < 0)
			return Quadrant.Q3;
		else if (x > 0 && y < 0)
			return Quadrant.Q4;
		else if (x == 0 && y == 0)
			return Quadrant.ORIGIN;
		else if (x != 0 && y == 0)
			return Quadrant.Y_AXIS;
		else if (x == 0 && y != 0)
			return Quadrant.X_AXIS;
		return null;
		
	}
	
	public int getXCord() {
	
		return this.xCoordinate;
	
	}
	
	public int getYCord() {
	
		return this.yCoordinate;
	
	}
	
	public Point[][] getgraph() {
	
		return this.graph;
	
	}
	
	public Quadrant getQuadrant() {
		
		return this.q;
		
	}
	
	@Override
	public void jump(int x, int y) {
	
		if (graph[x][y] != null)
			throw new InvalidPointLocationException(graph[x][y]);
		graph[xCoordinate][yCoordinate] = null;
		this.xCoordinate = x;
		this.yCoordinate = y;
		graph[xCoordinate][yCoordinate] = this;
	
	}
	
	@Override
	public void shift(int places, Direction d) {
	
		switch (d) {
		case Direction.UP:
			//Check if new location is empty or not
			if (graph[xCoordinate][yCoordinate + places] != null)
				throw new InvalidPointLocationException(graph[xCoordinate][yCoordinate + places]);
			//Remove self from current graph location
			graph[xCoordinate][yCoordinate] = null;
			//Update coordinates in anticipation of new location
			yCoordinate += places;
			break;
		case Direction.DOWN:
			if (graph[xCoordinate][yCoordinate - places] != null)
				throw new InvalidPointLocationException(graph[xCoordinate][yCoordinate - places]);
			graph[xCoordinate][yCoordinate] = null;
			yCoordinate -= places;
			break;
		case Direction.LEFT:
			if (graph[this.xCoordinate - places][yCoordinate] != null)
				throw new InvalidPointLocationException(graph[xCoordinate - places][yCoordinate]);
			graph[xCoordinate][yCoordinate] = null;
			xCoordinate -= places;
			break;
		case Direction.RIGHT:
			if (graph[xCoordinate + places][yCoordinate] != null)
				throw new InvalidPointLocationException(graph[xCoordinate + places][yCoordinate]);
			graph[xCoordinate][yCoordinate] = null;
			xCoordinate += places;
			break;
		default:
			throw new IllegalArgumentException("Received an invalid Direction. Valid options are " + Arrays.toString(Direction.values()) + '.');
		}
		//Insert self into new graph location
		graph[xCoordinate][yCoordinate] = this;
	
	}
	
	@Override
	public String toString() {
	
		return "Point at " + xCoordinate + "X " + yCoordinate + "Y.";
	
	}

}
