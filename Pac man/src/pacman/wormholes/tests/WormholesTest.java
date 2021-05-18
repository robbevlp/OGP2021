package pacman.wormholes.tests;

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
		
		assertTrue(portalA.getWormholes().contains(hole));
		assertTrue(portalD.getWormholes().contains(hole));
		
		assertEquals(hole.getArrivalPortal(), portalA);
		assertEquals(hole.getDeparturePortal(), portalD);
		
		hole.setDeparturePortal(newPortalD);
		
		assertTrue(portalD.getWormholes().isEmpty());
		assertTrue(newPortalD.getWormholes().contains(hole));
		assertEquals(hole.getDeparturePortal(), newPortalD);
		
		hole.setArrivalPortal(newPortalA);
		
		assertTrue(portalA.getWormholes().isEmpty()); 
		assertTrue(newPortalA.getWormholes().contains(hole));
		assertEquals(hole.getArrivalPortal(), newPortalA);
		
		hole.setArrivalPortal(newPortalA);
		
		assertTrue(newPortalA.getWormholes().contains(hole));
		assertEquals(hole.getArrivalPortal(), newPortalA);
		
		hole.setDeparturePortal(newPortalD);
		assertTrue(newPortalD.getWormholes().contains(hole));
		assertEquals(hole.getDeparturePortal(), newPortalD);
		
		assertTrue(newPortalA.checkOrder(portalA));
		assertTrue(newPortalD.checkOrder(portalD));
		
		
	}

} 
