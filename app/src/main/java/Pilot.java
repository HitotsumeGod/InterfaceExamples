public class Pilot {

	public static void main(String[] args) {
	
		int GRAPHSIZE = 10;
		Point[][] graph = new Point[GRAPHSIZE][GRAPHSIZE];
		for (int x = 0; x < GRAPHSIZE; x++)
			for (int y = 0; y < GRAPHSIZE; y++)
				graph[x][y] = null;
		Triangle myAngle = new Triangle(new Point(-5, 2, graph), new Point(1, 1, graph), new Point(3, 3, graph), graph);
		myAngle.jump(6, 6);
		System.out.println(myAngle);
			
		
	}

}
