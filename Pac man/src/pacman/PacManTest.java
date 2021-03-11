package pacman;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PacManTest {

	@Test
	void test() {
		boolean[] passable = {false, false, false, false ,false, false,
				false, true, false, true, true , false,
				false, true, false, true, true, false,
				false, true, false, true, false, false,
				false, true, true, true, true, false,
				false, false, false, true, false, false,
				false, true, true, true, true, false,
				false, true, false, false, true, false,
				false, true, false, true, true, false,
				false, false, false, false, false, false};
		MazeMap mazeMap = new MazeMap(6, 10, passable);
		Square square = MazeMap.of(mazeMap, 1, 1);
		
		PacMan pacman = new PacMan(3, square);
		assert(pacman.getNbLives() == 3);
		assert(pacman.getSquare().equals(square));
		
		Square squareNew = MazeMap.of(mazeMap, 2, 1);
		pacman.setSquare(squareNew);
		assert(pacman.getSquare() == squareNew);
		assert((pacman.getSquare() == square) == false);
		
		pacman.die();
		assert(pacman.getNbLives() == 2);
		assert((pacman.getNbLives() == 3) == false);
		//pacman.die();
		//assertThrows(RuntimeException.class, () -> pacman.die());
	}

}
