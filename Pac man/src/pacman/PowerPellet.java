package pacman;

public class PowerPellet extends FoodItem{

	
	/**
	 * @throws | newSquare == null
	 * 
	 * @creates | this
	 * @post | getSquare() == newSquare
	 */
	public PowerPellet(Square newSquare) {
		if(newSquare == null) {throw new IllegalStateException("PowerPellet square cannot be null."); }
		this.square = newSquare;
	}
	
	/**
	 * @basic
	 * @inspects | this
	 * @post | result != null
	 */
	public Square getSquare() {
		return square;
	}
}
