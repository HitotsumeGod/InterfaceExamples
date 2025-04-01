/*
A basic example of a Java interface: a 'contract' that enforces interoperability between distinct or unrelated systems.
This interface is designed to be implemented by classes that produce objects that should be able to move around on a grid; when implemented,
this interface provides them the blueprints to said functionality.
It is up to the class to construct the specific implementations of each method, according to their specific desire. 
For example: a Point's jump method will not do the same thing as a Triangle's, since the Point will only need to move itself, and the Triangle will need
to move all three of its Points. HOWEVER, both jump methods are inherited from this interface, and so share a common blueprint.
*/

public interface Movable {

	//Move the object to an arbitrary location on a grid, providing an x and y coordinate
	void jump(int x, int y);	
	
	//Shift the object a certain number of points on the grid, given said points and a direction d (see enum type below)
	void shift(int places, Direction d);

}

enum Direction { UP, DOWN, LEFT, RIGHT }
