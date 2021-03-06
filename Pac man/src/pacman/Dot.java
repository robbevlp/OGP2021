package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in a Pac-Man maze.
 * @immutable
 */
public class Dot {
	/**
	 * @invar | square != null
	 */
	private Square square;
	
	/**
	 * @basic
	 * @inspects | this
	 */
	public Square getSquare() { return square; }
	
	/**
	 * @throws | square == null
	 * 
	 * @return | this
	 * @post | this.getSquare() == square
	 */
	public Dot(Square square) { this.square = square; }

}
