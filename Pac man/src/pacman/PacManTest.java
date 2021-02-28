package pacman;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PacManTest {

	@Test
	void test() {
		PacMan pacman = new PacMan(2, new Square(1,1,false));
		assert(pacman.getSquare() == new Square(1,1,false));
		assert(pacman.getNbLives() == 2);
		pacman.setSquare(new Square(2,1,true));
		assert(pacman.getSquare() == new Square(2,1,true));
		pacman.die();
		assert(pacman.getNbLives() == 1);
	}

}
