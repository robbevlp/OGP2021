package pacman.wormholes;
import java.util.HashSet;
import java.util.Set;

import pacman.Square;

/**
 * Elke instantie van deze klasse representeert een vertrekportaal in een wormhole-graaf.
 * @invar | getSquare() != null
 * @invar | getWormholes() != null
 * @invar | getWormholes().stream().allMatch(w -> w != null)  // && w.getDeparturePortal() == this)
 *
 */
public class DeparturePortal {
	
	/**
	 * @invar | square != null
	 */
	Square square;		// package-accessible (niet public)
	/**
	 *@invar | wormholes != null 
	 *@invar | wormholes.stream().allMatch(w -> w != null) // && w.departureportal() == this)
	 *
	 *@representationObject
	 *@peerObjects
	 */
	private HashSet<Wormhole> wormholes = new HashSet<>();	
	
	
	/**
	 * @basic
	 */
	public Square getSquare() {
		return square;
	}
	
	/**
	 * @basic
	 * @peerObjects
	 * @creates | result
	 * @post | result != null
	 */
	public Set<Wormhole> getWormholes() {
		return Set.copyOf(wormholes);
	}
	
	/**
	 * @throws | square.isPassable() == false
	 * @creates | this
	 * @post | getWormholes().isEmpty()
	 * @post | square != null 
	 */
	public DeparturePortal(Square square) {
		if (square.isPassable() == false) {
			throw new IllegalStateException("Square must be passable."); }
		this.square = square;
		
	}
	
	
	/**
	 * @throws IllegalArgumentException | wormhole == null
	 * @mutates_porperties | getWormholes()
	 * @post | getWormholes().stream().allMatch(w -> w != null)
	 * 
	 */
	void addWormhole(Wormhole wormhole) {
		if (wormhole == null) {
			throw new IllegalArgumentException("wormhole is null");}
		// check of portals in de lijst van portals zit in maze
		this.wormholes.add(wormhole); 
	}
	
	public boolean checkOrder(DeparturePortal portal) {
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
