package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

import pacman.Square;

public class ArrivalPortal {
	
	Square square;
	private HashSet<Wormhole> wormholes = new HashSet<>();
	
	public Square getSquare() {
		return square;
	}
	
	public Set<Wormhole> getWormholes() {
		return Set.copyOf(wormholes);
	}
	
	public ArrivalPortal(Square square) {
		if (square.isPassable() == false) {throw new IllegalArgumentException("Square must be passabel!");}
		this.square = square;
	}
	
	void addWormhole(Wormhole wormhole) {
		if (wormhole == null) {
			throw new IllegalArgumentException("wormhole is null.");}
		// check of portals in de lijst van portals zit in maze
		this.wormholes.add(wormhole); 
	}

	public boolean checkOrder(ArrivalPortal portal) {
		Square square1 = portal.getSquare();
		Square square0 = this.getSquare();
		
		if (square1.equals(square0)) {throw new IllegalArgumentException("Use two differant portals.");}
		
		if (square1.getRowIndex() < square0.getRowIndex()) {return false;}
		if (square1.getRowIndex() == square0.getRowIndex()) {
			if (square1.getColumnIndex() < square0.getColumnIndex()) { return false;}
		}
		return true;
	}
	
}
