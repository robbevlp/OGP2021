package pacman;

public abstract class FoodItem {
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
	 * @basic
	 * @inspects | this
	 * @post | result == 1 || result == 2
	 */
	public abstract int getSize();
	
	
	
}
