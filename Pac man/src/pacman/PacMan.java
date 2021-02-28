package pacman;

/**
 * Each instance of this class represents the player-controlled Pac-Man character in a Pac-Man maze.
 */
public class PacMan {
	private Square square;
	private int nbLives;
	
	public Square getSquare() { return square; }
	
	public int getNbLives() { int result = nbLives; return result; }

	public PacMan(int nbLives, Square square) {
		this.square = square;
		this.nbLives = nbLives;
	}
	
	public void setSquare(Square square) { 
		this.square = square; }
	
	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 */
	public void die() { 
		if (nbLives > 1) {
			nbLives -= 1;
		}else{
			throw new RuntimeException("Not yet implemented"); 
			} 
		}

}
