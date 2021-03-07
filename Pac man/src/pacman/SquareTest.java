package pacman;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {

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
		
		assert(square.getMazeMap() == mazeMap);
		assert(square.getColumnIndex() == 1);
		assert(square.getRowIndex() == 1);
		assert(square.isPassable() == true);
		
		Direction[] directions = square.getPassableDirectionsExcept(Direction.UP);
		assert(directions[0] == Direction.DOWN);
		assert(directions.length == 1);
		
		Square squareNew = square.getNeighbor(directions[0]);
		
		assert(squareNew.getMazeMap() == mazeMap);
		assert(squareNew.getColumnIndex() == 1);
		assert(squareNew.getRowIndex() == 2);
		assert(squareNew.isPassable() == true);
		
		assert(squareNew.getNeighbor(Direction.RIGHT).isPassable() == false);
		
		Square squareOld = Square.of(mazeMap, 1, 1);
		
		assert(squareOld.getMazeMap() == mazeMap);
		assert(squareOld.getColumnIndex() == 1);
		assert(squareOld.getRowIndex() == 1);
		assert(squareOld.isPassable() == true);
		
		assert(squareOld.equals(square) == true);
		assert(squareOld.equals(squareNew) == false);
		}
	}


