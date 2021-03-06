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
		this.size = 2;
	}

	/**
	 * @post | result == 2
	 */
	@Override
	public int getSize() {
		return 2;
	}

}
