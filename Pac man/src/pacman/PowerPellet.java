package pacman;

public class PowerPellet extends FoodItem{

	/**
	 * @basic
	 * @inspects | this
	 * @post | result != null
	 */
	@Override
	public Square getSquare() {	// TODO:  Nodig? -- Reeds in FoodItem.java
		return square;
	}
	
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
	 * @post | result == 2
	 */
	@Override
	public int getSize() {
		return 2;
	}
	
	
}
