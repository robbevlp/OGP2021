package wormholes.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.MazeMap;
import pacman.Square;
import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Wormhole;

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
		Square square3 = new Square(1, 3, true, mazeMap);
		
		ArrivalPortal portalA = new ArrivalPortal(square0);
		ArrivalPortal newPortalA = new ArrivalPortal(square3);
		DeparturePortal portalD = new DeparturePortal(square1);
		DeparturePortal newPortalD = new DeparturePortal(square2);
		
		Wormhole hole = new Wormhole(portalD, portalA);
		
		assert(portalA.getWormholes().contains(hole) == true);
		assert(portalD.getWormholes().contains(hole) == true);
		
		assert(hole.getArrivalPortal() == portalA);
		assert(hole.getDeparturePortal() == portalD);
		
		hole.setDeparturePortal(newPortalD);
		
		assert(portalD.getWormholes().isEmpty() == true);
		assert(newPortalD.getWormholes().contains(hole) == true);
		assert(hole.getDeparturePortal() == newPortalD);
		
		hole.setArrivalPortal(newPortalA);
		
		assert(portalA.getWormholes().isEmpty() == true);
		assert(newPortalA.getWormholes().contains(hole));
		assert(hole.getArrivalPortal() == newPortalA);
		
		hole.setArrivalPortal(newPortalA);
		
		assert(newPortalA.getWormholes().contains(hole));
		assert(hole.getArrivalPortal() == newPortalA);
		
		hole.setDeparturePortal(newPortalD);
		assert(newPortalD.getWormholes().contains(hole) == true);
		assert(hole.getDeparturePortal() == newPortalD);
		
		
	}

} 
