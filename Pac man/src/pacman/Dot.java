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
	 * @post | result != null
	 */
	public Square getSquare() { return square; }  // TODO copy van square, sinds immutable?
	
	/**
	 * @throws | square == null
	 * 
	 * @creates | this
	 * @post | getSquare() == square
	 */
	public Dot(Square square) { 
		if(square == null) {throw new IllegalStateException("Square cannot be null."); }
		this.square = square; }
	
}
