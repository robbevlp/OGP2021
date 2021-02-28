package pacman;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {

	@Test
	void test() {
		Square square = new Square(1,1,false);
		
		assert(square.getRowIndex() == 1);
		assert(square.getColumnIndex() == 1);
		assert(square.isPassable() == false);
	}

}
