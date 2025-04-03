class Triangle implements Movable {

	private Point[] pts;
	private Point[][] graph;
	
	public Triangle(Point p1, Point p2, Point p3, Point graph[][]) {
	
		this.pts = new Point[3];
		this.pts[0] = p1;
		this.pts[1] = p2;
		this.pts[2] = p3;
		this.graph = graph;
	
	}
	
	@Override
	public void jump(int x, int y) {
	
		int[] distanceJumped = new int[] { x - pts[0].getXCord(), y - pts[0].getYCord() };
		pts[0].jump(x, y);
		pts[1].jump(pts[1].getXCord() + distanceJumped[0], pts[1].getYCord() + distanceJumped[1]);
		pts[2].jump(pts[2].getXCord() + distanceJumped[0], pts[2].getYCord() + distanceJumped[1]);

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
