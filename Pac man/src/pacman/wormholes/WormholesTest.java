package pacman.wormholes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.MazeMap;
import pacman.Square;

class WormholesTest {

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
		
		Square square0 = new Square(3, 3, true, mazeMap);
		Square square1 = new Square(2, 3, true, mazeMap);
		Square square2 = new Square(1, 1, true, mazeMap);
		
//		ArrivalPortal portalA = new ArrivalPortal(square0);
//		DeparturePortal portalD = new DeparturePortal(square1);
//		DeparturePortal newPortalD = new DeparturePortal(square2);
//		
//		Wormhole hole = new Wormhole(portalD, portalA);
//		
//		assert(portalA.getWormholes().contains(hole) == true);
//		assert(portalD.getWormholes().contains(hole) == true);
//		
//		assert(hole.getArrivalPortal() == portalA);
//		assert(hole.getDeparturePortal() == portalD);
//		
//		hole.setDeparturePortal(newPortalD);
//		
//		assert(portalD.getWormholes().isEmpty() == true);
//		assert(newPortalD.getWormholes().contains(hole) == true);
//		assert(hole.getDeparturePortal() == newPortalD);
//		
		ArrivalPortal[] newArrivalPortals = {new ArrivalPortal(square2), new ArrivalPortal(square1), new ArrivalPortal(square0)};
		
		for(int j = 0 ; j <= newArrivalPortals.length - 2; j++) {
			assert(newArrivalPortals[j].checkOrder(newArrivalPortals[j+1]));
			System.out.print("1");
		}
	}

} 
