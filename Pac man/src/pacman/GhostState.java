package pacman;

import java.util.Random;

public abstract class GhostState {
	abstract GhostState move(Ghost ghost, Random random);
	
	abstract GhostState hitBy(Ghost ghost, PacMan pacMan);
	
}

