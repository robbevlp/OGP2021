package pacman;

import java.util.Random;

public class VulnerableGhostState extends GhostState{

	private int moveDelay;
	
	public GhostState move(Ghost ghost, Random random) {
		if (moveDelay % 2 == 0) {ghost.reallyMove(random);}
		moveDelay ++;
		
		if (moveDelay == 13) {
			return new RegularGhostState();
		}
		
		return this;
	}
	
	public VulnerableGhostState(int number) {
		moveDelay = number;
	}
	
	public GhostState hitBy(Ghost ghost, PacMan pacMan) {
		ghost.setSquare(ghost.originalSquare);
		return new RegularGhostState();
	}
	
}
