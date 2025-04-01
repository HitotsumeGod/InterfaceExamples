public class InvalidPointLocationException extends RuntimeException {

	public InvalidPointLocationException(Point p) {
	
		/*if (p != null)
			super("Invalid location for point assignment : point is not null.");*/
		super("Invalid location for point assignment.");
	
	}

}
