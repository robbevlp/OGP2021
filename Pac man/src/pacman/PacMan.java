package pacman;

/**
 * Each instance of this class represents the player-controlled Pac-Man character in a Pac-Man maze.
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
	 */
	public Square getSquare() { return square; }
	/**
	 * @basic
	 * @inspects | this
	 */
	public int getNbLives() { return nbLives; }

	/**
	 * @throws | nbLives < 1
	 * @throws | square == null
	 * 
	 * @return | result
	 * @post | this.getSquare() == square
	 * @post | this.getNbLives() == nbLives
	 */
	public PacMan(int nbLives, Square square) {
		this.square = square;
		this.nbLives = nbLives;
	}
	
	/**
	 * @throws | square == null
	 * 
	 * @mutates | this
	 * @post | this.getSquare() == square
	 * @post | getNbLives() == old(getNbLives())
	 */
	public void setSquare(Square square) { 
		this.square = square; }
	
	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 * @throws | this.getNbLives() < 1
	 * 
	 * @mutates | this
	 * @post | getNbLives() == old(getNbLives())
	 * @post | this.getSquare().equals(old(getSquare()))
	 */
	public void die() { 
		if (nbLives > 1) {
			nbLives --;
		}else{
			throw new RuntimeException("You died."); 
			} 
		}

}
