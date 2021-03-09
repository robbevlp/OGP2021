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
	 * @invar | mazemap != null
	 */
	private Square square;
	private int nbLives;
	private MazeMap mazemap;
	
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
<<<<<<< HEAD
	 * @throws | nbLives < 1			 // TODO Throws!
=======
	 * 
	 * @return | result
	 * @post | result == this.getSquare().getMazeMap()
	 */
	public MazeMap getMazeMap() {return mazemap; }
	
	/**
	 * @throws | nbLives < 1
>>>>>>> branch 'master' of https://github.com/robbevlp/OGP2021
	 * @throws | square == null
	 * 
	 * @return | result
	 * @post | getSquare() == square
	 * @post | getNbLives() == nbLives
	 */
	public PacMan(int nbLives, Square square) {
		if (square == null) {throw new IllegalStateException("Square cannot be null."); }
		if (nbLives < 1) {throw new IllegalStateException("New pacman must have health."); }
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
		if(square == null) {throw new IllegalStateException("Square cannot be null."); }
		this.square = square;
		this.mazemap = square.getMazeMap();}
	
	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 * @throws | getNbLives() < 1
	 * 
	 * @mutates | this
	 * @post | getNbLives() == old(getNbLives()) - 1
	 * @post | getSquare() == old(getSquare())
	 */
	public void die() { 
		if (nbLives < 1) {throw new IllegalStateException("Pacman is already dead."); }
		if (nbLives > 1) {
			nbLives --;
		}else {
			throw new RuntimeException("You died."); 
			} 
		}

}
