package pacman;

/**
 * Each instance of this class represents the player-controlled Pac-Man character in a Pac-Man maze.
 * 
 * @mutable
 */
public class PacMan {
	/**
	 * @invar | square != null
	 * @invar | nbLives >= 0
	 */
	private Square square;
	private int nbLives;
	
	/**
	 * @basic
	 * @inspects | this
	 * @post | result != null
	 */
	public Square getSquare() { return square; }
	/**
	 * @basic
	 * @inspects | this
	 * @post | result >= 0
	 */
	public int getNbLives() { return nbLives; }

	/**
	 * @throws | nbLives < 1			 // TODO Throws!
	 * @throws | square == null
	 * 
	 * @return | result
	 * @post | getSquare() == square
	 * @post | getNbLives() == nbLives
	 */
	public PacMan(int nbLives, Square square) {
		this.square = square;
		this.nbLives = nbLives;
	}
	
	/**
	 * @throws | square == null
	 * 
	 * @mutates | this
	 * @post | getSquare() == square
	 * @post | getNbLives() == old(getNbLives())
	 */
	public void setSquare(Square square) { 
		this.square = square; }
	
	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 * @throws | getNbLives() < 1
	 * 
	 * @mutates | this
	 * @post | getNbLives() == old(getNbLives()) - 1
	 * @post | getSquare() == old(getSquare())
	 */
	public void die() { 
		if (nbLives > 1) {
			nbLives --;
		}else {
			throw new RuntimeException("You died."); 
			} 
		}

}
