package pacman;

import java.util.Random;

/**
 * Each instance of this class represents a ghost in a Pac-Man maze.
 */
public class Ghost {
	/**
	 * @invar | square != null
	 * @invar | direction == Direction.UP || direction == Direction.RIGHT || 
	 * 		  | direction == Direction.DOWN || direction == Direction.LEFT
	 */
	private Square square;
	private Direction direction;
	
	/**
	 * @basic
	 * @inspects | this
	 */
	public Square getSquare() { return square; }
	
	/**
	 * @basic
	 * @inspects | this
	 */
	public Direction getDirection() { return direction; }
	
	/**
	 * @throws | square.isPassable() == false
	 * @throws | direction == null
	 * 
	 * @return | this
	 * @post | this.getSquare() == square
	 * @post | this.getDirection() == direction
	 */
	public Ghost(Square square, Direction direction) { 
		if (square.isPassable() == false) {throw new IllegalStateException("Square must be passable."); }
		if (direction == null) {throw new IllegalStateException("Direction cannot be null."); }
		this.square = square;
		this.direction = direction;
	}
	
	/**
	 * @throws | square.isPassable() == false
	 * @throws | square.getMazeMap().equals(this.getSquare().getMazeMap())
	 * 
	 * @mutates | this
	 * 
	 * @post | this.getSquare() == square
	 */
	public void setSquare(Square square) { 
		if (square.isPassable() == false) {throw new IllegalStateException("Square must be passable."); }
		if(square.getMazeMap().equals(this.getSquare().getMazeMap())){throw new IllegalStateException("Both squares must have same mazemap."); }
		this.square = square; }
	
	/**
	 * @throws | direction == null
	 * 
	 * @mutates | this
	 * @post | this.getDirection() == direction
	 */
	public void setDirection(Direction direction) { 
		if (direction == null) {throw new IllegalStateException("Direction cannot be null."); }
		this.direction = direction;
	}
	
	private static int MOVE_FORWARD_PREFERENCE = 10;
	
	// No formal document required
	public Direction chooseNextMoveDirection(Random random) {
		int moveForwardPreference = getSquare().canMove(getDirection()) ? MOVE_FORWARD_PREFERENCE : 0;
		Direction[] passableDirections = getSquare().getPassableDirectionsExcept(getDirection().getOpposite());
		if (passableDirections.length == 0)
			return getDirection().getOpposite();
		int result = random.nextInt(moveForwardPreference + passableDirections.length);
		if (result < moveForwardPreference)
			return getDirection();
		return passableDirections[result - moveForwardPreference];
	}
	
	// No formal document required
	public void move(Random random) {
		setDirection(chooseNextMoveDirection(random));
		setSquare(getSquare().getNeighbor(getDirection()));
	}
}
