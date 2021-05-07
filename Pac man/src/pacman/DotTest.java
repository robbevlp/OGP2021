package pacman;


import org.junit.jupiter.api.Test;

class DotTest {

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
		Square square = mazeMap.of(mazeMap, 1, 1);
		
		Dot dot = new Dot(square);
		assert(dot.getSize() == 1);
		
	}

}
