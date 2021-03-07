package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MazeMapTest {

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
		
		assert(mazeMap.getWidth() == 6);
		assert(mazeMap.getHeight() == 10);
		assert((mazeMap.getWidth() == 10) == false);
		assert(mazeMap.isPassable(5, 5) == false);
		assert(mazeMap.isPassable(5, 3) == true);
		
		boolean[] passableNew = {true, false, false, false ,false, false,
				false, true, false, true, true , false,
				false, true, false, true, true, false,
				false, true, false, true, false, false,
				false, true, true, true, true, false,
				false, false, false, true, false, false,
				false, true, true, true, true, false,
				false, true, false, false, true, false,
				false, true, false, true, true, false,
				false, false, false, false, false, false};
		
		MazeMap fakeMazeMap = new MazeMap(6,10,passableNew);
		
		assert(mazeMap.equals(fakeMazeMap) == false);
		assert(fakeMazeMap.isPassable(0, 0) == true);
		
		MazeMap newMazeMap = new MazeMap(6,10,passable);
		assert(mazeMap.equals(newMazeMap)==true);
		
		
	}

}
