package pacman;

public class FoodItem {
	/**
	 * @invar | square != null
	 */
	protected Square square;
	protected int size;
	
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
		return this.size;
	}
	
}
