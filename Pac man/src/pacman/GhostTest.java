package pacman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GhostTest {

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
		MazeMap mazemap1 = new MazeMap(6, 10, passable);
		Square squareghost1 = new Square(2,3,true,mazemap1); //Recheck 
		Square squareghost2 = new Square(1, 1, true, mazemap1);
		
		Ghost ghost1 = new Ghost(squareghost1, Direction.DOWN);
		
		assertEquals(ghost1.getDirection(), Direction.DOWN);
		assertEquals(ghost1.getSquare(), squareghost1);
		
		Ghost ghost2 = new Ghost(squareghost2, Direction.DOWN);
		
		assertEquals(ghost2.getDirection(), Direction.DOWN);
		assertEquals(ghost2.getSquare(), squareghost2);
		
		ghost1.setDirection(Direction.RIGHT); // UP en DOWN ook ?
		assertEquals(ghost1.getDirection(), Direction.RIGHT);
		
		
		ghost1.setSquare(squareghost2);
		assertEquals(ghost1.getSquare(), ghost2.getSquare());
		// Direction ghost 1 niet meer mogelijk op die square -- check
		
		
		
	}

}
