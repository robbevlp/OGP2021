package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MazeMapTest {

	@Test
	void test() {
		boolean[] passable = new boolean[4];
		passable[0] = false;
		passable[2] = false;
		passable[1] = true;
		passable[3] = true;
		
		MazeMap mazemap = new MazeMap(2, 2, passable);
		assert(mazemap.getHeight() == 2);
		assert(mazemap.getWidth() == 2);
		assert(mazemap.isPassable(0,0) == false);
		assert(mazemap.isPassable(0,1) == true);
		assert(mazemap.isPassable(1,0) == false);
		assert(mazemap.isPassable(1,1) == true);
	}

}
