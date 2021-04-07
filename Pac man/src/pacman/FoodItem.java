package pacman;

public abstract class FoodItem {		// Gewijzigd naar public abstract voor documentatie behavioral subtyping methode getSize()
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
	 * @pre | this != null
	 * @pre | getSquare() != null 					// Nodig?
	 * @inspects | this
	 * @post | result == 1 || result == 2
	 */
	public abstract int getSize();					// Verstrenging van de (post-)documentatie in subklassen toegevoegd
	
		//if (this instanceof PowerPellet) {return 2;}
		//else { return 1;}
	
	
}
