package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in a Pac-Man maze.
 * @immutable
 */
public class Dot extends FoodItem{
	/**
	 * @throws | newSquare == null
	 * 
	 * @creates | this
	 * @post | getSquare() == newSquare
	 */
	public Dot(Square newSquare) { 
		if(newSquare == null) {throw new IllegalStateException("Dot square cannot be null."); }
		this.square = newSquare; 
		this.size = 1;
	}
	
	/**
	 * @post | result == 1
	 */
	@Override
	public int getSize() {
		return 1;
	}
	
	
}
