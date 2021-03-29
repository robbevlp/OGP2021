package pacman;

public class FoodItem {
	/**
	 * @invar | square != null
	 */
	protected Square square;
	
	/**
	 * @basic
	 * @inspects | this
	 * @post | result != null
	 */
	public Square getSquare() { return square; }  
	
	/**
	 * @inspects | this
	 * @post | result == 1 || result == 2
	 */
	public int getSize() {
		if (this instanceof PowerPellet) {return 2;}
		else { return 1;}
	}
	
}
